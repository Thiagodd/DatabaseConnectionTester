package com.thiagodd.databaseconnectiontester.api.exceptionHandler;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {
  private LocalDateTime timestamp;
  private String message;
}
