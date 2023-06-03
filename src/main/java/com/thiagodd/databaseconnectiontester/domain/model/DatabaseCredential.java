package com.thiagodd.databaseconnectiontester.domain.model;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseCredential {

  @NotNull
  private String url;

  @NotNull
  private String username;

  @NotNull
  private String password;
}
