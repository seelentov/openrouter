package ru.vladislavkomkov.openrouter;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.vladislavkomkov.openrouter.model.Message;
import ru.vladislavkomkov.openrouter.service.ai.AiService;
import ru.vladislavkomkov.openrouter.service.ai.OpenRouterServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String OPEN_ROUTER_MODEL = "deepseek/deepseek-chat:free";
        double OPEN_ROUTER_TEMPERATURE = 0.1;
        String OPEN_ROUTER_TOKEN = "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";
        String OPEN_ROUTER_API = "https://openrouter.ai/api/v1/chat/completions";
        ObjectMapper objectMapper = new ObjectMapper();

        AiService aiService = new OpenRouterServiceImpl(
                OPEN_ROUTER_MODEL,
                OPEN_ROUTER_TEMPERATURE,
                OPEN_ROUTER_TOKEN,
                OPEN_ROUTER_API,
                objectMapper
        );

        List<Message> messages = new ArrayList<>();

        messages.add(new Message("Привет. В чем смысл жизни?", false));

        try {
            String answer = aiService.getAnswer(messages);
            System.out.println(answer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}