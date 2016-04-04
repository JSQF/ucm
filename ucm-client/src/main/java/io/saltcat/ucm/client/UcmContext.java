package io.saltcat.ucm.client;

import java.util.Properties;

/**
 * Created by huawei on 3/20/16.
 */
public final class UcmContext {

    private static UcmContext context = new UcmContext();

    private UcmContext(){

    }

    /**
     * UCM Info
     **/
    private UcmInfo ucmInfo = new UcmInfo();

    /**
     * Client Info
     **/
    private ClientInfo clientInfo = new ClientInfo();

    private Properties properties = new Properties();

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public UcmInfo getUcmInfo() {
        return ucmInfo;
    }

    public static UcmContext getContext() {
        return context;
    }

    public void add(Properties properties) {
        if (properties == null) {
            return;
        }
        Properties sys = System.getProperties();
        sys.putAll(properties);
        System.setProperties(sys);
        this.properties.putAll(properties);
    }

    private void add(String key, String value) {
        if (key == null) {
            return;
        }
        System.setProperty(key, value);
        properties.put(key, value);
    }

    public String get(String key) {
        return properties.getProperty(key);
    }


}
