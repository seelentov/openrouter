package ru.vladislavkomkov.openrouter.service.ai;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import ru.vladislavkomkov.openrouter.exception.AIRequestException;
import ru.vladislavkomkov.openrouter.model.Message;
import ru.vladislavkomkov.openrouter.service.ai.dto.RequestBody;
import ru.vladislavkomkov.openrouter.service.ai.dto.ResponseBody;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RequiredArgsConstructor
public class OpenRouterServiceImpl implements AiService {
    private final String OPEN_ROUTER_MODEL;
    private final double OPEN_ROUTER_TEMPERATURE;

    private final String OPEN_ROUTER_TOKEN;
    private final String OPEN_ROUTER_API;

    private final ObjectMapper mapper;

    public String getAnswer(List<Message> messages) throws AIRequestException {
        RequestBody body = new RequestBody(OPEN_ROUTER_MODEL, OPEN_ROUTER_TEMPERATURE, messages);

        try (HttpClient client = HttpClient.newHttpClient()) {
            String bodyObject = mapper.writeValueAsString(body);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(OPEN_ROUTER_API))
                    .POST(HttpRequest.BodyPublishers.ofString(bodyObject))
                    .header("Authorization", "Bearer " + OPEN_ROUTER_TOKEN)
                    .header("Content-type", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ResponseBody responseBody = mapper.readValue(response.body(), ResponseBody.class);

            return responseBody.getFirstMessage();
        } catch (Exception ex) {
            throw new AIRequestException(ex.getMessage(), ex.getCause());
        }
    }
}
