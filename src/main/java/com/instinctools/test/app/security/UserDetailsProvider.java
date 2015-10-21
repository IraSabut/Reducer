package com.instinctools.test.app.security;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.instinctools.test.domain.service.UserService;
import com.instinctools.test.domain.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsProvider implements UserDetailsService, Serializable{

    private static final long serialVersionUID = 2405751661314965775L;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        if (username == null) throw new RuntimeException("Empty user name has been provided");

        final UserPrincipal principal = userService.getUserByName(username);
        System.out.println(principal);
        if (principal == null)
            throw (new UsernameNotFoundException("User '" + username + "' not found"));

        return new UserDetails() {

            private static final long serialVersionUID = -8161090011273147665L;

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public String getUsername() {
                return principal.getLogin();
            }

            @Override
            public String getPassword() {
                return principal.getPassword();
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();


                return auths;
            }
        };
    }


}
