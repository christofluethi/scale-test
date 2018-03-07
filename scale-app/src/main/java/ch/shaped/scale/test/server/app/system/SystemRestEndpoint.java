package ch.shaped.scale.test.server.app.system;

import ch.shaped.scale.test.server.util.SwarmUtil;
import ch.shaped.scale.test.server.util.SystemInfoBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wildfly.swarm.spi.api.config.ConfigView;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Stateless
@Path(value = "/system")
public class SystemRestEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(SystemRestEndpoint.class);

    @Inject
    private ConfigView swarmConfig;

    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public Response info() {
        logger.info("SystemInfo RestCall");

        SystemInfoBuilder builder = new SystemInfoBuilder()
                .environment(SwarmUtil.getEnvironment(swarmConfig))
                .port(SwarmUtil.getIntegerProperty(swarmConfig, SwarmUtil.SWARM_PORT))
                .nodeId(SwarmUtil.getStringProperty(swarmConfig, SwarmUtil.NODE_ID))
                .osName(SwarmUtil.getStringProperty(swarmConfig, SwarmUtil.OS_NAME))
                .osArch(SwarmUtil.getStringProperty(swarmConfig, SwarmUtil.OS_ARCH))
                .osVersion(SwarmUtil.getStringProperty(swarmConfig, SwarmUtil.OS_VERSION))
                .appName(SwarmUtil.getStringProperty(swarmConfig, SwarmUtil.SWARM_APP_NAME));

        try {
            InetAddress address = InetAddress.getLocalHost();
            builder.ip(address.getHostAddress());
            builder.hostname(address.getHostName());
        } catch(UnknownHostException e) {
            Response.serverError().build();
        }

        return Response.ok(builder.build()).build();
    }
}