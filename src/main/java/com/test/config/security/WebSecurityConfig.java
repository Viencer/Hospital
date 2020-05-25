package com.test.config.security;

import com.test.dao.DaoConnection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@ComponentScan("com.test")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static Logger logger = Logger.getLogger(WebSecurityConfig.class);

    private DaoConnection daoConnection;

    @Autowired
    public void setDaoConnection(DaoConnection daoConnection) {
        this.daoConnection = daoConnection;
    }

    @Override
    protected void configure(HttpSecurity http) {
        try {
            http.authorizeRequests().
                    antMatchers("/index", "/").permitAll()
                    .antMatchers("/admin", "/user").authenticated()
                    .and()
                    .formLogin()
                    .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/access");
        } catch (Exception e) {
            logger.error("error in configure. WebSecurityConfig.class ", e);
        }
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationMgr) {
        try {
            authenticationMgr.jdbcAuthentication().dataSource(daoConnection.getDataSource()).passwordEncoder(NoOpPasswordEncoder.getInstance())
                    .usersByUsernameQuery(
                            "select USER_NAME, PASSWORD, ENABLE from LAB3MU_USER_DATA where USER_NAME = ?")
                    .authoritiesByUsernameQuery(
                            "select USER_NAME, ROLE from LAB3MU_USER_DATA where USER_NAME = ?");

        } catch (Exception e) {
            logger.error("error in configure. WebSecurityConfig.class ", e);
        }
    }
}