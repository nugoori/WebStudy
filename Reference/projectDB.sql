-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydaily
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydaily
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydaily` DEFAULT CHARACTER SET utf8 ;
USE `mydaily` ;

-- -----------------------------------------------------
-- Table `mydaily`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydaily`.`user` (
  `email` VARCHAR(45) NOT NULL COMMENT '사용자 이메일',
  `password` VARCHAR(225) NOT NULL COMMENT '사용자 비밀번호',
  `nickname` VARCHAR(45) NOT NULL COMMENT '사용자 닉네임',
  `profile` TEXT NULL DEFAULT NULL COMMENT '사용자 프로필 사진 URL',
  `height` TEXT NOT NULL COMMENT '사용자 키',
  `weight` TEXT NOT NULL COMMENT '사용자 몸무게',
  `gender` TEXT NOT NULL COMMENT '사용자 성별',
  PRIMARY KEY (`email`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydaily`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydaily`.`board` (
  `board_number` INT NOT NULL AUTO_INCREMENT COMMENT '게시물 번호',
  `board_content` TEXT NULL DEFAULT NULL COMMENT '게시물 내용',
  `board_img_url_1` TEXT NOT NULL COMMENT '게시물 이미지 URL',
  `board_img_url_2` TEXT NULL DEFAULT NULL COMMENT '게시물 이미지 URL',
  `board_img_url_3` TEXT NULL DEFAULT NULL COMMENT '게시물 이미지 URL',
  `tag` VARCHAR(45) NOT NULL COMMENT '검색을 위한 스타일태그',
  `board_write_time` DATETIME NOT NULL DEFAULT now() COMMENT '게시물을 작성한 날짜, 시간',
  `writer_email` VARCHAR(45) NOT NULL COMMENT '게시물 작성자 이메일',
  `writer_nickname` VARCHAR(45) NOT NULL COMMENT '게시물 작성자 닉네임',
  `writer_profile_url` TEXT NULL DEFAULT NULL COMMENT '게시물 작성자 프로필 사진 URL',
  `comment_count` INT NOT NULL DEFAULT 0 COMMENT '댓글 수',
  `like_count` INT NOT NULL DEFAULT 0 COMMENT '좋아요 수',
  `view_count` INT NOT NULL DEFAULT 0 COMMENT '조회수',
  PRIMARY KEY (`board_number`),
  INDEX `fk_board_user1_idx` (`writer_email` ASC) VISIBLE,
  CONSTRAINT `fk_board_user1`
    FOREIGN KEY (`writer_email`)
    REFERENCES `mydaily`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '게시글';


-- -----------------------------------------------------
-- Table `mydaily`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydaily`.`product` (
  `product_number` INT NOT NULL AUTO_INCREMENT COMMENT '게시물에 등록한 상품 번호',
  `product_name` TEXT NULL DEFAULT NULL COMMENT '게시물에 등록한 상품 이름',
  `product_price` INT NULL DEFAULT NULL COMMENT '게시물에 등록한 상품 가격',
  `product_url` TEXT NULL DEFAULT NULL COMMENT '게시물에 등록한 상품 구매 링크',
  `product_img_url` TEXT NULL DEFAULT NULL COMMENT '게시물에 등록한 상품 이미지 URL',
  PRIMARY KEY (`product_number`))
ENGINE = InnoDB
COMMENT = '게시물에 등록한 아이템';


-- -----------------------------------------------------
-- Table `mydaily`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydaily`.`comment` (
  `comment_number` INT NOT NULL AUTO_INCREMENT COMMENT '댓글 고유 번호',
  `board_number` INT NOT NULL COMMENT '댓글을 작성한 게시물 번호',
  `writer_email` VARCHAR(45) NOT NULL COMMENT '댓글 작성자 이메일',
  `writer_nickname` TEXT NOT NULL COMMENT '댓글 작성자 닉네임',
  `writer_profile_url` TEXT NULL DEFAULT NULL COMMENT '댓글 작성자 프로필 사진 URL',
  `write_date` DATETIME NOT NULL DEFAULT now() COMMENT '댓글 작성 시간',
  `comment_content` TEXT NOT NULL COMMENT '댓글 내용',
  PRIMARY KEY (`comment_number`),
  INDEX `fk_comment_board1_idx` (`board_number` ASC) VISIBLE,
  INDEX `fk_comment_user1_idx` (`writer_email` ASC) VISIBLE,
  UNIQUE INDEX `comment_number_UNIQUE` (`comment_number` ASC) VISIBLE,
  CONSTRAINT `fk_comment_board1`
    FOREIGN KEY (`board_number`)
    REFERENCES `mydaily`.`board` (`board_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`writer_email`)
    REFERENCES `mydaily`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydaily`.`liky`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydaily`.`liky` (
  `board_number` INT NOT NULL COMMENT '좋아요를 누른 게시물 번호',
  `user_email` VARCHAR(45) NOT NULL COMMENT '좋아요를 누른 유저의 이메일',
  `user_nickname` TEXT NOT NULL COMMENT '좋아요를 누른 유저의 닉네임',
  `user_profile_url` TEXT NULL DEFAULT NULL COMMENT '좋아요 표시 이용자 프로필 사진 URL',
  PRIMARY KEY (`board_number`, `user_email`),
  INDEX `fk_liky_board1_idx` (`board_number` ASC) VISIBLE,
  INDEX `fk_liky_user1_idx` (`user_email` ASC) VISIBLE,
  CONSTRAINT `fk_liky_board1`
    FOREIGN KEY (`board_number`)
    REFERENCES `mydaily`.`board` (`board_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_liky_user1`
    FOREIGN KEY (`user_email`)
    REFERENCES `mydaily`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydaily`.`searchwordlog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydaily`.`searchwordlog` (
  `sequence` INT NOT NULL AUTO_INCREMENT COMMENT '검색어 시퀀스',
  `search_word` TEXT NOT NULL COMMENT '검색어',
  PRIMARY KEY (`sequence`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydaily`.`board_has_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydaily`.`board_has_product` (
  `board_number` INT NOT NULL COMMENT '상품이 개재된 게시물 번호',
  `product_number` INT NOT NULL COMMENT '개재된 상품의 번호',
  PRIMARY KEY (`board_number`, `product_number`),
  INDEX `fk_board_has_product_product1_idx` (`product_number` ASC) VISIBLE,
  INDEX `fk_board_has_product_board1_idx` (`board_number` ASC) VISIBLE,
  CONSTRAINT `fk_board_has_product_board1`
    FOREIGN KEY (`board_number`)
    REFERENCES `mydaily`.`board` (`board_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_board_has_product_product1`
    FOREIGN KEY (`product_number`)
    REFERENCES `mydaily`.`product` (`product_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
