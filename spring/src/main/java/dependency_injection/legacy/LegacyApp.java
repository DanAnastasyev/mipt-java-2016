package dependency_injection.legacy;

import spring_di.services.EmailService;

public class LegacyApp {
    private EmailService emailService = new EmailService();

    public void processMessages(String msg, String rec){
        emailService.sendMessage(msg, rec);
    }

    public static void main(String[] args) {
        LegacyApp app = new LegacyApp();
        app.processMessages("Hi!", "abs@abc.com");
    }
}
