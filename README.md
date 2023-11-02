# deploy-docker-spring-boot-with-mysql
Deploy Spring Boot With MySQL in Docker

# Run Image and Container MySQL in Docker
$ docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD={name_root_password} -e MYSQL_DATABASE=db_docker_spring_mysql mysql:{mysql-version}

Use port 3307 in Docker and use port 3306 in local

# Build and Run Spring in Docker with IntelliJ
In module set 'Modify Options' for Add VMs Options and set script:

$ -DMYSQL_USER={name_user} -DMYSQL_PASSWORD={name_password} -DMYSQL_PORT=3307

# Create Network in Docker
$ docker network create docker-spring-network

# Run Maven
$ mvn clean install

# Build Spring in Docker
$ docker build -t docker-spring-boot-with-mysql .

# Connect MySQL with Spring Network
$ docker network connect docker-spring-network mysqldb

# Run Spring with Mysql in Docker
$ docker run -p 9090:8080 --name docker-spring-boot-with-mysql --net docker-spring-network -e MYSQL_HOST=mysqldb -e MYSQL_USER={name_user} -e MYSQL_PASSWORD={name_password} -e MYSQL_PORT=3306 docker-spring-boot-with-mysql  

Use port 9090 in Docker and use port 8080 in local
