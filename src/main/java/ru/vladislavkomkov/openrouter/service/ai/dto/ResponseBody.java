package ru.vladislavkomkov.openrouter.service.ai.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseBody {
    @JsonProperty("choices")
    private List<ResponseBodyChoice> choices;

    public String getFirstMessage() {
        if (getChoices().isEmpty()) {
            return "";
        }

        return getChoices().getFirst().getMessage().getContent();
    }
}
