package fi.haagahelia.palvelinohtu.BookStore2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    
		 @Autowired UserDetailsService userDetailsService;	
			
		    @Override
		    protected void configure(HttpSecurity http) throws Exception {
		        http
		        .authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
		        .and()
		        .authorizeRequests().antMatchers("/signup", "/saveuser").permitAll()
		        .and()
		        .authorizeRequests().anyRequest().authenticated()
		        .and()
		      .formLogin()
		          .loginPage("/login")
		          .defaultSuccessUrl("/bookStore", true)
		          .permitAll()
		          .and()
		      .logout()
		          .permitAll();
		    }
	

		    @Autowired
		    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		    }

}

