
## Como empacotar

```
mvn clean package
```

## Gerar container com versão java

```
./build-java-image.sh
```

## Executar versão java

./run-java-image.sh <FILE>


Ex:
```
./run-java-image.sh examples/sum.rinha

```

## Adicionar mais exemplos

É necessário copiar o arquivo para a pasta "examples", será montado um volume no momento da execução do container


# Native Mode (WIP)


## Install GRAALVM

Follow: https://github.com/graalvm/graalvm-ce-builds/releases

