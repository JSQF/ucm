package io.saltcat.ucm.web.security;

import io.saltcat.ucm.service.RoleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huawei on 4/4/16.
 */
public class DatabaseFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    protected final Log logger = LogFactory.getLog(getClass());

    private final Map<RequestMatcher, Collection<ConfigAttribute>> requestMap = new HashMap<>();


    private RoleService roleService;

    @PostConstruct
    public void loadRequestMap(){

    }


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
