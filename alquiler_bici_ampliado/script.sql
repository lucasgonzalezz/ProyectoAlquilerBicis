DROP DATABASE IF EXISTS alquiler_bici;

CREATE DATABASE IF NOT EXISTS alquiler_bici;

USE alquiler_bici;

CREATE TABLE usuario (
id_usuario INT PRIMARY KEY NOT NULL,
    nombre VARCHAR(50) NOT NULL
    );

INSERT INTO `usuario` VALUES (0, 'libre');

CREATE TABLE bici (
id_bici INT PRIMARY KEY NOT NULL,
    cod_usuario INT DEFAULT 0,
    CONSTRAINT fk_usuario FOREIGN KEY (cod_usuario) REFERENCES usuario (id_usuario)
    );
    
-- Laura y Lucass