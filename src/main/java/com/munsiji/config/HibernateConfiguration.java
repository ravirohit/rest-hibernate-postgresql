package com.munsiji.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@EnableTransactionManagement
@ComponentScan({ "com.websystique.spring.configuration" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

}
