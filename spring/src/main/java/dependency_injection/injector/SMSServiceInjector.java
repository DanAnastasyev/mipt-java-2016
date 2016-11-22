package dependency_injection.injector;

import dependency_injection.consumer.Consumer;
import dependency_injection.consumer.MyDIApplication;
import dependency_injection.service.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector {
    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new SMSServiceImpl());
    }
}
