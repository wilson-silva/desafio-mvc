CREATE TABLE usuario (
  login varchar(255) NOT NULL,
  nome varchar(255) DEFAULT NULL,
  senha varchar(255) DEFAULT NULL,
   PRIMARY KEY (login)
);

CREATE TABLE role(
  nome_role varchar(255) NOT NULL,
  PRIMARY KEY (nome_role)
);

INSERT INTO role(nome_role) VALUES ('ROLE_ADMIN');
INSERT INTO role(nome_role) VALUES ('ROLE_USER');

INSERT INTO usuario (login, nome, senha) VALUES ('admin2', 'Wilson Silva', '$2a$10$iD3EhSTj.E5MNK5AIpyYE.RJa2MGGEhUuzL9VQkxFiffEMdrBQ/iq');
INSERT INTO usuario (login, nome, senha) VALUES ('user1', 'Katelyn Silva', '$2a$10$vKpSOlTaGTLaqcvQEboq9uxv5lXixcCTU6DUn/uj.ei8lcc6pvK/S');

CREATE TABLE usuarios_roles (
  usuario_id varchar(255) NOT NULL,
  role_id varchar(255) NOT NULL,
  KEY FKefntoswg8cckktsk0ha1wpm0i (role_id),
  KEY FKebiaxjbamgu326glxo1fbysuh (usuario_id),
  CONSTRAINT FKebiaxjbamgu326glxo1fbysuh FOREIGN KEY (usuario_id) REFERENCES usuario (login),
  CONSTRAINT FKefntoswg8cckktsk0ha1wpm0i FOREIGN KEY (role_id) REFERENCES role (nome_role)
);

insert into usuarios_roles(usuario_id, role_id) values('admin2','ROLE_ADMIN');
insert into usuarios_roles(usuario_id, role_id) values('user1','ROLE_USER');