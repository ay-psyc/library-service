package com.yuki.libraryservice.exception;

import java.util.Map;

public record ErrorResponse(
        String timestamp,
        int status,
        String errorType,
        String path,
        String message,
        Map<String, String> errors
) {
}