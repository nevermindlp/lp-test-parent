package lp.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import lp.security.support.CustomAuthFilter;
import lp.security.support.CustomSuccessHandler;

/**
 * Created by lvpeng01 on 2018/12/3.
 */
public class CustomConfigurer extends AbstractHttpConfigurer<CustomConfigurer, HttpSecurity> {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        CustomAuthFilter customAuthFilter = new CustomAuthFilter("/**");
        customAuthFilter.setAuthenticationSuccessHandler(new CustomSuccessHandler());
        http.addFilterBefore(customAuthFilter, FilterSecurityInterceptor.class);
    }
}
