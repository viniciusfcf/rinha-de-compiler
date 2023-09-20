FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY rinha-java.jar build/app.jar
COPY src/main/java/Tupla.java build/Tupla.java

WORKDIR /app/build
ENTRYPOINT [ "java", "-jar", "app.jar"]
CMD ["examples/print.rinha"]