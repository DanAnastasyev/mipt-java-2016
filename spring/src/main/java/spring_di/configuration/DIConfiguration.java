package spring_di.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring_di.services.EmailService;
import spring_di.services.MessageService;

@Configuration
public class DIConfiguration {
	@Bean
	public MessageService getMessageService(){
		return new EmailService();
	}
}

