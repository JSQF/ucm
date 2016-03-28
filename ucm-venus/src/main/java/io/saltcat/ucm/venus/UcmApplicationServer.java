package io.saltcat.ucm.venus;

import com.meidusa.toolkit.common.runtime.Application;
import com.meidusa.toolkit.common.runtime.ApplicationConfig;

/**
 * Created by huawei on 3/26/16.
 */
public class UcmApplicationServer extends Application<ApplicationConfig> {
    @Override
    protected String[] getConfigLocations() {
        return new String[]{"file:${project.home:.}/conf/ucm-application-context.xml"};
    }

    @Override
    public ApplicationConfig getApplicationConfig() {
        return null;
    }

    @Override
    public void doRun() {

    }

    public static void main(String[] args) {
        System.setProperty(ApplicationConfig.PROJECT_MAINCLASS, UcmApplicationServer.class.getName());
        Application.main(args);
    }
}
