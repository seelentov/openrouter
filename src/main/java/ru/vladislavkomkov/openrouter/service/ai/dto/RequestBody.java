package ru.vladislavkomkov.openrouter.service.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.vladislavkomkov.openrouter.model.Message;

import java.util.List;

@Getter
@AllArgsConstructor
public class RequestBody {
    private String model;

    private double temperature;

    @Setter
    private List<Message> messages;
}
