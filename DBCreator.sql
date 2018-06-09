DROP DATABASE IF EXISTS hospital;
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

DROP TABLE IF EXISTS Procedimento;
CREATE TABLE Procedimento(
  id INTEGER NOT NULL AUTO_INCREMENT,
  codigo INTEGER NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  valor DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (id)
);

SELECT * FROM Procedimento;

DROP TABLE IF EXISTS Especialidade;
CREATE TABLE Especialidade(
  id INTEGER NOT NULL AUTO_INCREMENT,
  codigo INTEGER NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

SELECT * FROM Especialidade;

DROP TABLE IF EXISTS Equipamento;
CREATE TABLE Equipamento(
  id INTEGER NOT NULL AUTO_INCREMENT,
  codigo INTEGER NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  valor DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (id)
);

SELECT * FROM Equipamento;

DROP TABLE IF EXISTS Tombo;
CREATE TABLE Tombo(
  id INTEGER NOT NULL AUTO_INCREMENT,
  codigoEquipamento INTEGER NOT NULL,
  codigoTombo VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
);

SELECT * FROM Tombo;

DROP TABLE IF EXISTS Material;
CREATE TABLE Material(
  id INTEGER NOT NULL AUTO_INCREMENT,
  codigo INTEGER NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  valor DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (id)
);

SELECT * FROM Material;


DROP TABLE IF EXISTS MaterialProcedimento;
CREATE TABLE MaterialProcedimento(
  id INTEGER NOT NULL AUTO_INCREMENT,
  id_material INTEGER NOT NULL,
  id_procedimento INTEGER NOT NULL,
  codigoProcedimento INTEGER NOT NULL,
  codigoMaterial INTEGER NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_material) REFERENCES Material(id),
  FOREIGN KEY (id_procedimento) REFERENCES Procedimento(id)
);

SELECT * FROM MaterialProcedimento;

DROP TABLE IF EXISTS EquipamentoProcedimento;
CREATE TABLE EquipamentoProcedimento(
  id INTEGER NOT NULL AUTO_INCREMENT,
  id_equipamento INTEGER NOT NULL,
  id_procedimento INTEGER NOT NULL,
  codigoProcedimento INTEGER NOT NULL,
  codigoEquipamento INTEGER NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_equipamento) REFERENCES Equipamento(id),
  FOREIGN KEY (id_procedimento) REFERENCES Procedimento(id)
);

SELECT * FROM EquipamentoProcedimento;

# SELECT Material.descricao FROM Material INNER JOIN MaterialProcedimento Procedimento ON Material.id = Procedimento.id_material WHERE codigoProcedimento = "839530" ORDER BY Procedimento.id;
# SELECT Equipamento.descricao FROM Equipamento INNER JOIN EquipamentoProcedimento E ON Equipamento.id = E.id_equipamento WHERE codigoProcedimento = "839530";
# SELECT * FROM Equipamento WHERE codigo = "885";

