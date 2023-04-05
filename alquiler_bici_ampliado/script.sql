DROP DATABASE IF EXISTS alquiler_bici;

CREATE DATABASE IF NOT EXISTS alquiler_bici;

USE alquiler_bici;

CREATE TABLE usuario (
	id_usuario INT PRIMARY KEY NOT NULL,
    nombre VARCHAR(50) NOT NULL
    );

INSERT INTO `usuario` VALUES 
  (0, 'libre'),
  (1, 'Paco'),
  (2, 'Lola'),
  (3, 'Juan'),
  (4, 'Sara'),
  (5, 'Lara');

CREATE TABLE bici (
	id_bici INT PRIMARY KEY NOT NULL,
    cod_usuario INT DEFAULT 0,
    CONSTRAINT fk_usuario FOREIGN KEY (cod_usuario) REFERENCES usuario (id_usuario)
    );
    
INSERT INTO `bici` VALUES 
  (1, '0'),
  (2, '0'),
  (3, '0'),
  (4, '0');
    
-- Laura y Lucas