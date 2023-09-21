sh ./generate-java-classes.sh
rm -f src/main/java/MainClass.java
mvn compile exec:java -Dexec.mainClass=com.github.viniciusfcf.MyClassGenerator -Dexec.args=$1 
