package com.phonerep.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**"); // #3
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        String[] resources = new String[] { "/resources", "/home", "/pictureCheckCode", "/include/**", "/css/**",
                "/icons/**", "/images/**", "/js/**", "/layer/**", "/static/**" };

        http.authorizeRequests().antMatchers(resources).permitAll().antMatchers("/admin").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/newbookingjs").permitAll().antMatchers("/bestil-tid").permitAll()
                .antMatchers("/createmovie").hasRole("ADMIN").antMatchers("/createemployee").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN", "USER").antMatchers("/**").permitAll().antMatchers("/")
                .permitAll().and().formLogin();

    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();

    }

}
