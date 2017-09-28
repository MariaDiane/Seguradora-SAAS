FROM openjdk:8-jdk-alpine
ADD target/seguros-saas-venda-0.0.1-SNAPSHOT.jar app.jar
ADD wait-for .
RUN chmod +x ./wait-for
