# desafioMVC / Gerenciador de Evento
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/wilson-silva/desafioMVC/blob/main/LICENSE)

Este projeto foi desenvolvido no periodo de treinamento oferecido pelo Grupo GFT no programa
Starter #3, neste treinamento vimos Spring MVC, Thymeleaf, Bootstrap, Spring Security.
Nele é possivel cadastrar, editar ou excluir casa de evento ou evento se estiver logado como admin.
Com o usuário user pode comprar ingresso, ver o carrinho de compra e etc.

## Rodar Projeto
Obs: assim que o servidor subir colocar localhost:8080 que já sera redirecionado para a tela de login
Foi criado usuario e senha na memória.

* 1 - admin admin
* 2 - user1 user1
* 3 - user2 user2

Assim que voce subir o projeto este valores irão ser populados automaticamente

* INSERT  INTO CASA(nome, endereco) VALUES('casa1', 'Rua1');
* INSERT  INTO CASA(nome, endereco) VALUES('casa2', 'Rua2');
* INSERT  INTO CASA(nome, endereco) VALUES('casa3', 'Rua3');

* INSERT  INTO EVENTO(nome, capacidade, data, valor_ingresso, genero, casas_id) VALUES('show1',100,'20221002',100,'ROCK',1);
* INSERT  INTO EVENTO(nome, capacidade, data, valor_ingresso, genero, casas_id) VALUES('show2',100,'20221102',100,'SAMBA',2);
* INSERT  INTO EVENTO(nome, capacidade, data, valor_ingresso, genero, casas_id) VALUES('show3',100,'20221202',100,'SERTANEJO',3);

## Tecnologias e ferramentas utilizadas
- Java
- Thymeleaf
- bootstrap
- Flyway
- Spring MVC
- Spring Data
- JPA/Hibernet
- Bean Validation
- Maven
- Mysql
- Intellij

## Autor

Wilson Gimenes da Silva

https://github.com/wilson-silva/desafioMVC