package io.saltcat.ucm.venus.impl;

import com.meidusa.venus.annotations.Param;
import io.saltcat.ucm.api.UcmApi;
import io.saltcat.ucm.domain.Environment;
import io.saltcat.ucm.exception.UcmException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by huawei on 3/26/16.
 */
@Component(value = "DefaultUcmApi")
public class DefaultUcmApi implements UcmApi {

    @Override
    public List getProperties(@Param(name = "host") String host, @Param(name = "project") String project, @Param(name = "version") String version) throws UcmException {

        Environment environment = null;

        try{
            if (environment == null) {
                ;
            }

            String environmentCode = environment.getCode();
        }catch (Exception e) {

        }



        return null;
    }
}
