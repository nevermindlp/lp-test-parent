package lp.security.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.common.collect.Lists;

import lp.security.domain.Role;
import lp.security.domain.User;

/**
 * Created by lvpeng01 on 2018/11/30.
 */
public class TokenUserAuthentication implements Authentication {

    @Autowired
    private RoleDao roleDao;

    private User user;

    private boolean authentication;

    public TokenUserAuthentication(User user, Boolean authentication) {
        this.user = user;
        this.authentication = authentication;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (user != null) {
            List<Role> roles = roleDao.findByUserId(user.getId());
            roles.forEach(role -> {
                GrantedAuthority ga = new SimpleGrantedAuthority(role.getName());
                grantedAuthorities.add(ga);
            });
        } else {
            throw new UsernameNotFoundException(" username : " + user.getUsername() + " do not exist.");
        }
        return grantedAuthorities;
    }

    @Override
    public Object getCredentials() {
        return user.getPassword();
    }

    @Override
    public Object getDetails() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user.getUsername();
    }

    @Override
    public boolean isAuthenticated() {
        return authentication;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.authentication = b;
    }

    @Override
    public String getName() {
        return user.getUsername();
    }
}
