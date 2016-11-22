package dependency_injection.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import dependency_injection.consumer.Consumer;
import dependency_injection.consumer.MyDIApplication;
import dependency_injection.injector.MessageServiceInjector;

public class MyDIApplicationJUnitTest {
    private MessageServiceInjector injector;

    @Before
    public void setUp(){
        //mock the injector with anonymous class
        injector = () -> {
            //mock the message service
            return new MyDIApplication(
                (msg, rec) -> System.out.println("Mock Message Service implementation"));
        };
    }

    @Test
    public void test() {
        Consumer consumer = injector.getConsumer();
        consumer.processMessages("Hi!", "abs@abc.com");
    }

    @After
    public void tear(){
        injector = null;
    }
}