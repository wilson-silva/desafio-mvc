package com.gft.gerenciadorEventos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/usuario/novo").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin(form -> form
                        .loginPage("/").defaultSuccessUrl("/home", true)
                        .permitAll()
                ).logout(logout -> logout.logoutUrl("/logout"));

        http.csrf().disable();
        http.headers().frameOptions().disable();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .and()
                .withUser("user1")
                .password(passwordEncoder().encode("user1"))
                .roles("USER")
                .and()
                .withUser("user2")
                .password(passwordEncoder().encode("user2"))
                .roles("USER");



    }

}

