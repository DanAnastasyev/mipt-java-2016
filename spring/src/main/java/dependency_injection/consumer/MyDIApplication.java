package dependency_injection.consumer;

import dependency_injection.service.MessageService;

public class MyDIApplication implements Consumer {
    private MessageService service;

    public MyDIApplication(MessageService svc){
        this.service=svc;
    }

    @Override
    public void processMessages(String msg, String rec){
        service.sendMessage(msg, rec);
    }
}
