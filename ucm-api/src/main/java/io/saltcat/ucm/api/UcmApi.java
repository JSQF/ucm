package io.saltcat.ucm.api;

import com.meidusa.venus.annotations.Endpoint;
import com.meidusa.venus.annotations.Param;
import com.meidusa.venus.annotations.Service;
import io.saltcat.ucm.exception.UcmException;

import java.util.List;

/**
 * Created by huawei on 3/18/16.
 */
@Service(name = "UcmApi", description = "统一配置服务")
public interface UcmApi {

    @Endpoint
    List getProperties(@Param(name = "host")String host, @Param(name = "project")String project, @Param(name = "version")String version) throws UcmException;

}
