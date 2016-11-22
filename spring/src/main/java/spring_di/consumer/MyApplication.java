package spring_di.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring_di.services.MessageService;

@Component
public class MyApplication {

	//field-based dependency injection
	//@Autowired
	private MessageService service;
	
//	constructor-based dependency injection	
//	@Autowired
//	public MyApplication(MessageService svc){
//		service =svc;
//	}
	
	@Autowired
	public void setService(MessageService svc){
		service = svc;
	}
	
	public boolean processMessage(String msg, String rec){
		//some magic like validation, logging etc
		return service.sendMessage(msg, rec);
	}
}
