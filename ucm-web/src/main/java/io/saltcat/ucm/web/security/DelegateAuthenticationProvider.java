package io.saltcat.ucm.web.security;

import io.saltcat.ucm.service.RoleService;
import io.saltcat.ucm.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

/**
 * Created by huawei on 4/4/16.
 */
public class DelegateAuthenticationProvider implements AuthenticationProvider {

    private ActiveDirectoryLdapAuthenticationProvider delegate;
    private UserService userService;
    private RoleService roleService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Authentication passed = this.delegate.authenticate(authentication);



        SecurityContextHolder.getContext().setAuthentication(authentication);

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return this.delegate.supports(authentication);
    }
}
