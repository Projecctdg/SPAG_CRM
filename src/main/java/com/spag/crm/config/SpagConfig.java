package com.spag.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class SpagConfig
{
    @Bean
    AllService getAllService()
	{
		return new AllService();
	}
    
    @Bean
    JavaMailSender  getJavaMailSender() 
    {
		return new JavaMailSenderImpl();
    }

}
