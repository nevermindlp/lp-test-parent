package lp.security.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.sym.NameN;
import com.google.common.collect.Lists;

import lp.security.dao.PermissionDao;
import lp.security.dao.RoleDao;
import lp.security.dao.UserDao;
import lp.security.domain.Resource;
import lp.security.domain.Role;
import lp.security.domain.User;

/**
 * Created by lvpeng01 on 2018/6/13.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUserName(username);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (user != null) {
            List<Role> roles = roleDao.findByUserId(user.getId());
            roles.forEach(role -> {
                GrantedAuthority ga = new SimpleGrantedAuthority(role.getName());
                grantedAuthorities.add(ga);
            });

            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    grantedAuthorities);
        } else {
            throw new UsernameNotFoundException(" username : " + username + " do not exist.");
        }
    }
}
