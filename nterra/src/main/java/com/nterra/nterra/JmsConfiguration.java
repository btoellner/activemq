package com.nterra.nterra;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfiguration {
	@Value("${broker-uri}") 
	private String brokerUrl;
	
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		return new ActiveMQConnectionFactory(brokerUrl);
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
	}
}
