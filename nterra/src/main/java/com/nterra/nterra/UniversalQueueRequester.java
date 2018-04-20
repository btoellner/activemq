package com.nterra.nterra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class UniversalQueueRequester {	
	
	@Autowired
	public Gson gson;
	
	@Autowired
	public JmsTemplate jmsTemplate;
	
	public void placeInQueue(final String queueName, final Object obj) {
		final String message = gson.toJson(obj, obj.getClass());
		
		jmsTemplate.convertAndSend(queueName, message);
	}
}