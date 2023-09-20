FROM maven:3.8.3-openjdk-17 as builder

WORKDIR /workdir
COPY . .

RUN mvn package -DskipTests


FROM openjdk:17-jdk-slim-buster
WORKDIR /app

COPY --from=builder /workdir/target/rinha-compilador-em-java-0.0.1-SNAPSHOT-jar-with-dependencies.jar build/app.jar
COPY --from=builder /workdir/src/main/java/Tupla.java build/Tupla.java

WORKDIR /app/build
#https://docs.oracle.com/cd/E13150_01/jrockit_jvm/jrockit/jrdocs/refman/optionXX.html

ENV JAVA_OPTS "-Xms1250M -Xmx2048M -XX:+UseG1GC -XX:+UseStringDeduplication \
			-XX:+UseNUMA \
			-XX:+UseStringCache \
			-Djava.lang.Integer.IntegerCache.high=100000  \
		"
ENTRYPOINT [ "java", "-jar", "app.jar"]
CMD ["examples/print.rinha"]