package io.saltcat.ucm.client;

import com.meidusa.venus.client.simple.SimpleServiceFactory;
import io.saltcat.ucm.api.UcmApi;
import io.saltcat.ucm.exception.UcmException;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by huawei on 3/20/16.
 */
public class UcmClient {

    private static Logger logger = LoggerFactory.getLogger(UcmClient.class);

    private boolean autoReload = true;

    public UcmClient() {

    }

    public void loadProperties() throws UcmException{
        UcmContext.getContext().getClientInfo().load();
        UcmContext.getContext().getUcmInfo().load();
        loadRemoteProperties();
        loadLocalProperties();

        if (logger.isDebugEnabled()) {

        }


        if (autoReload) {

        }
    }

    private void loadRemoteProperties() {
        String host = UcmContext.getContext().getClientInfo().getHost();
        String project = UcmContext.getContext().getUcmInfo().getProject();
        String version = UcmContext.getContext().getUcmInfo().getVersion();
        List<UcmServer> serverList = UcmContext.getContext().getUcmInfo().getServerList();
        if (serverList == null || serverList.size() == 0) {
            logger.warn("unknown remote server");
            return;
        }else {
            for(UcmServer server : serverList) {
                try{
                    //SimpleServiceFactory ssf = new SimpleServiceFactory(server.getHost(), server.getPort());
                    //UcmApi ucmApi = ssf.getService(UcmApi.class);
                    //List properties = ucmApi.getProperties(host, project, version);

                }catch (Exception e) {
                    logger.error("load remote properties error: " + server, e);
                    continue;
                }
                break;
            }
        }



    }

    private void loadLocalProperties(){
        String localPropertyFileLocation = UcmContext.getContext().getClientInfo().getHome() + UcmClientConstants.SLASH + UcmContext.getContext().getUcmInfo().getProject() + ".properties";
        File localPropertyFile = new File(localPropertyFileLocation);
        if (!localPropertyFile.exists()) {
            logger.warn(localPropertyFileLocation + " doesn't exists, use remote properties");
        }else {
            logger.warn("use local properties to recover remote properties");

            BufferedInputStream bis = null;
            try{
                bis = new BufferedInputStream(new FileInputStream(localPropertyFile));
                Properties localProperties = new Properties();
                localProperties.load(bis);
                UcmContext.getContext().add(localProperties);
            }catch (IOException e) {
                logger.error("load local properties file exception: ", e);
            }finally {
                IOUtils.closeQuietly(bis);
            }
        }
    }

    public void setAutoReload(boolean autoReload) {
        this.autoReload = autoReload;
    }
}
