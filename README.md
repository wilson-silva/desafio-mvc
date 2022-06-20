# Gerenciador de Evento - Starter #3
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/wilson-silva/desafioMVC/blob/main/LICENSE)

Este projeto foi desenvolvido no periodo de treinamento oferecido pelo Grupo GFT no programa
Starter #3, neste treinamento vimos Spring MVC, Thymeleaf, Bootstrap, Spring Security.
Nele é possivel cadastrar, editar, visualizar ou excluir uma casa de show ou evento se estiver logado como admin.
Com o usuário user pode comprar ingresso, ver o carrinho de compra e etc.

## Layout web

![Modelo Conceitual](https://github.com/wilson-silva/desafioMVC/blob/main/tela1.png)
![Modelo Conceitual](https://github.com/wilson-silva/desafioMVC/blob/main/tela2.png)
![Modelo Conceitual](https://github.com/wilson-silva/desafioMVC/blob/main/tela3.png)
![Modelo Conceitual](https://github.com/wilson-silva/desafioMVC/blob/main/tela4.png)
![Modelo Conceitual](https://github.com/wilson-silva/desafioMVC/blob/main/tela5.png)
![Modelo Conceitual](https://github.com/wilson-silva/desafioMVC/blob/main/tela6.png)

## Como executar o projeto

Pré-requisitos: 

* Java 17 ou versões superiores.
* Maven 3.6.3 ou versões superiores.
* Intellj IDEA Community Edition ou sua IDE favorita.
* Controle de versão GIT instalado na sua máquina.

```bash
# clonar repositório
https://github.com/wilson-silva/desafioMVC.git

# entrar na pasta do projeto desafio_mvc
cd desafio_mvc ou abrir o bash dentro da pasta

# executar o projeto
./mvnw spring-boot:run

# após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto

http://localhost:8080

# usuario e senha para acessar a aplicação.
1 - admin admin
2 - user1 user1

```

# Banco de dados já esta populado para teste

```bash
Casa de Show
nome, endereco
'casa1', 'Rua1
'casa2', 'Rua2
'casa3', 'Rua3

nome, capacidade, data, valor_ingresso, genero, casas_id
'show1',100,'20221002',100,'ROCK',1
'show2',100,'20221102',100,'SAMBA',2
'show3',100,'20221202',100,'SERTANEJO',3
```

# Tecnologias utilizadas

## Back end
- Java
- Spring MVC
- Spring Boot
- Spring Data JPA
- Bean Validation
- Maven
- Mysql
- Flyway

## Front end
- HTML / CSS / JS
- Thymeleaf
- Bootstrap


## Autor
Wilson Gimenes da Silva
https://github.com/wilson-silva/desafioMVC