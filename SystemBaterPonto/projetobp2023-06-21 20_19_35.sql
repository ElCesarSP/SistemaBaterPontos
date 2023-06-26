-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.28-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para projetobp
CREATE DATABASE IF NOT EXISTS `projetobp` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `projetobp`;

-- Copiando estrutura para tabela projetobp.horario
CREATE TABLE IF NOT EXISTS `horario` (
  `id_horario` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `horarioInicio` varchar(50) NOT NULL,
  `horarioTermino` varchar(50) NOT NULL,
  `dataAcesso` varchar(50) NOT NULL,
  PRIMARY KEY (`id_horario`),
  KEY `id` (`id`),
  CONSTRAINT `FK_horario_usuario` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`) ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela projetobp.horario: ~1 rows (aproximadamente)
DELETE FROM `horario`;
INSERT INTO `horario` (`id_horario`, `id`, `horarioInicio`, `horarioTermino`, `dataAcesso`) VALUES
	(1, 6, '9:00', '19:00', '01-08-2023');

-- Copiando estrutura para tabela projetobp.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `usuarios` varchar(50) NOT NULL,
  `senha` varchar(16) NOT NULL,
  `cpf` varchar(50) NOT NULL,
  `rg` varchar(50) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `dataNascimento` varchar(50) NOT NULL,
  `IndentificadoUnico` varchar(50) NOT NULL,
  `telefone` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `rua` varchar(50) NOT NULL,
  `referencia` varchar(50) NOT NULL,
  `complemento` varchar(50) NOT NULL,
  `numero` varchar(50) NOT NULL,
  `cep` varchar(50) NOT NULL,
  `id_horario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_horario` (`id_horario`),
  CONSTRAINT `FK_usuario_horario` FOREIGN KEY (`id_horario`) REFERENCES `horario` (`id_horario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela projetobp.usuario: ~9 rows (aproximadamente)
DELETE FROM `usuario`;
INSERT INTO `usuario` (`id`, `nome`, `usuarios`, `senha`, `cpf`, `rg`, `cargo`, `dataNascimento`, `IndentificadoUnico`, `telefone`, `estado`, `cidade`, `bairro`, `rua`, `referencia`, `complemento`, `numero`, `cep`, `id_horario`) VALUES
	(1, 'Cesar dos Santos Pinto', 'cesaradmin', 'lokoloko0102030', '066.277.155-97', '14.145.587-97', '', '02/07/1999', '125478', '(77)9 8103-7688', 'Bahia', 'Guanambi', 'Lagoinha', 'Albina Goncalves Dantas', 'Perto da sorveria', 'Moradia em Casa', '252', '43460-000', 0),
	(2, 'asdasdasd', 'aleatorio', 'sdadasd', 'dasdasd', 'dasdasda', '', 'dasdasdas', 'dasdasdasd', 'dasdasdasd', 'asdasdasdas', 'dasdasdas', 'sdasdasd', 'asdasdasd', 'dasdasd', 'dasdasdas', 'dasdas', 'dasdasd', 0),
	(3, 'paulo', 'paulo25', '147852', '', 'sdasd', '', '', '', '', '', '', '', '', '', '', '', '', 0),
	(6, 'Igor', 'igor25', 'igor25', '568.568.456-97', '785.785.458-82', 'igor25', '11/12/1992', '125', 'igor25', 'igor25', 'igor25', 'igor25', 'igor25', 'perto da escola joaquim dias', 'igor25', 'igor25', 'igor25', 0),
	(9, 'Carlos Andre Santos', 'Desempregado', 'Carlos3278', 'carlos3278', '12.458.785-32', '125.458.698-78', '12/12/1999', '1', '(77)9 8888-8888', 'Bahia', 'Guanambi', 'Monte Pascoal', 'Mendingos frota', 'perto da quadra esportiva', 'casa', '258', '46430-000', 0),
	(16, 'Gildete dos Santos Mender', 'gildete75', 'gildete75', '555.555.555-87', '444.444.555-45', 'Dona de casa', '17/08/1971', '75', '(77)9  9999-9999', 'Bahia', 'Guanambi', 'Lagoinha', 'Albino Gonçalves Dantas', 'Perto a sorveteria Sorv-Ace', 'Maradia em casa', '252', '46430-000', 0),
	(21, 'João da Silva', 'joao123', 'senha123', '123.456.789-10', '123456789', 'Gerente', '1990-01-01', 'ABC123', '(11) 98765-4321', 'São Paulo', 'São Paulo', 'Centro', 'Rua Principal', 'Próximo ao parque', 'Apartmento 101', '123', '01234-567', 0),
	(28, 'dasdasdasd', 'dasdasdad', 'dasdasdas', 'dasdasd', 'dasdasd', 'dasdasd', 'asdasd', 'dsadasda', 'saddad', 'dasdasddas', 'dasdad', 'dasdas', 'dadsdsad', 'dasdad', 'adasda', 'dasdasda', 'dasdasd', 0),
	(29, 'dadasd', 'asdasdas', 'asdasdasdas', 'asdasdd', 'dasdad', 'sdadasd', 'asdasdasd', 'dasdasda', 'dasdasd', 'asddad', 'dadad', 'dsadasd', 'sadsadasd', 'asdasda', 'saddasd', 'dasdasd', 'dadasd', 0);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
