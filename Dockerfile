FROM maven:3.8.3-openjdk-17 as builder

WORKDIR /workdir
COPY . .
COPY src/main/java/Tupla.java /app/build/Tupla.java
COPY src/main/java/MyMapKey.java /app/build/MyMapKey.java

RUN mvn package -DskipTests

FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY --from=builder /workdir/target/rinha-compilador-em-java-0.0.1-SNAPSHOT-jar-with-dependencies.jar build/app.jar
COPY --from=builder /workdir/src/main/java/Tupla.java build/Tupla.java
COPY --from=builder /workdir/src/main/java/MyMapKey.java build/MyMapKey.java

WORKDIR /app/build

ENV JAVA_OPTS "-Xms1024M -Xmx2048M -XX:+UseG1GC \
			-XX:+UseNUMA \
			-Xss16M \ 
			-XX:MaxHeapFreeRatio=90 \
			-Djava.lang.Integer.IntegerCache.high=1000000  \
		"
ENTRYPOINT [ "java", "-Xss128M", "-jar", "app.jar"]
CMD ["examples/print.rinha"]