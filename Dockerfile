FROM maven:3.8.3-openjdk-17 as builder

WORKDIR /workdir
COPY . .
COPY src/main/java/Tupla.java /app/build/Tupla.java

RUN mvn package -DskipTests

FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY --from=builder /workdir/target/rinha-compilador-em-java-0.0.1-SNAPSHOT-jar-with-dependencies.jar build/app.jar
COPY --from=builder /workdir/src/main/java/Tupla.java build/Tupla.java
COPY --from=builder /workdir/app-cds.jsa .

WORKDIR /app/build

ENV JAVA_OPTS "-Xms1250M -Xmx2048M -XX:+UseG1GC \
			-XX:+UseNUMA \
			-Djava.lang.Integer.IntegerCache.high=100000  \
		"
ENTRYPOINT [ "java", "-jar", "app.jar"]
CMD ["examples/print.rinha"]