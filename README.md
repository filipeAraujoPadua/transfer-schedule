transfer-schedule

financial transfer scheduling system

Detalhes do projeto
Esse projeto possui as seguintes características:

Projeto criado com Spring Boot e Java 14
Banco de dados H2 em memória
Testes com JUnit e Mockito com banco H2 em memória
Documentação dos endpoints com Swagger

Como executar a aplicação
Certifique-se de ter o Maven instalado e adicionado ao PATH de seu sistema operacional, assim como o Git.

git clone https://github.com/filipeAraujoPadua/transfer-schedule
cd transfer-schedule
mvn spring-boot:run
Acesse os endpoints através da url http://localhost:8080
Também é possível compilar o projeto para executar em um ambiente de produção, para isso execute o seguinte comando na raiz do projeto

mvn clean install
O pacote será gerado dentro da pasta target, basta executá-lo com o comando abaixo, não esquecendo de configurar qual o profile e a porta que a aplicação deverá utilizar

java -jar -Dspring.profiles.active=prod -Dserver.port=443 walletAPI-0.0.1-SNAPSHOT.jar

Como executar os testes
Os testes podem ser executados com o seguinte comando:

mvn test

Documentação
Utilize a interface do Swagger para ter acesso a documentação dos endpoints, ela está disponível na url http://localhost:8080/swagger-ui.html

