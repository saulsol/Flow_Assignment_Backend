package com.example.fileuploadservice.advice;

import com.example.fileuploadservice.util.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(IllegalArgumentException exception) {
        ErrorMessage errorMessage = new ErrorMessage(List.of(exception.getMessage()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorMessage);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorMessage> handleIOException(IOException exception) {
        ErrorMessage errorMessage = new ErrorMessage(List.of("파일 처리 중 오류가 발생했습니다.", exception.getMessage()));
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorMessage);
    }

}
