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

Arquitetura de pastas

Diretórios
transferSchedule
       |-- src
         |-- main
           |-- java
	     |-- com
             	|-- transferSchedule
		  |-- config
		  |-- controller
		  |-- entity
		  |-- mapper
		  |-- model
		    |-- request
		    |-- response
		  |-- repository
		  |-- service
		    |-- impl
           |-- resources
         |-- test
       pom.xml

config
Esta camada é responsavél por configurações do projeto. Ex: Cors, Rest, swagger...

controller
Esta camada vai agir como o controlador das requisições rest nos endpoints

entity
Esta camada responsavel pelas entidades

mapper
Esta camada e responsavel por fazer a transformacao dos objetos

model
Camada para os modelos de request e response

repository
Camada responsavel pela comunicacao com o banco 

service
Esta camada possui todos os serviços e as regras de negocio

resources
Recursos do projeto. Ex: configurações de variáveis de ambiente, configurações de banco

test
Camada onde é centralizado os testes da aplicação.



