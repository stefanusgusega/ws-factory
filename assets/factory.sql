-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2020 at 12:48 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `factory`
--

-- --------------------------------------------------------

--
-- Table structure for table `add_stock`
--

CREATE TABLE `add_stock` (
  `id_add_stock` int(11) NOT NULL,
  `id_cokelat` int(8) NOT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bahan`
--

CREATE TABLE `bahan` (
  `id_bahan` int(11) NOT NULL,
  `nama_bahan` varchar(50) NOT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `tanggal_kadaluwarsa` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bahan`
--

INSERT INTO `bahan` (`id_bahan`, `nama_bahan`, `jumlah`, `tanggal_kadaluwarsa`) VALUES
(1, 'susu', 30, '2022-10-01'),
(2, 'kakao', 50, '2022-10-01'),
(3, 'gula pasir', 50, '2022-10-01'),
(4, 'vanilla', 50, '2022-10-01'),
(5, 'madu', 50, '2022-10-01'),
(6, 'garam', 50, '2022-10-01'),
(7, 'minyak kelapa', 50, '2022-10-01'),
(8, 'bubuk cocoa', 50, '2022-10-01'),
(9, 'wallnut', 50, '2022-10-01'),
(10, 'kelapa', 50, '2022-10-01'),
(11, 'almond', 50, '2022-10-01'),
(12, 'sprinkle', 50, '2022-10-01'),
(13, 'coffee', 50, '2022-10-01'),
(14, 'jeruk', 50, '2022-10-01'),
(16, 'mesis coklat', 50, '2022-10-01'),
(17, 'mesis mix', 50, '2022-10-01'),
(18, 'cocoa butter', 50, '2022-10-01'),
(19, 'mentega', 50, '2022-10-01'),
(20, 'tepung terigu', 50, '2022-10-01'),
(21, 'baking soda', 50, '2022-10-01'),
(22, 'gula aren', 50, '2022-10-01'),
(23, 'telur', 50, '2022-10-01'),
(24, 'milk choco', 50, '0000-00-00'),
(25, 'white choco', 50, '0000-00-00'),
(26, 'dark choco', 50, '0000-00-00'),
(27, 'pewarna makanan', 50, '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `gudang`
--

CREATE TABLE `gudang` (
  `id_coklat` int(11) DEFAULT NULL,
  `nama_coklat` varchar(30) NOT NULL,
  `jumlah` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gudang`
--

INSERT INTO `gudang` (`id_coklat`, `nama_coklat`, `jumlah`) VALUES
(1, 'Dark chocolate', 100),
(2, 'JJ8', 100),
(3, 'choco', 100),
(4, 'Susanti Gojali', 100),
(5, 'coco', 100),
(6, 'fefe', 100),
(7, 'dwdw', 100),
(8, 'okok', 100),
(9, 'jj\'0', 100),
(10, 'chacha', 100);

-- --------------------------------------------------------

--
-- Table structure for table `resep`
--

CREATE TABLE `resep` (
  `id_coklat` int(11) DEFAULT NULL,
  `nama_coklat` varchar(30) DEFAULT NULL,
  `nama_bahan` varchar(50) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `resep`
--

INSERT INTO `resep` (`id_coklat`, `nama_coklat`, `nama_bahan`, `jumlah`) VALUES
(1, 'Dark chocolate', 'kakao', 100),
(1, 'Dark chocolate', 'gula pasir', 100),
(1, 'Dark chocolate', 'garam', 100),
(2, 'JJ8', 'white choco', 100),
(2, 'JJ8', 'dark choco', 100),
(2, 'JJ8', 'milk choco', 100),
(2, 'JJ8', 'gula pasir', 100),
(2, 'JJ8', 'gula aren', 100),
(2, 'JJ8', 'susu', 100),
(3, 'choco', 'white choco', 100),
(3, 'choco', 'dark choco', 100),
(3, 'choco', 'milk choco', 100),
(3, 'choco', 'susu', 100),
(3, 'choco', 'gula pasir', 100),
(3, 'choco', 'gula aren', 100),
(3, 'choco', 'bubuk cocoa', 100),
(2, 'JJ8', 'bubuk cocoa', 100),
(4, 'Susanti Gojali', 'susu', 100),
(4, 'Susanti Gojali', 'kakao', 100),
(4, 'Susanti Gojali', 'gula pasir', 100),
(4, 'Susanti Gojali', 'cocoa butter', 100),
(4, 'Susanti Gojali', 'garam', 100),
(4, 'Susanti Gojali', 'vanilla', 100),
(5, 'coco', 'telur', 100),
(5, 'coco', 'gula pasir', 100),
(5, 'coco', 'tepung terigu', 100),
(5, 'coco', 'baking soda', 100),
(5, 'coco', 'bubuk cocoa', 100),
(5, 'coco', 'mentega', 100),
(6, 'fefe', 'gula pasir', 100),
(6, 'fefe', 'tepung terigu', 100),
(6, 'fefe', 'baking soda', 100),
(6, 'fefe', 'bubuk cocoa', 100),
(6, 'fefe', 'almond', 100),
(6, 'fefe', 'wallnut', 100),
(6, 'fefe', 'mentega', 100),
(6, 'fefe', 'white choco', 100),
(6, 'fefe', 'milk choco', 100),
(7, 'dwdw', 'milk choco', 100),
(7, 'dwdw', 'sprinkle', 100),
(7, 'dwdw', 'gula pasir', 100),
(7, 'dwdw', 'tepung terigu', 100),
(7, 'dwdw', 'dark choco', 100),
(8, 'okok', 'milk choco', 100),
(8, 'okok', 'tepung terigu', 100),
(8, 'okok', 'mesis coklat', 100),
(8, 'okok', 'sprinkle', 100),
(8, 'okok', 'wallnut', 100),
(8, 'okok', 'gula pasir', 100),
(8, 'okok', 'bubuk cocoa', 100),
(9, 'jj\'0', 'white choco', 100),
(9, 'jj\'0', 'dark choco', 100),
(9, 'jj\'0', 'milk choco', 100),
(9, 'jj\'0', 'susu', 100),
(9, 'jj\'0', 'gula pasir', 100),
(9, 'jj\'0', 'gula aren', 100),
(9, 'jj\'0', 'pewarna makanan', 100),
(9, 'jj\'0', 'bubuk cocoa', 100),
(10, 'chacha', 'milk choco', 100),
(10, 'chacha', 'pewarna makanan', 100),
(10, 'chacha', 'gula pasir', 100);

-- --------------------------------------------------------

--
-- Table structure for table `saldo`
--

CREATE TABLE `saldo` (
  `uang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `saldo`
--

INSERT INTO `saldo` (`uang`) VALUES
(500000000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `add_stock`
--
ALTER TABLE `add_stock`
  ADD PRIMARY KEY (`id_add_stock`);

--
-- Indexes for table `bahan`
--
ALTER TABLE `bahan`
  ADD PRIMARY KEY (`id_bahan`),
  ADD UNIQUE KEY `unique_nama_bahan` (`nama_bahan`);

--
-- Indexes for table `resep`
--
ALTER TABLE `resep`
  ADD KEY `fk_namabahan_tbl_resep` (`nama_bahan`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `add_stock`
--
ALTER TABLE `add_stock`
  MODIFY `id_add_stock` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `bahan`
--
ALTER TABLE `bahan`
  MODIFY `id_bahan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `resep`
--
ALTER TABLE `resep`
  ADD CONSTRAINT `fk_namabahan_tbl_resep` FOREIGN KEY (`nama_bahan`) REFERENCES `bahan` (`nama_bahan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
