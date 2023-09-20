## Minha humilde submissão

Minha humilde submissão para rinha utilizando Java. Está cheia de limitações, mas aparentemente a parte que funciona está com um desempenho bom.

## TODO

- Closure
- As funções só funcionam com parâmetros e retornos Integer
- Cache do resultado de funções

## Agradecimentos e principal fonte de conhecimento e de cópia da versão inicial =)

https://github.com/professorisidro/IsiLanguageEmbriao


## Gerar imagem

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

## Limitações

- Só funciona se os parâmetros das funções e seus retornos forem Integer (se tiver tempo tentarei deixar genérico)
