package spring_di.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_di.consumer.MyXMLApplication;

public class ClientXMLApplication {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		MyXMLApplication app = context.getBean(MyXMLApplication.class);

		app.processMessage("Hi!", "abs@abc.com");

		// close the context
		context.close();
	}
}
