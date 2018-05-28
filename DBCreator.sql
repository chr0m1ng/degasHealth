CREATE DATABASE hospital;

USE hospital;

CREATE TABLE Medico (
  id   INTEGER     NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  crm  INTEGER     NOT NULL,
  sexo CHAR        NOT NULL,
  nacionalidade VARCHAR(30) NOT NULL,
  dataNasc DATE NOT NULL,
  dataAdmiss DATE NOT NULL,
  dataFormatura DATE NOT NULL,
  PRIMARY KEY (id)
);

-- SELECT * FROM Medico;

-- drop TABLE Medico;
