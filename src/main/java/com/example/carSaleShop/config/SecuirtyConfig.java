package com.example.carSaleShop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecuirtyConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security)throws Exception{
        security.authorizeHttpRequests(auth->{
            auth.anyRequest().authenticated();
        }).formLogin(httpSecurityFormLoginConfigurer -> {

        }).httpBasic(httpSecurityHttpBasicConfigurer -> {

        });

        return security.build();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails= User.withUsername("test").password("test").build();
        return new InMemoryUserDetailsManager(userDetails);
    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
