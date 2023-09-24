## Minha humilde submissão

Minha humilde submissão para rinha utilizando Java. Está cheia de limitações, mas aparentemente a parte que funciona está com um desempenho bom. Fiz o projeto para não ficar de fora da rinha e para aprender sobre [ANTR](https://www.antlr.org/). Gostei do resultado final? Não! No arquivo g4 fica muito código java misturado com a definição da gramática. Aparentemente se eu tivesse utilizado o json para produzir a classe Java final ficaria mais organizado e conseguiria atender os requisitos sem apanhar tanto quanto apanhei.

## TODO

- Closure
- As funções só funcionam com parâmetros e retornos Integer (se tiver tempo tentarei deixar genérico)
- Funcao dentro de funcao
- Funcao sem { e }

## Agradecimentos e principal fonte de conhecimento e de cópia da versão inicial =)

https://github.com/professorisidro/IsiLanguageEmbriao

https://www.youtube.com/playlist?list=PLjcmNukBom6--0we1zrpoUE2GuRD-Me6W


## Gerar imagem

```
./build-java-image.sh
```

## Executar versão java

Ex:

```
docker run --memory=2g --cpus=2  -it -v ./examples/fib.rinha:/var/rinha/source.rinha.json  viniciusfcf-java-compiler

```

## Adicionar mais exemplos

É necessário copiar o arquivo para a pasta "examples", será montado um volume no momento da execução do container

