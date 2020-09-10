transfer-schedule

financial transfer scheduling system

Detalhes do projeto
Esse projeto possui as seguintes características:

Projeto criado com Spring Boot e Java 14
Banco de dados H2 em memória
Testes com JUnit e Mockito com banco H2 em memória
Documentação dos endpoints com Swagger
Project Lombok

Como executar a aplicação
Certifique-se de ter o Maven instalado e adicionado ao PATH de seu sistema operacional, assim como o Git.

git clone https://github.com/filipeAraujoPadua/transfer-schedule
cd transfer-schedule
mvn spring-boot:run
Acesse os endpoints através da url http://localhost:8080

Como executar os testes
Os testes podem ser executados com o seguinte comando:

mvn test

Documentação
Utilize a interface do Swagger para ter acesso a documentação dos endpoints, ela está disponível na url http://localhost:8080/swagger-ui.html

