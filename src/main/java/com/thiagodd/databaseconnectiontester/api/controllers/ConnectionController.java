package com.thiagodd.databaseconnectiontester.api.controllers;

import com.thiagodd.databaseconnectiontester.domain.model.DatabaseCredential;
import com.thiagodd.databaseconnectiontester.util.DatabaseUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/test-connection")
public class ConnectionController {

  @GetMapping()
  public ResponseEntity<?> testConnection(@RequestBody @Valid DatabaseCredential credential) {

    boolean isConnected = DatabaseUtil.testConnection(credential);

    if (isConnected) {
      return ResponseEntity.ok("A conexão com o banco de dados foi realizada com sucesso.");
    } else {
      return ResponseEntity.badRequest().body("A conexão com o banco de dados falhou. Verifique os dados e tente novamente.");
    }

  }
}
