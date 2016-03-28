package io.saltcat.ucm.client;

import io.saltcat.ucm.exception.UcmException;
import io.saltcat.ucm.exception.client.UcmConfigException;
import io.saltcat.ucm.exception.client.UcmConfigFileNotFoundException;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by huawei on 3/20/16.
 */
public class UcmInfo {

    private Logger logger = LoggerFactory.getLogger(UcmInfo.class);

    private List<UcmServer> serverList;
    private String project;
    private String version;

    public List<UcmServer> getServerList() {
        return serverList;
    }

    public void setServerList(List<UcmServer> serverList) {
        this.serverList = serverList;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void load() throws UcmException{

        InputStream is = null;

        Properties props = new Properties();

        try{
            is = UcmInfo.class.getResourceAsStream("/ucm.properties");
            if (is == null) {
                throw new UcmConfigFileNotFoundException("ucm.properties not found in the classpath.");
            }
            props.load(is);
        }catch(Exception e) {
            throw new UcmConfigException("load ucm.properties failed.", e);
        }finally {
            IOUtils.closeQuietly(is);
        }

        String ipAddressListStr = props.getProperty("ucm.ipAddressList");
        this.project = props.getProperty("ucm.project");
        this.version = props.getProperty("ucm.project.version");

        if (ipAddressListStr == null) {
            logger.warn("ucm.ipAddressList cannot be empty");
        }else  {
            String[] ipAddressListArray = ipAddressListStr.split(",");

            if (ipAddressListArray == null || ipAddressListArray.length == 0) {
                throw new UcmConfigException("ucm.ipAddressList cannot be empty");
            }

            List<UcmServer> serverList = new ArrayList<>();

            for(String ipAddress : ipAddressListArray) {
                String[] array = ipAddress.split(":");
                if (array == null || array.length != 2) {
                    throw new UcmConfigException("ucm.ipAddress is not illegal format");
                }

                UcmServer server = new UcmServer();
                server.setHost(array[0]);
                try{
                    server.setPort(Integer.parseInt(array[1]));
                    if (server.getPort() < 0 || server.getPort() > 65535) {
                        throw new NumberFormatException("port cannot be negative or grate than 65535");
                    }
                }catch(NumberFormatException nfe) {
                    throw new UcmConfigException(ipAddress  + " port is not a number", nfe);
                }

                serverList.add(server);
            }
        }



        UcmContext.getContext().getUcmInfo().setServerList(serverList);
        UcmContext.getContext().getUcmInfo().setProject(project);
        UcmContext.getContext().getUcmInfo().setVersion(version);

    }
}
