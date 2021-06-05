package com.atibusinessgroup.bukutamu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.atibusinessgroup.bukutamu.filter.SimpleAuthenticationFilter;
import com.atibusinessgroup.bukutamu.filter.UserTravellerAuthenticationFilter;
import com.atibusinessgroup.bukutamu.service.CustomAuthenticationProvider;
import com.atibusinessgroup.bukutamu.service.CustomUserTravellerAuthenticationProvider;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public SecurityConfig() {
        super();
    }

//    @Autowired
//    private CustomAuthenticationProvider authProvider;
//
//    @Autowired
//    private CustomUserTravellerAuthenticationProvider userTravellerAuthProvider;
//
//    @Autowired
//    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
//
//    @Autowired
//    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authProvider);
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public LogoutSuccessHandler logoutSuccessHandler() {
//        return new CustomizeLogoutSuccessHandler();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder =
//                PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin")
//                .password("admin")
////                .password(encoder.encode("admin"))
//                .roles("ADMIN");
//    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//    	http.httpBasic().disable();
        http.cors().and()
                .csrf().disable()
//                .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/appointment").permitAll()
                .antMatchers("/appointment/approve").permitAll()
                .antMatchers("/appointment/reject").permitAll()
                .antMatchers("/bukutamu").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/?logout")

                .permitAll()
                .and()

                .exceptionHandling()
                .and()
                .sessionManagement().maximumSessions(1).expiredUrl("/")
                .and().invalidSessionUrl("/");
    }    
    


//    public SimpleAuthenticationFilter authenticationFilter() throws Exception {
//        SimpleAuthenticationFilter filter = new SimpleAuthenticationFilter();
//        filter.setAuthenticationManager(authenticationManagerBean());
//        filter.setAuthenticationFailureHandler(customAuthenticationFailureHandler);
//        filter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
//        return filter;
//    }
}

