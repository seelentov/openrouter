package ru.vladislavkomkov.openrouter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Getter
    public String content;

    @JsonIgnore
    private Boolean isUser;

    @JsonProperty("role")
    public String getRole() {
        return isUser ? "user" : "assistant";
    }

    public void switchIsUser() {
        this.isUser = !this.isUser;
    }
}
