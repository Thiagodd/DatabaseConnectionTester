package com.thiagodd.databaseconnectiontester.model.exceptions;

public class SQLPermissionDeniedException extends RuntimeException {

  public SQLPermissionDeniedException(String message) {
    super(message);
  }
}
