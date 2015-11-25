-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema StudentHelper
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema StudentHelper
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `StudentHelper` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
-- -----------------------------------------------------
-- Schema webDBPrueba
-- -----------------------------------------------------
USE `StudentHelper` ;

-- -----------------------------------------------------
-- Table `StudentHelper`.`USUARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentHelper`.`USUARIO` (
  `EMAILUSR` VARCHAR(20) NOT NULL COMMENT '',
  `PASSWORDUSR` VARCHAR(20) NULL COMMENT '',
  `NOMBREUSR` VARCHAR(45) NULL COMMENT '',
  `APELLIDOUSR` VARCHAR(45) NULL COMMENT '',
  `ESTADOUSR` TINYINT(1) NULL COMMENT '',
  `ADMINISTRADORUSR` TINYINT(1) NULL COMMENT '',
  `FOTOPERFILUSR` VARCHAR(300) NULL COMMENT '',
  PRIMARY KEY (`EMAILUSR`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentHelper`.`MATERIA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentHelper`.`MATERIA` (
  `IDMATERIA` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `NOMBREMATERIA` VARCHAR(40) NOT NULL COMMENT '',
  `PROFESORMATERIA` VARCHAR(50) NULL COMMENT '',
  `AULAMATERIA` VARCHAR(40) NULL COMMENT '',
  `USUARIO_EMAILUSR` VARCHAR(20) NOT NULL COMMENT '',
  PRIMARY KEY (`IDMATERIA`)  COMMENT '',
  INDEX `fk_MATERIA_USUARIO1_idx` (`USUARIO_EMAILUSR` ASC)  COMMENT '',
  CONSTRAINT `fk_MATERIA_USUARIO1`
    FOREIGN KEY (`USUARIO_EMAILUSR`)
    REFERENCES `StudentHelper`.`USUARIO` (`EMAILUSR`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentHelper`.`HORARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentHelper`.`HORARIO` (
  `IDHORARIO` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `INICIOHORARIO` VARCHAR(6) NULL COMMENT '',
  `FINHORARIO` VARCHAR(6) NULL COMMENT '',
  `DIAHORARIO` VARCHAR(10) NULL COMMENT '',
  `MATERIA_IDMATERIA` INT NOT NULL COMMENT '',
  PRIMARY KEY (`IDHORARIO`)  COMMENT '',
  INDEX `fk_HORARIO_MATERIA1_idx` (`MATERIA_IDMATERIA` ASC)  COMMENT '',
  CONSTRAINT `fk_HORARIO_MATERIA1`
    FOREIGN KEY (`MATERIA_IDMATERIA`)
    REFERENCES `StudentHelper`.`MATERIA` (`IDMATERIA`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentHelper`.`TAREA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentHelper`.`TAREA` (
  `IDTAREA` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `TITULOTAREA` VARCHAR(40) NULL COMMENT '',
  `DESCRIPCIONTAREA` VARCHAR(100) NULL COMMENT '',
  `FECHAENTREGATAREA` VARCHAR(12) NULL COMMENT '',
  `MATERIA_IDMATERIA` INT NOT NULL COMMENT '',
  PRIMARY KEY (`IDTAREA`)  COMMENT '',
  INDEX `fk_TAREA_MATERIA1_idx` (`MATERIA_IDMATERIA` ASC)  COMMENT '',
  CONSTRAINT `fk_TAREA_MATERIA1`
    FOREIGN KEY (`MATERIA_IDMATERIA`)
    REFERENCES `StudentHelper`.`MATERIA` (`IDMATERIA`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `StudentHelper`.`EXAMEN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `StudentHelper`.`EXAMEN` (
  `IDEXAMEN` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `FECHAEXAMEN` VARCHAR(12) NULL COMMENT '',
  `TEMAEXAMEN` VARCHAR(45) NULL COMMENT '',
  `MATERIA_IDMATERIA` INT NOT NULL COMMENT '',
  PRIMARY KEY (`IDEXAMEN`)  COMMENT '',
  INDEX `fk_EXAMEN_MATERIA1_idx` (`MATERIA_IDMATERIA` ASC)  COMMENT '',
  CONSTRAINT `fk_EXAMEN_MATERIA1`
    FOREIGN KEY (`MATERIA_IDMATERIA`)
    REFERENCES `StudentHelper`.`MATERIA` (`IDMATERIA`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
