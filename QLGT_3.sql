-- phpMyAdmin SQL Dump
-- version 4.6.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 07, 2016 at 11:34 AM
-- Server version: 5.7.12
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `QLGT`
--

-- --------------------------------------------------------

--
-- Table structure for table `giangvien`
--

CREATE TABLE `giangvien` (
  `MaGiangVien` int(10) UNSIGNED NOT NULL,
  `TenGiangVien` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MatKhau` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `SoDienThoai` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `MaKhoa` int(10) UNSIGNED NOT NULL,
  `MaHoiDong` int(10) UNSIGNED DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `giaotrinh`
--

CREATE TABLE `giaotrinh` (
  `MaGiaoTrinh` int(10) UNSIGNED NOT NULL,
  `TenGiaoTrinh` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NgayDangKy` date NOT NULL,
  `NgayHoanThanh` date NOT NULL,
  `TinhTrang` int(11) NOT NULL,
  `MaGiangVien` int(10) UNSIGNED NOT NULL,
  `MaHoiDong` int(10) UNSIGNED DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hoidong`
--

CREATE TABLE `hoidong` (
  `MaHoiDong` int(10) UNSIGNED NOT NULL,
  `TenHoiDong` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MaGiaoTrinh` int(10) UNSIGNED NOT NULL,
  `NgayThanhLap` datetime NOT NULL,
  `NgayNghiemThu` datetime NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khoa`
--

CREATE TABLE `khoa` (
  `MaKhoa` int(10) UNSIGNED NOT NULL,
  `TenKhoa` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2016_10_10_110902_Khoa', 1),
(2, '2016_10_11_114136_HoiDong', 1),
(3, '2016_10_15_114100_GiangVien', 1),
(4, '2016_10_15_114129_GiaoTrinh', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `giangvien`
--
ALTER TABLE `giangvien`
  ADD PRIMARY KEY (`MaGiangVien`),
  ADD KEY `giangvien_makhoa_foreign` (`MaKhoa`),
  ADD KEY `giangvien_mahoidong_foreign` (`MaHoiDong`);

--
-- Indexes for table `giaotrinh`
--
ALTER TABLE `giaotrinh`
  ADD PRIMARY KEY (`MaGiaoTrinh`),
  ADD KEY `giaotrinh_magiangvien_foreign` (`MaGiangVien`),
  ADD KEY `giaotrinh_mahoidong_foreign` (`MaHoiDong`);

--
-- Indexes for table `hoidong`
--
ALTER TABLE `hoidong`
  ADD PRIMARY KEY (`MaHoiDong`);

--
-- Indexes for table `khoa`
--
ALTER TABLE `khoa`
  ADD PRIMARY KEY (`MaKhoa`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `giangvien`
--
ALTER TABLE `giangvien`
  MODIFY `MaGiangVien` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `giaotrinh`
--
ALTER TABLE `giaotrinh`
  MODIFY `MaGiaoTrinh` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `hoidong`
--
ALTER TABLE `hoidong`
  MODIFY `MaHoiDong` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `khoa`
--
ALTER TABLE `khoa`
  MODIFY `MaKhoa` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `giangvien`
--
ALTER TABLE `giangvien`
  ADD CONSTRAINT `giangvien_mahoidong_foreign` FOREIGN KEY (`MaHoiDong`) REFERENCES `hoidong` (`MaHoiDong`),
  ADD CONSTRAINT `giangvien_makhoa_foreign` FOREIGN KEY (`MaKhoa`) REFERENCES `khoa` (`MaKhoa`);

--
-- Constraints for table `giaotrinh`
--
ALTER TABLE `giaotrinh`
  ADD CONSTRAINT `giaotrinh_magiangvien_foreign` FOREIGN KEY (`MaGiangVien`) REFERENCES `giangvien` (`MaGiangVien`),
  ADD CONSTRAINT `giaotrinh_mahoidong_foreign` FOREIGN KEY (`MaHoiDong`) REFERENCES `hoidong` (`MaHoiDong`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
