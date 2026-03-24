package com.grolfbank.users.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorHandler {
    private int status;
    private String message;
    private long timestamp;
}
