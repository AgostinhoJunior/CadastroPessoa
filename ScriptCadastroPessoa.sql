CREATE DATABASE `cadastropessoa` ;
USE cadastropessoa;

CREATE TABLE `pessoa` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dataNascimento` date NOT NULL,
  PRIMARY KEY (`codigo`)
) ;
