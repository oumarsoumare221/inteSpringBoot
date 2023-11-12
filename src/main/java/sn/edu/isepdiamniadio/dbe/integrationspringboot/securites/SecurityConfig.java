package sn.edu.isepdiamniadio.dbe.integrationspringboot.securites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import sn.edu.isepdiamniadio.dbe.integrationspringboot.services.VoterService;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    // @Autowired
    // private VoterService voterService;

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeRequests()
    //             .antMatchers("/api/voters/register").permitAll()
    //             .antMatchers("/api/candidates").permitAll()
    //             .antMatchers("/api/voting/cast-vote").authenticated()
    //             .antMatchers("/api/results").hasRole("CANDIDATE")
    //             .and()
    //         .formLogin()
    //             .loginPage("/api/voters/login")
    //             .and()
    //         .logout()
    //             .logoutUrl("/api/voters/logout")
    //             .and()
    //         .csrf().disable(); // Pour simplifier l'exemple, désactivez CSRF
    // }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.userDetailsService(voterService).passwordEncoder(passwordEncoder());
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
