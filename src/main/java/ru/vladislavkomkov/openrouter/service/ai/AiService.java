package ru.vladislavkomkov.openrouter.service.ai;

import ru.vladislavkomkov.openrouter.exception.AIRequestException;
import ru.vladislavkomkov.openrouter.model.Message;

import java.util.List;

public interface AiService {
    public String getAnswer(List<Message> messages) throws AIRequestException;
}
