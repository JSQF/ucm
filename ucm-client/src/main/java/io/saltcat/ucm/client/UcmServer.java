package io.saltcat.ucm.client;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by huawei on 3/20/16.
 */
public class UcmServer {
    private String host;
    private Integer port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
