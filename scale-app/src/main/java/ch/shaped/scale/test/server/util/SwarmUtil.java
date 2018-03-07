package ch.shaped.scale.test.server.util;

import ch.shaped.scale.test.server.model.Environment;
import org.wildfly.swarm.spi.api.config.ConfigView;

public class SwarmUtil {

    public static final String ENVIRONMENT = "environment";
    public static final String DEFAULT_ENVIRONMENT = "default";
    public static final String SWARM_PORT = "swarm.http.port";
    public static final String NODE_ID = "swarm.node.id";
    public static final String SWARM_APP_NAME = "swarm.app.name";
    public static final String OS_NAME = "os.name";
    public static final String OS_ARCH = "os.arch";
    public static final String OS_VERSION = "os.version";

    public static Environment getEnvironment(ConfigView swarmConfig) {
        if(swarmConfig == null) {
            return null;
        }

        String env = swarmConfig.resolve(ENVIRONMENT).getValue().toLowerCase();
        if (env.equalsIgnoreCase(DEFAULT_ENVIRONMENT)) {
            return Environment.DEVELOPMENT;
        } else {
            return Environment.valueOf(env);
        }
    }

    public static Integer getIntegerProperty(ConfigView swarmConfig, String name) {
        if(swarmConfig == null) {
            return null;
        }

        String port = getStringProperty(swarmConfig, name);
        if(port != null) {
            try {
                return Integer.parseInt(port);
            } catch(NumberFormatException e) {
                /* ignore */
            }
        }

        return null;
    }

    public static String getStringProperty(ConfigView swarmConfig, String name) {
        if(swarmConfig == null) {
            return null;
        }

        if(swarmConfig.resolve(name).hasValue()) {
            return swarmConfig.resolve(name).getValue();
        }

        return null;
    }
}
