package spring_di.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_di.configuration.DIConfiguration;
import spring_di.consumer.MyApplication;

public class ClientApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DIConfiguration.class);
		MyApplication app = context.getBean(MyApplication.class);
		
		app.processMessage("Hi!", "abs@abc.com");
		
		//close the context
		context.close();
	}
}
