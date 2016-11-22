package dependency_injection.test;

import dependency_injection.consumer.Consumer;
import dependency_injection.injector.EmailServiceInjector;
import dependency_injection.injector.MessageServiceInjector;
import dependency_injection.injector.SMSServiceInjector;
import dependency_injection.legacy.LegacyApp;

public class MyMessageDITest {
    public static void main(String[] args) {
        String msg = "Hi!";
        String email = "abs@abc.com";
        String phone = "+123456789";
        MessageServiceInjector injector = null;
        Consumer app = null;

        //Send email
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, email);

        //Send SMS
        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, phone);
    }
}
