mvn clean package
cp target/rinha-compilador-em-java-0.0.1-SNAPSHOT-jar-with-dependencies.jar rinha-java.jar
docker build -t viniciusfcf-java-compiler .
