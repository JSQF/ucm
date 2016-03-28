package io.saltcat.ucm.client.web;

import io.saltcat.ucm.client.UcmClient;
import io.saltcat.ucm.client.UcmClientConstants;
import io.saltcat.ucm.exception.UcmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by huawei on 3/20/16.
 */
public class UcmContextLoaderListener implements ServletContextListener {

    private static Logger logger = LoggerFactory.getLogger(UcmContextLoaderListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String location = servletContextEvent.getServletContext().getInitParameter(UcmClientConstants.UCM_PROPERTY_FILE_LOCATION_NAME);
        UcmClient client = new UcmClient();
        if (location != null) {
        }
        try {
            client.loadProperties();
        } catch (UcmException e) {
            logger.error("load ucm exception", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
