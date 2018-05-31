CREATE DATABASE hospital;

USE hospital;

DROP TABLE IF EXISTS Medico;
CREATE TABLE Medico(
  id   INTEGER     NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  sexo CHAR        NOT NULL,
  crm  INTEGER     NOT NULL,
  nacionalidade VARCHAR(30) NOT NULL,
  dtNasc DATE NOT NULL,
  dtAdmiss DATE NOT NULL,
  dtFormatura DATE NOT NULL,
  PRIMARY KEY (id)
);

SELECT * FROM Medico;

DROP TABLE IF EXISTS Enfermeiro;
CREATE TABLE Enfermeiro(
  id   INTEGER     NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  sexo CHAR        NOT NULL,
  coren  INTEGER     NOT NULL,
  nacionalidade VARCHAR(30) NOT NULL,
  dtNasc DATE NOT NULL,
  dtAdmiss DATE NOT NULL,
  dtFormatura DATE NOT NULL,
  PRIMARY KEY (id)
);

SELECT * FROM Enfermeiro;

DROP TABLE IF EXISTS Auxiliar;
CREATE TABLE Auxiliar(
  id   INTEGER     NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  sexo CHAR        NOT NULL,
  coren  INTEGER     NOT NULL,
  nacionalidade VARCHAR(30) NOT NULL,
  dtNasc DATE NOT NULL,
  dtAdmiss DATE NOT NULL,
  dtFormatura DATE NOT NULL,
  PRIMARY KEY (id)
);

SELECT * FROM Auxiliar;