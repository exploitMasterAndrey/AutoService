package com.rtumirea.autoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AutoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoServiceApplication.class, args);
	}

}
