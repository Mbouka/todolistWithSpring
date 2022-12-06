-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 30 nov. 2022 à 14:52
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `todolist`
--

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(5);

-- --------------------------------------------------------

--
-- Structure de la table `todo`
--

DROP TABLE IF EXISTS `todo`;
CREATE TABLE IF NOT EXISTS `todo` (
  `id` bigint(20) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `todo`
--

INSERT INTO `todo` (`id`, `content`, `date`, `status`, `title`) VALUES
(1, 'je travaille trop dur', '2022-11-30', NULL, 'bon boulot'),
(2, 'je travaille trop dur', '2022-11-30', 'URGENT', 'travailler sur le projet '),
(3, 'je travaille trop dur', '2022-11-30', 'URGENT', 'dd'),
(4, 'work', '2022-11-30', 'Now', 'hjks');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
