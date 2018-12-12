package lp.security.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import lp.security.dao.TokenUserAuthentication;
import lp.security.dao.UserDao;
import lp.security.domain.User;
import lp.security.exception.TokenException;

/**
 * Created by lvpeng01 on 2018/12/3.
 */
public class CustomAuthFilter extends AbstractAuthenticationProcessingFilter {

    public CustomAuthFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws
            AuthenticationException {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new TokenException("token missing.");
        }
        // todo get user/pwd by token.
        String userName = "admin";
        String pwd = "123";
        return getAuthentication(request, userName);
    }
    private Authentication getAuthentication(HttpServletRequest request, String userName) {
        UserDao userDao = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext()).getBean
                (UserDao.class);
        User user = userDao.findByUserName(userName);
        return new TokenUserAuthentication(user, true);
    }
}
