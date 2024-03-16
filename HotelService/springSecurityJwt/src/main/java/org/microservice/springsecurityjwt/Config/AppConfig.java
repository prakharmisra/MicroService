package org.microservice.springsecurityjwt.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

    @Bean
    public UserDetailsService userDetailService(){

       UserDetails userDetails =  User.withUsername("prk").password(passwordEncoder().encode("prk"))
                .roles("ADMIN").build();

        UserDetails userDetails2 =  User.withUsername("raj").password(passwordEncoder().encode("raj"))
                .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(userDetails,userDetails2);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
