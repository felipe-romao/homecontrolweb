package org.homecontrolweb.config;


import java.time.format.DateTimeFormatter;

import org.homecontrolweb.repository.TransactionRepository;
import org.homecontrolweb.rest.controller.TransactionRestController;
import org.homecontrolweb.service.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableJpaRepositories(basePackages="org.homecontrolweb.repository")
@ComponentScan(basePackageClasses= { TransactionRepository.class, TransactionRestController.class,
		TransactionService.class, TransactionRepository.class })
public class AppWebConfiguration{
	
	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		
		//DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		//registrar.setFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
		//registrar.registerFormatters(conversionService);
		
		
		DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
		registrar.setDateFormatter(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		registrar.registerFormatters(conversionService);
		
		return conversionService;
	}
}
