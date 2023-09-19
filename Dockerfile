FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY rinha-java.jar build/app.jar

WORKDIR /app/build
ENTRYPOINT [ "java", "-jar", "app.jar"]
CMD ["examples/print.rinha"]