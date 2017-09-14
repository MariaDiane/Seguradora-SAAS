FROM openjdk:8-jdk-alpine
ADD target/seguros-saas-produto-0.0.1-SNAPSHOT-0.1.0.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]