CREATE TABLE CASA(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
endereco VARCHAR(255) NOT NULL);

CREATE TABLE EVENTO(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL,
capacidade BIGINT NOT NULL,
data DATE NOT NULL,
valor_ingresso DECIMAL NOT NULL,
genero VARCHAR(255) NOT NULL,
casas_id BIGINT,
CONSTRAINT fk_casas FOREIGN KEY (casas_id) REFERENCES casa(id));

CREATE TABLE USUARIO(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nome varchar(255) DEFAULT NULL,
  username varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL);

INSERT  INTO CASA(nome, endereco) VALUES('casa1', 'Rua1');
INSERT  INTO CASA(nome, endereco) VALUES('casa2', 'Rua2');
INSERT  INTO CASA(nome, endereco) VALUES('casa3', 'Rua3');

INSERT  INTO EVENTO(nome, capacidade, data, valor_ingresso, genero, casas_id) VALUES('show1',100,'20221002',100,'ROCK',1);
INSERT  INTO EVENTO(nome, capacidade, data, valor_ingresso, genero, casas_id) VALUES('show2',100,'20221102',100,'SAMBA',2);
INSERT  INTO EVENTO(nome, capacidade, data, valor_ingresso, genero, casas_id) VALUES('show3',100,'20221202',100,'SERTANEJO',3);