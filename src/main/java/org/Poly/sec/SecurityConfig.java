package org.Poly.sec;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;







@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private   DataSource datasource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		
		
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.usersByUsernameQuery(
				"select login as principal, pass as credentials, true from user where login= ?")
		.authoritiesByUsernameQuery(
				"select user.login as principal, role.type_role as role  from  user,  role where user.login=? and user.code_role=role.id_role")
		.rolePrefix("ROLE_");
		
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		http
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/*").permitAll();
     
		
			http.httpBasic();
		
			http.csrf().disable();		
		
		//http.authorizeRequests().anyRequest().fullyAuthenticated();
	//	
	
		//http.httpBasic();
		
		//http.csrf().disable();
		
		
	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/motdepassoublier");
	}
	
	
}
