package lp.security.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import lp.security.dao.TokenUserAuthentication;
import lp.security.dao.UserDao;
import lp.security.domain.User;

/**
 * Created by lvpeng01 on 2018/11/30.
 */
public class CustomUsernamePasswordFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private UserDao userDao;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws
            AuthenticationException {
        String token = request.getHeader("token");
        // todo get user/pwd by token.
        String userName = "admin";
        String pwd = "123";
        return getAuthentication(userName);
    }
    private Authentication getAuthentication(String userName) {
        User user = userDao.findByUserName(userName);
        TokenUserAuthentication userAuthentication = new TokenUserAuthentication(user, true);
        return userAuthentication;
    }
}
