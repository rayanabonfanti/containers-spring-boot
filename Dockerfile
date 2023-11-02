FROM openjdk:17
ADD target/docker-spring-boot-with-mysql.jar docker-spring-boot-with-mysql.jar
ENTRYPOINT ["java","-jar","/docker-spring-boot-with-mysql.jar"]