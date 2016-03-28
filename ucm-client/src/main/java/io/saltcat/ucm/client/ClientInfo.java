package io.saltcat.ucm.client;

import io.saltcat.ucm.exception.UcmException;
import io.saltcat.ucm.exception.client.UnknownLocalHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by huawei on 3/20/16.
 */
public class ClientInfo {

    private static Logger logger = LoggerFactory.getLogger(ClientInfo.class);

    private String home;
    private String host;

    public String getHome() {
        return home;
    }

    public String getHost() {
        return host;
    }

    public void load() throws UcmException{
        home = System.getProperty("user.home");
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            logger.warn("cannot ", e);
            throw new UnknownLocalHostException(e);
        }

        if(logger.isDebugEnabled()) {
            logger.debug("localhost:" + host);
            logger.debug("user home:" + home);
        }
    }

}
