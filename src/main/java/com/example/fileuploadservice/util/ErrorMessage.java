package com.example.fileuploadservice.util;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ErrorMessage {

    private final List<String> errors;
    public List<String> getErrors() {
        return errors;
    }
}