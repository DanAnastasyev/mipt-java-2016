package dependency_injection.injector;

import dependency_injection.consumer.Consumer;

public interface MessageServiceInjector {
    public Consumer getConsumer();
}
