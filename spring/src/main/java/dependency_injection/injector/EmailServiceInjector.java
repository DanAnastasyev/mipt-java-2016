package dependency_injection.injector;

import dependency_injection.consumer.Consumer;
import dependency_injection.consumer.MyDIApplication;
import dependency_injection.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {
    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new EmailServiceImpl());
    }
}
