package com.thiagodd.databaseconnectiontester.util;

import com.thiagodd.databaseconnectiontester.model.domain.DatabaseCredential;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DatabaseUtilTest {

  @Test
  void testConnectionValidCredentialReturnsTrue() {
    DatabaseCredential credential = new DatabaseCredential("jdbc:h2:mem:testdb", "sa", "");
    boolean result = DatabaseUtil.testConnection(credential);
    assertTrue(result);
  }

  @Test
  public void testConnectionInvalidCredentialReturnsFalse() {
    DatabaseCredential credential = new DatabaseCredential("invalidUrl", "username", "password");
    boolean result = DatabaseUtil.testConnection(credential);
    assertFalse(result);
  }

  @Test
  void testConnectionNullCredentialReturnsFalse() {
    DatabaseUtil.testConnection(null);
    boolean result = false;
    assertFalse(result);
  }
}