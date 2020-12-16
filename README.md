# RepoGitHub
API REST para listar todos os repositórios de um determinado usuário do GitHub.

## Informações 

### O microserviço deve levar em consideração os seguintes pontos:
 
* Como referência, um microserviço de exemplo pode ser executado com o comando abaixo:
 
 - docker run -p 8080:8080 renansies/microservice:1.0
 
* Ao ser executado com sucesso, a documentação swagger estará disponível na URL http://localhost:8080/swagger-ui.html. Para autenticação, está disponível o endpoint /auth, que espera receber um POST com os dados do usuário no corpo, em formato JSON, conforme exemplo abaixo:
 
{
"username": "admin",
"password": "12345"
}

* A documentação da APomI do GitHub pode ser encontrada em https://developer.github.com/v3/;
* O endpoint de listagem deve ser protegido por Jwt authentication, usando Bearer Token;
* Deve ser criado um endpoint para autenticação de usuário. Para este exercício não é necessário usar banco de dados, ou quaisquer outros provedores de autorização. Pode ser usado uma base de usuários hard coded;
* O microserviço deve ser dockerizado;
* O microserviço deve ser publicado no dockerhub, de forma que este possa ser testado por qualquer pessoa que possua o docker instalado em sua máquina;