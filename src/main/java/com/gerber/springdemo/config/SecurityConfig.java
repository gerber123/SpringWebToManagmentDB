package com.gerber.springdemo.config;

import com.gerber.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    // add a reference to our security data source
    @Autowired
    private UserService userService;
//    @Autowired
//    private DataSource securityDataSource;
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // use jdbc authentication ... oh yeah!!!

//        auth.jdbcAuthentication().dataSource(securityDataSource);
        auth.authenticationProvider(authenticationProvider());
    }

        @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/player/showForm*").hasAnyRole("MANAGER", "ADMIN","EMPLOYEE")
                .antMatchers("/player/save*").hasAnyRole("MANAGER", "ADMIN","EMPLOYEE")
                .antMatchers("/player/delete").hasRole("ADMIN")
                .antMatchers("/player/**").hasRole("EMPLOYEE")
                .antMatchers("/user/**").permitAll()
                .antMatchers("/homepage").hasAnyRole("MANAGER","ADMIN","EMPLOYEE")
                .antMatchers("/resources/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .successHandler(customAuthenticationSuccessHandler)
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");}
//    }
//    @Bean
//    public UserDetailsManager userDetailsManager() {
//
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
//
//        jdbcUserDetailsManager.setDataSource(securityDataSource);
//
//        return jdbcUserDetailsManager;
//    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //authenticationProvider bean definition
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
}