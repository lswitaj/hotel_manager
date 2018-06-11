package com.proz.hotel_manager.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.proz.hotel_manager.domain.Client;
import com.proz.hotel_manager.domain.Employee;
import com.proz.hotel_manager.service.ClientService;
import com.proz.hotel_manager.service.EmployeeService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public ClientService clientService;

	@Autowired
	public EmployeeService employeeService;

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	/* TODO add new users */
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		List<Client> clients = clientService.getAllClients();
		for (Client client : clients) {
			auth.inMemoryAuthentication().withUser(client.getLogin()).password(client.getPassword()).roles("CLIENT");
		}
		
		List<Employee> employees = employeeService.getAllEmployees();
		for (Employee employee : employees) {
			if(employee.getPosition().equals("manager"))
				auth.inMemoryAuthentication().withUser(employee.getPesel()).password(employee.getPassword()).roles("MANAGER");
			else
				auth.inMemoryAuthentication().withUser(employee.getPesel()).password(employee.getPassword()).roles("EMPLOYEE");
		}
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.formLogin()
			.loginPage("/login")
			.usernameParameter("userId")
			.passwordParameter("password");
			//.passwordParameter(passwordEncoder.encode("password"));
		
		httpSecurity.formLogin()
			.defaultSuccessUrl("/welcome")
			.failureUrl("/login?error");

		httpSecurity.logout().logoutSuccessUrl("/login?logout");

		httpSecurity.exceptionHandling().accessDeniedPage("/login?accessDenied");

		httpSecurity.authorizeRequests()
			.antMatchers("/welcome").permitAll()
			.antMatchers("/logout").permitAll()
			.antMatchers("/client/**").access("hasRole('CLIENT')")
			.antMatchers("/employee/**").access("hasRole('EMPLOYEE')")
			.antMatchers("/boss/**").access("hasRole('MANAGER')");

		httpSecurity.csrf().disable();
	}
}