package com.example.act456;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)

public class WebSecurityConfig {

@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((request)-> {
            try {
                request
                        //mis urls que estan en request no van a necesitar clave de acceso
                        .requestMatchers(new AntPathRequestMatcher("/api/laptops")).permitAll()
                        // las otras urls que no incluyo en mi request si me van a pedir acceder con el login generado
                        .anyRequest().authenticated()
                        .and()
                        .httpBasic();
                } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return http.build();
    }



    public void configura (AuthenticationManagerBuilder auth) throws Exception{
    //creo en memoria los usuarios y les asigno los valores que yo quiero
     auth.inMemoryAuthentication()
             .passwordEncoder(passwordEncoder())
          .withUser("user").password(passwordEncoder().encode("user123")).roles("USER")
           .and()
           .withUser("admin").password(passwordEncoder().encode("admin123")).roles("USER" , "ADMIN");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
