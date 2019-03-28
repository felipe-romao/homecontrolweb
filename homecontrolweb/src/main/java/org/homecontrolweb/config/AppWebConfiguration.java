package org.homecontrolweb.config;

import org.homecontrolweb.repository.TransactionRepository;
import org.homecontrolweb.rest.controller.TransactionRestController;
import org.homecontrolweb.service.TransactionService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@EnableJpaRepositories(basePackages="org.homecontrolweb.repository")
@ComponentScan(basePackageClasses= { TransactionRepository.class, TransactionRestController.class,
		TransactionService.class, TransactionRepository.class })
public class AppWebConfiguration{

}
