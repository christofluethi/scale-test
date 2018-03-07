package ch.shaped.scale.test.server.util;

import ch.shaped.scale.test.server.model.Environment;
import ch.shaped.scale.test.server.model.SystemInfo;

public class SystemInfoBuilder {

    private final SystemInfo entity;

    public SystemInfoBuilder() {
        this(new SystemInfo());
    }

    public SystemInfoBuilder(SystemInfo entity) {
        this.entity = entity;
    }

    public SystemInfoBuilder environment(Environment environment) {
        entity.setEnvironment(environment);
        return this;
    }

    public SystemInfoBuilder hostname(String hostname) {
        entity.setHostname(hostname);
        return this;
    }

    public SystemInfoBuilder ip(String ip) {
        entity.setIp(ip);
        return this;
    }

    public SystemInfoBuilder port(int port) {
        entity.setPort(port);
        return this;
    }

    public SystemInfoBuilder nodeId(String nodeId) {
        entity.setNodeId(nodeId);
        return this;
    }

    public SystemInfoBuilder osArch(String osArch) {
        entity.setOsArch(osArch);
        return this;
    }

    public SystemInfoBuilder osVersion(String osVersion) {
        entity.setOsVersion(osVersion);
        return this;
    }


    public SystemInfoBuilder osName(String osName) {
        entity.setOsName(osName);
        return this;
    }


    public SystemInfoBuilder appName(String appName) {
        entity.setAppName(appName);
        return this;
    }

    public SystemInfo build() {
        return entity;
    }
}
