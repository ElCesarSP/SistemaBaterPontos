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

-- Copiando estrutura para tabela projetobp.horas
CREATE TABLE IF NOT EXISTS `horas` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `horas` varchar(50) DEFAULT NULL,
  `horasPecorrida` varchar(50) DEFAULT NULL,
  `datas` varchar(50) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `horas_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela projetobp.horas: ~28 rows (aproximadamente)
DELETE FROM `horas`;
INSERT INTO `horas` (`id`, `nome`, `horas`, `horasPecorrida`, `datas`, `id_usuario`) VALUES
	(0, 'Cesar dos Santos Pinto', '07:00', '8', '2023-06-01', 1),
	(1, 'Cesar dos Santos Pinto', '07:01', '8', '2023-06-02', 1),
	(2, 'Cesar dos Santos Pinto', '07:07', '8', '2023-06-03', 1),
	(3, 'Cesar dos Santos Pinto', '07:02', '8', '2023-06-04', 1),
	(4, 'Cesar dos Santos Pinto', '07:00', '7', '2023-06-05', 1),
	(5, 'Cesar dos Santos Pinto', '07:00', '8', '2023-06-06', 1),
	(6, 'Cesar dos Santos Pinto', '07:07', '6', '2023-06-07', 1),
	(7, 'Cesar dos Santos Pinto', '07:01', '8', '2023-06-08', 1),
	(8, 'Cesar dos Santos Pinto', '07:00', '7', '2023-06-09', 1),
	(9, 'Cesar dos Santos Pinto', '07:04', '8', '2023-06-10', 1),
	(10, 'Gildete dos Santos Mender', '16:00', '8', '2023-07-03', 16),
	(11, 'Gildete dos Santos Mender', '16:05', '8', '2023-07-04', 16),
	(12, 'Gildete dos Santos Mender', '16:01', '8', '2023-07-05', 16),
	(13, 'Gildete dos Santos Mender', '16:03', '8', '2023-07-06', 16),
	(14, 'Gildete dos Santos Mender', '16:00', '8', '2023-07-07', 16),
	(15, 'Gildete dos Santos Mender', '16:02', '8', '2023-07-08', 16),
	(16, 'Gildete dos Santos Mender', '15:02', '8', '2023-07-09', 16),
	(17, 'Cesar dos Santos Pinto', '07:03', '8', '2023-07-19', 1),
	(18, 'Cesar dos Santos Pinto', '07:00', '7', '2023-07-20', 1),
	(19, 'Cesar dos Santos Pinto', '07:02', '8', '2023-07-21', 1),
	(20, 'Cesar dos Santos Pinto', '07:01', '8', '2023-07-22', 1),
	(21, 'Cesar dos Santos Pinto', '07:04', '8', '2023-07-23', 1),
	(22, 'Cesar dos Santos Pinto', '07:01', '7', '2023-07-24', 1),
	(23, 'Cesar dos Santos Pinto', '07:06', '8', '2023-07-25', 1),
	(24, 'Gildete dos Santos Mender', '16:00', '8', '2023-08-02', 16),
	(25, 'Gildete dos Santos Mender', '16:05', '7', '2023-08-03', 16),
	(26, 'Gildete dos Santos Mender', '16:00', '8', '2023-08-04', 16),
	(27, 'Gildete dos Santos Mender', '16:00', '8', '2023-08-05', 16);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
