# Manual de instalação



Criar o projeto:
**necessário java EE instalado**
clonar o repositório
selecionar como workspace o local que está o arquivo
criar novo projeto web dynamic
colocar como nome do projeto TecProg_ContributeBlog

Configurando apache:
Baixar versao do apache 7.0.64
Ir em window -> preferences -> servers -> installed runtimes
Ir em add..., irá abrir a janela New server runtime, então selecionar Apache Tomcat v7.0
Em next, selecionar o arquivo do Tomcat e finish.


Criando o banco de dados
**necessário mysql server 5.5**
rodar o código

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `teste` DEFAULT CHARACTER SET latin1 ;
USE `teste` ;

-- -----------------------------------------------------
-- Table `teste`.`Utilizador`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `teste`.`Utilizador` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(50) NOT NULL ,
  `sobrenome` VARCHAR(50) NOT NULL ,
  `email` VARCHAR(50) NOT NULL ,
  `genero` VARCHAR(20) NOT NULL ,
  `senha` VARCHAR(50) NOT NULL ,
  `apelido` VARCHAR(50) NOT NULL ,
  `dataNascimento` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 1267
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teste`.`Blog`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `teste`.`Blog` (
  `idBlog` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `titulo` VARCHAR(50) NOT NULL ,
  `categoria` VARCHAR(50) NOT NULL ,
  `dataCriacao` DATE NOT NULL ,
  `idUtilizador` INT(10) UNSIGNED NULL DEFAULT NULL ,
  PRIMARY KEY (`idBlog`) ,
  INDEX `fk_idUtilizador` (`idUtilizador` ASC) ,
  CONSTRAINT `fk_idUtilizador`
    FOREIGN KEY (`idUtilizador` )
    REFERENCES `teste`.`Utilizador` (`id` ))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teste`.`Publicacao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `teste`.`Publicacao` (
  `idPublicacao` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `tituloPublicacao` VARCHAR(50) NOT NULL ,
  `categoriaPublicacao` VARCHAR(50) NOT NULL ,
  `conteudoPublicacao` TEXT NOT NULL ,
  `idBlog` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `notaPublicacao` INT(11) NULL DEFAULT NULL ,
  `statusPublicacao` TINYINT(1) NULL DEFAULT NULL ,
  PRIMARY KEY (`idPublicacao`) ,
  INDEX `idBlog_Blog` (`idBlog` ASC) ,
  CONSTRAINT `idBlog_Blog`
    FOREIGN KEY (`idBlog` )
    REFERENCES `teste`.`Blog` (`idBlog` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teste`.`Comentario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `teste`.`Comentario` (
  `idComentario` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `conteudoComentario` TEXT NOT NULL ,
  `dataCriacaoComentario` DATE NOT NULL ,
  `idUtilizador` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `idPublicacao` INT(10) UNSIGNED NULL DEFAULT NULL ,
  PRIMARY KEY (`idComentario`) ,
  INDEX `idUtilizador_Utilizador` (`idUtilizador` ASC) ,
  INDEX `idPublicacao_Publicacao` (`idPublicacao` ASC) ,
  CONSTRAINT `idPublicacao_Publicacao`
    FOREIGN KEY (`idPublicacao` )
    REFERENCES `teste`.`Publicacao` (`idPublicacao` ),
  CONSTRAINT `idUtilizador_Utilizador`
    FOREIGN KEY (`idUtilizador` )
    REFERENCES `teste`.`Utilizador` (`id` ))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `teste`.`Denuncia`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `teste`.`Denuncia` (
  `idDenuncia` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `dataDenuncia` DATE NOT NULL ,
  `conteudoDenuncia` TEXT NOT NULL ,
  `idBlog` INT(11) UNSIGNED NULL DEFAULT NULL ,
  `idUtilizador` INT(11) UNSIGNED NULL DEFAULT NULL ,
  `idPublicacao` INT(11) UNSIGNED NULL DEFAULT NULL ,
  PRIMARY KEY (`idDenuncia`) ,
  INDEX `idBlogDenuncia_Blog` (`idBlog` ASC) ,
  INDEX `idUtilizadorDenuncia_Utilizador` (`idUtilizador` ASC) ,
  INDEX `idPublicacaoDenuncia_Publicacao` (`idPublicacao` ASC) ,
  CONSTRAINT `idBlogDenuncia_Blog`
    FOREIGN KEY (`idBlog` )
    REFERENCES `teste`.`Blog` (`idBlog` ),
  CONSTRAINT `idPublicacaoDenuncia_Publicacao`
    FOREIGN KEY (`idPublicacao` )
    REFERENCES `teste`.`Publicacao` (`idPublicacao` ),
  CONSTRAINT `idUtilizadorDenuncia_Utilizador`
    FOREIGN KEY (`idUtilizador` )
    REFERENCES `teste`.`Utilizador` (`id` ))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




Provaveçmente deve rodar
