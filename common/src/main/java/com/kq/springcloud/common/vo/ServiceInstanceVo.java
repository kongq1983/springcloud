package com.kq.springcloud.common.vo;

import java.net.URI;
import java.util.Map;


public class ServiceInstanceVo {

    private String serviceId;
    private String host;
    private int port;
    private boolean secure;

    private URI uri;
    private Map<String, String> metadata;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "ServiceInstanceVo{" +
                "serviceId='" + serviceId + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", secure=" + secure +
                ", uri=" + uri +
                ", metadata=" + metadata +
                '}';
    }
}
