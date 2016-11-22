package spring_di.services;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService {
	public boolean sendMessage(String msg, String rec) {
		System.out.println("Email Sent to " + rec+ " with Message=" + msg);
		return true;
	}
}
