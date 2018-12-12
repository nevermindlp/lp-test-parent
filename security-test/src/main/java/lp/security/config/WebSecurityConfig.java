package lp.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lp.security.support.CustomUsernamePasswordFilter;
import lp.security.support.MyFilterSecurityInterceptor;
import lp.security.support.VerifyTokenFilter;

/**
 * Created by lvpeng01 on 2018/6/12.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

//    @Autowired
//    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
//
//    @Autowired
//    private VerifyTokenFilter verifyTokenFilter;

//    @Autowired
//    private CustomConfigurer customConfigurer;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider()
        auth.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/css/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/")
//                .failureUrl("/login?error")
//                .permitAll()
//                .and()
//            .csrf()
//                .disable()
//            .logout()
//                .permitAll();
////        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
////        http.addFilterBefore(CustomUsernamePasswordFilter, UsernamePasswordAuthenticationFilter.class);
//        http.addFilterBefore(new CustomUsernamePasswordFilter(), UsernamePasswordAuthenticationFilter.class);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.authorizeRequests()
//                .antMatchers("/css/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .apply(new CustomConfigurer("/login"));

        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .apply(new CustomConfigurer());
    }
}
