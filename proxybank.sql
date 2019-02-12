-- --------------------------------------------------------
-- Hôte :                        localhost
-- Version du serveur:           5.7.19 - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Export de la structure de la base pour proxybank
CREATE DATABASE IF NOT EXISTS `proxybank` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `proxybank`;

-- Export de la structure de la table proxybank. agence
CREATE TABLE IF NOT EXISTS `agence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero_id` varchar(5) DEFAULT NULL,
  `date_creation` date DEFAULT NULL,
  `bank_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numeroID_UNIQUE` (`numero_id`),
  KEY `fk_agence_bank1_idx` (`bank_id`),
  CONSTRAINT `fk_agence_bank1` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Export de données de la table proxybank.agence : ~0 rows (environ)
/*!40000 ALTER TABLE `agence` DISABLE KEYS */;
/*!40000 ALTER TABLE `agence` ENABLE KEYS */;

-- Export de la structure de la table proxybank. bank
CREATE TABLE IF NOT EXISTS `bank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Export de données de la table proxybank.bank : ~0 rows (environ)
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;

-- Export de la structure de la table proxybank. carte_bancaire
CREATE TABLE IF NOT EXISTS `carte_bancaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL COMMENT 'On a deux types de cartes: visa electron et visa premier',
  `actif` tinyint(4) DEFAULT '1',
  `numero` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_UNIQUE` (`numero`),
  KEY `fk_carte_bancaire_client1_idx` (`client_id`),
  CONSTRAINT `fk_carte_bancaire_client1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Export de données de la table proxybank.carte_bancaire : ~0 rows (environ)
/*!40000 ALTER TABLE `carte_bancaire` DISABLE KEYS */;
/*!40000 ALTER TABLE `carte_bancaire` ENABLE KEYS */;

-- Export de la structure de la table proxybank. client
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `profession` varchar(45) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `ville` varchar(45) DEFAULT NULL,
  `code_postal` varchar(45) DEFAULT NULL,
  `adresse` varchar(45) DEFAULT NULL,
  `utilisateur_id` int(11) NOT NULL COMMENT 'C''est l''identification du conseiller rattaché au client',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_client_utilisateur1_idx` (`utilisateur_id`),
  CONSTRAINT `fk_client_utilisateur1` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Export de données de la table proxybank.client : ~0 rows (environ)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Export de la structure de la table proxybank. compte
CREATE TABLE IF NOT EXISTS `compte` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Il s''agit d''un compte bancaire',
  `date_ouverture` date DEFAULT NULL,
  `numero_compte` varchar(45) DEFAULT NULL,
  `solde` double DEFAULT '0',
  `client_id` int(11) NOT NULL,
  `decouvert` int(11) DEFAULT NULL,
  `remuneration` float DEFAULT NULL COMMENT 'C''est le taux d''intérêt.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_compte_UNIQUE` (`numero_compte`),
  KEY `fk_compte_client1_idx` (`client_id`),
  CONSTRAINT `fk_compte_client1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Export de données de la table proxybank.compte : ~0 rows (environ)
/*!40000 ALTER TABLE `compte` DISABLE KEYS */;
/*!40000 ALTER TABLE `compte` ENABLE KEYS */;

-- Export de la structure de la table proxybank. transaction
CREATE TABLE IF NOT EXISTS `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `compte_id_source` int(11) DEFAULT NULL,
  `compte_id_destination` int(11) NOT NULL,
  `type` varchar(10) DEFAULT NULL COMMENT 'Le type peut avoir les valeurs suivantes: VIREMENT, CREDIT, DEBIT.',
  `montant` double DEFAULT NULL,
  `date_transac` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_compte_has_compte_compte2_idx` (`compte_id_destination`),
  KEY `fk_compte_has_compte_compte1_idx` (`compte_id_source`),
  KEY `date_indx` (`date_transac`),
  CONSTRAINT `fk_compte_has_compte_compte1` FOREIGN KEY (`compte_id_source`) REFERENCES `compte` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compte_has_compte_compte2` FOREIGN KEY (`compte_id_destination`) REFERENCES `compte` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Export de données de la table proxybank.transaction : ~0 rows (environ)
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;

-- Export de la structure de la table proxybank. utilisateur
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `fonction` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `agence_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  KEY `fk_utilisateur_agence1_idx` (`agence_id`),
  CONSTRAINT `fk_utilisateur_agence1` FOREIGN KEY (`agence_id`) REFERENCES `agence` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Export de données de la table proxybank.utilisateur : ~0 rows (environ)
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
