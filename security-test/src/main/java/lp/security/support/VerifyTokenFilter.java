package lp.security.support;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lp.security.dao.TokenUserAuthentication;
import lp.security.dao.UserDao;
import lp.security.domain.User;

/**
 * Created by lvpeng01 on 2018/11/30.
 */
//@Component
public class VerifyTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserDao userDao;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = httpServletRequest.getHeader("token");
        // todo get user/pwd by token.
        String userName = "admin";
        String pwd = "123";
        Authentication authentication = getAuthentication(userName);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private Authentication getAuthentication(String userName) {
        User user = userDao.findByUserName(userName);
        TokenUserAuthentication userAuthentication = new TokenUserAuthentication(user, true);
        return userAuthentication;
    }

}
