# API de Verificação de Conexão com Banco de Dados
Esta é uma API simples que permite verificar se a conexão com o banco de dados foi realizada com sucesso. Ela fornece um endpoint para testar a conexão e retorna uma resposta indicando se a conexão foi bem-sucedida ou não.

## Como usar a API
Testar a conexão com o banco de dados
Endpoint: <code>GET /api/v1/test-connection</code>

Este endpoint permite testar a conexão com o banco de dados fornecendo as credenciais necessárias. Ele retorna uma resposta indicando se a conexão foi realizada com sucesso ou se falhou.

### Exemplo de uso:

```http request
GET /api/v1/test-connection
Content-Type: application/json

{
  "url": "jdbc:mysql://localhost:3306/mydatabase",
  "username": "myuser",
  "password": "mypassword"
}

```

### Respostas possíveis:

Status 200 OK: A conexão com o banco de dados foi realizada com sucesso.
```plaintext
A conexão com o banco de dados foi realizada com sucesso.
```

Status 400 Bad Request: A conexão com o banco de dados falhou. Verifique os dados e tente novamente..
```plaintext
A conexão com o banco de dados falhou. Verifique os dados e tente novamente.
```