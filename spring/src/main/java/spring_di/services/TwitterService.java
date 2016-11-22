package spring_di.services;

import org.springframework.stereotype.Component;

@Component
public class TwitterService implements MessageService {
	public boolean sendMessage(String msg, String rec) {
		System.out.println("Twitter message Sent to " + rec + " with Message="+msg);
		return true;
	}
}
