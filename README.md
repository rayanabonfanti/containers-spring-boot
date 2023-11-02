# Projeto de Autenticação Básica com Spring Boot e MySQL - Branch deploy-docker
Este projeto demonstra como implantar uma aplicação Spring Boot com um banco de dados MySQL em um ambiente Docker. Siga as etapas abaixo para configurar e executar o aplicativo no Docker.

## Tecnologias Utilizadas
- API REST Full, JpaRepository
- Spring Security: AuthenticationProvider, SecurityFilterChain, BCryptPasswordEncoder
- HashMap e Spring Exception Handler (em andamento)
- Spring Boot 3.0.6
- Java 17
- Banco de Dados MySQL 8.0.33
- Docker

## Instruções de Configuração
Para configurar o ambiente de desenvolvimento local, é necessário ter as seguintes configurações:
- Java 17 instalado
- Maven instalado
- Um ambiente de desenvolvimento integrado (IDE) de sua escolha

## Instruções de Instalação
Para instalar as dependências do projeto, execute o seguinte comando:

```bash
mvn clean install
```

## Configuração do Banco de Dados
A configuração do banco de dados é feita no arquivo `application.yml`, que define as propriedades de conexão com o MySQL. As principais configurações incluem o URL do banco de dados, nome de usuário e senha para acesso ao banco de dados:

```yaml
spring:
datasource:
url: jdbc:mysql://${MYSQL_HOST:localhost}:${MYSQL_PORT:3306}/db_docker_spring_mysql
username: ${MYSQL_USER:root}
password: ${MYSQL_PASSWORD:Teste@123}
jpa:
hibernate.ddl-auto: update
properties.hibernate.show_sql: true
properties.hibernate.dialect: org.hibernate.dialect.MySQL5Dialect
```

## Dockerfile
O projeto inclui um arquivo Dockerfile para empacotar a aplicação Spring Boot e executá-la em um contêiner Docker:

```Dockerfile
FROM openjdk:17
ADD target/docker-spring-boot-with-mysql.jar docker-spring-boot-with-mysql.jar
ENTRYPOINT ["java", "-jar", "/docker-spring-boot-with-mysql.jar"]
```
Certifique-se de ajustar o nome do arquivo JAR e as configurações do Docker conforme necessário.

## Execute imagem e contêiner MySQL no Docker
Para executar um banco de dados MySQL em um contêiner Docker, execute o seguinte comando:

```bash
docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD={your_root_password} -e MYSQL_DATABASE=db_docker_spring_mysql mysql:{mysql-version}
```

Este comando mapeia a porta 3307 no contêiner Docker para a porta 3306 em sua máquina local. Substitua `{your_root_password}` pela senha root desejada e `{mysql-version}` pela versão do MySQL que você deseja usar.

## Crie e execute Spring Boot no Docker com IntelliJ
Para executar seu aplicativo Spring Boot no Docker do IntelliJ, siga estas etapas:

Nas configurações do módulo, configure as "Opções de Modificação" para adicionar opções de VM. Adicione o seguinte script:

```bash
-DMYSQL_USER={your_user} -DMYSQL_PASSWORD={your_password} -DMYSQL_PORT=3307
```
Substitua `{your_user}` pelo usuário MySQL, `{your_password}` pela senha do usuário MySQL e `3307` pela porta mapeada na etapa anterior.

## Crie uma rede Docker
Crie uma rede Docker para seus contêineres Spring Boot e MySQL:

```bash
docker network create docker-spring-network
```

## Crie seu aplicativo Spring Boot com Maven
Compile e empacote seu aplicativo Spring Boot usando Maven:

```bash
mvn clean install
```

## Construa o aplicativo Spring Boot no Docker
Crie uma imagem Docker para seu aplicativo Spring Boot:

```bash
ocker build -t docker-spring-boot-with-mysql .
```

## Conecte o MySQL à rede Spring
Conecte o contêiner MySQL à rede Docker criada anteriormente:

```bash
docker network connect docker-spring-network mysqldb
```

## Execute Spring Boot com MySQL no Docker
Execute seu aplicativo Spring Boot com MySQL em um contêiner Docker usando o seguinte comando:

```bash
docker run -p 9090:8080 --name docker-spring-boot-with-mysql --net docker-spring-network -e MYSQL_HOST=mysqldb -e MYSQL_USER={your_user} -e MYSQL_PASSWORD={your_password} -e MYSQL_PORT=3306 docker-spring-boot-with-mysql
```

Este comando mapeia a porta 9090 no contêiner Docker para a porta 8080 em sua máquina local. Substitua `{your_user}` pelo usuário MySQL, `{your_password}` pela senha do usuário MySQL e certifique-se de que os números das portas correspondam às configurações usadas.

Seguindo essas etapas, você pode implantar seu aplicativo Spring Boot com um banco de dados MySQL no Docker, garantindo um processo contínuo de desenvolvimento e implantação.


## Teste e Documentação
Documentação API do Swagger em andamento.

## Estrutura do Projeto
O projeto segue uma estrutura organizada com as pastas para controle de entidades, serviços, controladores, configurações e segurança.

## Autores e Contribuidores
Rayana Ribeiro Bonfanti

## Status do Projeto
Versão atual: 0.0.1-SNAPSHOT

## Contato
Para mais informações, entre em contato com [rayanabonfanti@gmail.com].

## Contribuições
Fique à vontade para contribuir para este projeto, seja adicionando recursos, corrigindo bugs ou aprimorando a segurança da autenticação, assim que feito, pode abrir um pull request que irei analisar o código para uma possível branch ser adicionada com suas alterações. Sua contribuição é bem-vinda!

Agradecemos a todos que contribuíram e nos inspiraram a criar este projeto.

Este é um projeto de exemplo que visa ajudar a compreender a configuração do Spring Security para autenticação básica em uma aplicação Spring Boot e demonstrar a implantação com Docker. É uma base sólida para criar aplicativos mais complexos com recursos de autenticação e segurança.
