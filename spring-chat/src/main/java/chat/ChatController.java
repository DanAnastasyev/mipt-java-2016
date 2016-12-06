package chat;

import java.util.ArrayList;
import java.util.List;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    private List<Message> messages = new ArrayList<>();

    @SubscribeMapping("/connect")
    public List<Message> onConnect() {
        return messages;
    }

    @MessageMapping("/send")
    @SendTo("/chat")
    public Message sendMessage(Message message) throws Exception {
        messages.add(message);

        return message;
    }
}
