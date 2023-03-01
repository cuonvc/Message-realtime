package com.project.message.messagerealtime.utils.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDetails {

    private LocalDateTime dateTime;
    private String message;
    private String description;
}
