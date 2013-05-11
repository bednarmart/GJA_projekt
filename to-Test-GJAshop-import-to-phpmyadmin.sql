-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 11, 2013 at 01:43 PM
-- Server version: 5.5.31
-- PHP Version: 5.3.10-1ubuntu3.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `GJAshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `id` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `addressbinding`
--

CREATE TABLE IF NOT EXISTS `addressbinding` (
  `id` int(11) NOT NULL,
  `deliveryhome` bit(1) DEFAULT NULL,
  `address` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAEDF781176B58A6` (`address`),
  KEY `FKAEDF781134BD9F98` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'dress'),
(2, 'Accessories'),
(3, 'Jeans');

-- --------------------------------------------------------

--
-- Table structure for table `clientorder`
--

CREATE TABLE IF NOT EXISTS `clientorder` (
  `id` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `delivery` int(11) NOT NULL,
  `paymenttype` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF6863A63280FA25E` (`paymenttype`),
  KEY `FKF6863A63D9722EEA` (`delivery`),
  KEY `FKF6863A6334BD9F98` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE IF NOT EXISTS `contact` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contactbinding`
--

CREATE TABLE IF NOT EXISTS `contactbinding` (
  `id` int(11) NOT NULL,
  `contact` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7B6AA6651AA68FE` (`contact`),
  KEY `FK7B6AA66534BD9F98` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `delivery`
--

CREATE TABLE IF NOT EXISTS `delivery` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `IdentityGenerator`
--

CREATE TABLE IF NOT EXISTS `IdentityGenerator` (
  `sequence_name` varchar(100) DEFAULT NULL,
  `next_hi_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `IdentityGenerator`
--

INSERT INTO `IdentityGenerator` (`sequence_name`, `next_hi_value`) VALUES
('Sign', 1),
('Category', 1),
('Segment', 1),
('Product', 1),
('Picture', 1);

-- --------------------------------------------------------

--
-- Table structure for table `paymenttype`
--

CREATE TABLE IF NOT EXISTS `paymenttype` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `picture`
--

CREATE TABLE IF NOT EXISTS `picture` (
  `id` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `product` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKDD905CFE6B57BA9C` (`product`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `picture`
--

INSERT INTO `picture` (`id`, `path`, `product`) VALUES
(1, 'pic/dress/evening/alinePrincesOneShoulder.jpg', 1),
(2, 'pic/dress/evening/sheathSweetheartEvning.jpg', 2),
(3, 'pic/dress/evening/sheathScallopedNeckSweepTrainChiffonEveningDressWithBeading.jpg', 3),
(4, 'pic/jeans/slim/carhartt.jpg', 4),
(5, 'pic/jeans/slim/carhartt-gray.jpg', 5);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `segment` int(11) NOT NULL,
  `sign` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKED8DCCEF7B855F24` (`segment`),
  KEY `FKED8DCCEF34BB837C` (`sign`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `color`, `count`, `name`, `price`, `sex`, `size`, `segment`, `sign`) VALUES
(1, NULL, 2, 'A-Line/Princess One-Shoulder Floor-Length Chiffon Evening Dress With Ruffle Beading Sequins', 8000, 0, NULL, 2, 1),
(2, NULL, 3, 'Sheath Sweetheart Floor-Length Chiffon Evening Dress With Ruffle', 9000, 0, NULL, 2, 2),
(3, NULL, 1, 'Sheath Scalloped Neck Sweep Train Chiffon Evening Dress With Beading', 13000, 0, NULL, 2, 2),
(4, NULL, 7, 'Carhartt', 3000, 0, NULL, 10, 2),
(5, NULL, 0, 'Carhartt', 3000, 0, NULL, 10, 2);

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `id` int(11) NOT NULL,
  `value` int(11) DEFAULT NULL,
  `product` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC815B19D6B57BA9C` (`product`),
  KEY `FKC815B19D34BD9F98` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `segment`
--

CREATE TABLE IF NOT EXISTS `segment` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `category` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK75A49F337D4D70FE` (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `segment`
--

INSERT INTO `segment` (`id`, `name`, `category`) VALUES
(1, 'Prom', 1),
(2, 'Evening', 1),
(3, 'Club', 1),
(4, 'Mini', 1),
(5, 'Belt', 1),
(6, 'Hat', 1),
(7, 'Gloves', 1),
(8, 'Club', 1),
(9, 'Boocut', 1),
(10, 'Slim', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sign`
--

CREATE TABLE IF NOT EXISTS `sign` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sign`
--

INSERT INTO `sign` (`id`, `name`) VALUES
(1, 'GUCI'),
(2, 'CICI'),
(3, 'BUFU');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `privilegy` int(11) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `addressbinding`
--
ALTER TABLE `addressbinding`
  ADD CONSTRAINT `FKAEDF781134BD9F98` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKAEDF781176B58A6` FOREIGN KEY (`address`) REFERENCES `address` (`id`);

--
-- Constraints for table `clientorder`
--
ALTER TABLE `clientorder`
  ADD CONSTRAINT `FKF6863A6334BD9F98` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKF6863A63280FA25E` FOREIGN KEY (`paymenttype`) REFERENCES `paymenttype` (`id`),
  ADD CONSTRAINT `FKF6863A63D9722EEA` FOREIGN KEY (`delivery`) REFERENCES `delivery` (`id`);

--
-- Constraints for table `contactbinding`
--
ALTER TABLE `contactbinding`
  ADD CONSTRAINT `FK7B6AA66534BD9F98` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK7B6AA6651AA68FE` FOREIGN KEY (`contact`) REFERENCES `contact` (`id`);

--
-- Constraints for table `picture`
--
ALTER TABLE `picture`
  ADD CONSTRAINT `FKDD905CFE6B57BA9C` FOREIGN KEY (`product`) REFERENCES `product` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FKED8DCCEF34BB837C` FOREIGN KEY (`sign`) REFERENCES `sign` (`id`),
  ADD CONSTRAINT `FKED8DCCEF7B855F24` FOREIGN KEY (`segment`) REFERENCES `segment` (`id`);

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `FKC815B19D34BD9F98` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKC815B19D6B57BA9C` FOREIGN KEY (`product`) REFERENCES `product` (`id`);

--
-- Constraints for table `segment`
--
ALTER TABLE `segment`
  ADD CONSTRAINT `FK75A49F337D4D70FE` FOREIGN KEY (`category`) REFERENCES `category` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
