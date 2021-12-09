package com.example.couponsvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebSercurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public WebSercurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                mvcMatchers(HttpMethod.GET,"/api/coupon/{CODE:[A-Z]*$}","/index","/couponresponse",
                        "/web/showcoupon","allcouponsresponse","/web/getcoupon").hasAnyRole("USER","ADMIN").
                         mvcMatchers(HttpMethod.POST,"/web/getcoupon").hasAnyRole("USER","ADMIN").
                mvcMatchers(HttpMethod.GET,"/web/showcreatecoupon").hasRole("ADMIN").
                mvcMatchers(HttpMethod.POST,"/api/coupon","/coupon","/web/save","",
                        "/web/getcoupon").hasRole("ADMIN")
                .mvcMatchers("/login","/","/showreg","/registerUser").permitAll()
                .anyRequest().denyAll()
                .and()
                .csrf().disable().
                logout().logoutSuccessUrl("/").invalidateHttpSession(true);
    }
}
