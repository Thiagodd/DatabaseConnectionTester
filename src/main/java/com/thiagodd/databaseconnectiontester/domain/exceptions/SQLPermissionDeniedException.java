package com.thiagodd.databaseconnectiontester.domain.exceptions;

public class SQLPermissionDeniedException extends RuntimeException {

  public SQLPermissionDeniedException(String message) {
    super(message);
  }
}
