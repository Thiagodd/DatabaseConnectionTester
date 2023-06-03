package com.thiagodd.databaseconnectiontester.api.exceptionHandler;

import com.thiagodd.databaseconnectiontester.domain.exceptions.SQLPermissionDeniedException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class ApiExceptionHandler {

  private static ErrorResponse getErrorResponse(String message) {
    return ErrorResponse.builder()
        .timestamp(LocalDateTime.now())
        .message(message)
        .build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> methodArgumentNotValidException() {
    ErrorResponse errorResponse = getErrorResponse("Um ou mais campos estão nulos. Verifique os valores dos campos e tente novamente.");
    return ResponseEntity.badRequest().body(errorResponse);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<?> httpMessageNotReadableException() {
    ErrorResponse errorResponse = getErrorResponse("Corpo da requisição é obrigatório. Nenhum dado foi passado.");
    return ResponseEntity.badRequest().body(errorResponse);
  }

  @ExceptionHandler(SQLPermissionDeniedException.class)
  public ResponseEntity<?> SQLPermissionDeniedException() {
    ErrorResponse errorResponse = getErrorResponse("O usuário fornecido não possui permissão para se conectar ao banco.");
    return ResponseEntity.badRequest().body(errorResponse);
  }
}
