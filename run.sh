sh ./generate-java-classes.sh
rm -f /home/vinicius/desenvolvimento/rinha-de-compiler/rinha-compilador-em-java/src/main/java/MainClass.java
mvn compile exec:java -Dexec.mainClass=com.github.viniciusfcf.MyClassGenerator -Dexec.args=$1 
