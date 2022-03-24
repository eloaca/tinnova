# Prova Tinnova


> O projeto foi desenvolvido seguindo as especificações pedida pela equipe da Tinnova 
> durante o seu processo seletivo.

### Exercicios

Foi solicitado a resolução de 5 exercicios, descritos abaixo:

- [x] Votos em relação ao total de eleitores
- [x] Algoritmo de ordenação Bubble Sort
- [x] Fatorial
- [x] Soma dos múltiplos de 3 e 5
- [x] Cadastro de Veículos

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:
* Você instalou a versão 11 do java
* Voce instalou a versão 3 do maven

## 🚀 Subindo tinnova-api

Para instalar o tinnova-api, siga estas etapas:

1 - Rode o clean install para executar os testes unitários da aplicação
```
mvn clean install
```

2 - Suba a aplicação através do script 'start.sh' com o comando
```
bash start.sh
```

3 - Acesse o Swagger pela URL:
```
http://localhost:8080/tinnova/api/swagger-ui/index.html#/
```

4 - Acesse a URL: 
```
http://localhost:8080/tinnova/api/dev
```
* Informações de acesso disponível no properties do projeto

5 - Copie o conteúdo do script e execute este no ambiente h2
```
"V004__insert-veiculo"
```
##  Informações

- Os Exercicios de 1 ao 4 foram desenvolvidos. É possível ver sua implementação
através dos testes unitários.
- O Exercicio 5 consiste em uma API REST. É possível ver sua implementação através
dos testes unitários e também pelo SWAGGER.

## Tecnologias Utilizadas

- Java 11
- Maven 3
- Spring Boot 2
- Lombok
- Junit 5
- Mockito 4
- H2 DataBase
- Swagger 3

## Obrigada

[⬆ Voltar ao topo](#tinnoa-api)<br>