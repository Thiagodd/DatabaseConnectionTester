package com.thiagodd.databaseconnectiontester.util;

import com.thiagodd.databaseconnectiontester.model.DatabaseCredential;
import com.thiagodd.databaseconnectiontester.model.exceptions.SQLPermissionDeniedException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DatabaseUtil {

  private final static String CODE_PERMISSION_DENIED = "42000";

  public static boolean testConnection(DatabaseCredential credential) {

    if (credential == null) {
      return false;
    }

    try {
      Connection connection = createConnection(credential);

      if (connection != null) {
        connection.close();
        return true;
      }

    } catch (SQLException e) {
       if(e.getSQLState().equals(CODE_PERMISSION_DENIED)){
        throw new SQLPermissionDeniedException(e.getMessage());
      }
    }
    return false;
  }

  static Connection createConnection(DatabaseCredential credential) throws SQLException {
    return DriverManager.getConnection(credential.getUrl(), credential.getUsername(), credential.getPassword());
  }

  private static boolean isConnectionValid(Connection connection) throws SQLException {
    try (Statement statement = connection.createStatement()) {
      statement.execute("SELECT 1");
      return true;
    }
  }
}
