-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-10-2023 a las 01:27:46
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bomberogrupo6`
--
CREATE DATABASE IF NOT EXISTS `bomberogrupo6` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bomberogrupo6`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bombero`
--

DROP TABLE IF EXISTS `bombero`;
CREATE TABLE `bombero` (
  `id_bombero` int(11) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `fecha_nac` date NOT NULL,
  `celular` varchar(15) NOT NULL,
  `cod_brigada` int(11) NOT NULL,
  `grupo_sanguineo` varchar(20) DEFAULT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bombero`
--

INSERT INTO `bombero` (`id_bombero`, `dni`, `nombre`, `apellido`, `fecha_nac`, `celular`, `cod_brigada`, `grupo_sanguineo`, `estado`) VALUES
(4, '1233425', 'Ramiro', 'Perez', '2023-03-23', '266425', 5, 'A+', 1),
(5, '30893000', 'Hernan', 'Viltez', '2023-10-11', '1138785218', 5, 'B+', 1),
(6, '33897222', 'juan', 'sequi', '2023-10-12', '2141132513', 6, 'AB+', 1),
(7, '23124123', 'fernando', 'eric', '2023-10-12', '1138785314', 6, 'B+', 1),
(8, '11222333', 'Camilo', 'Rodriguez', '2006-10-12', '113423242', 3, 'A+', 1),
(9, '33444555', 'Raul', 'Fernandez', '2003-10-16', '115556666', 3, 'B+', 1),
(10, '55666777', 'Tiago', 'Velazques', '1985-10-18', '117776666', 3, '0+', 1),
(11, '33888999', 'Yamil', 'Veliz', '1986-10-17', '115489623', 3, 'AB+', 1),
(12, '1223123', 'efwe', 'efwfe', '2023-10-14', '12312412', 3, 'B+', 1),
(13, '11343878', 'Leo', 'Torres', '1988-10-07', '1146567575', 8, 'B-', 1),
(14, '33424989', 'German', 'Rodriguez', '1978-10-14', '1154567544', 4, 'B-', 1),
(15, '22544656', 'Pablo', 'Montero', '1974-10-19', '1154509090', 4, '0-', 1),
(16, '22545963', 'Walter', 'Lopez', '1956-10-18', '115559292', 6, 'AB-', 1),
(17, '36898787', 'Fernando', 'Terranova', '1985-10-18', '114846969', 8, 'B-', 1),
(18, '34656777', 'Lautaro', 'Nievas', '1987-10-17', '114447777', 9, '0+', 1),
(19, '32454656', 'Cristian', 'Perez', '1975-10-17', '116663212', 2, 'AB+', 1),
(20, '34999555', 'Dario', 'Quinteros', '1977-10-20', '148559898', 2, 'AB-', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `brigada`
--

DROP TABLE IF EXISTS `brigada`;
CREATE TABLE `brigada` (
  `cod_brigada` int(11) NOT NULL,
  `nombre_br` varchar(100) NOT NULL,
  `especialidad` varchar(100) NOT NULL,
  `libre` tinyint(1) NOT NULL,
  `nro_cuartel` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `brigada`
--

INSERT INTO `brigada` (`cod_brigada`, `nombre_br`, `especialidad`, `libre`, `nro_cuartel`, `estado`) VALUES
(2, 'Gamma', 'Salvamento en derrumbes', 1, 3, 1),
(3, 'Bravo', 'Rescates en ámbito montaña', 0, 1, 1),
(4, 'SEI', 'Socorrer inundaciones', 1, 2, 1),
(5, 'Moron', 'Operativos de prevención', 1, 3, 1),
(6, 'Tango', 'Incendios en viviendas e industrias', 1, 6, 1),
(8, 'Delta', 'Incendios en viviendas e industrias', 0, 2, 1),
(9, 'Omega', 'Rescate de personas atrapadas en accidentes de tráfico', 0, 3, 1),
(10, 'OPS', 'Salvamento en derrumbes', 1, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuartel`
--

DROP TABLE IF EXISTS `cuartel`;
CREATE TABLE `cuartel` (
  `cod_cuartel` int(11) NOT NULL,
  `nombre_cuartel` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `coord_X` double NOT NULL,
  `coord_Y` double NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuartel`
--

INSERT INTO `cuartel` (`cod_cuartel`, `nombre_cuartel`, `direccion`, `coord_X`, `coord_Y`, `telefono`, `correo`, `estado`) VALUES
(1, 'Voluntarios Merlo', 'avenida1', 12, 12, '2323232', 'feqwf@fewf.com', 1),
(2, 'Santa Teresas', 'Rt. Los Pescadores', -33.29498919318194, -66.34584462106838, '2664525497', 'SantateresaSL@gmail.com', 1),
(3, 'El Colibri', 'AV. Presidente Peron', -33.29996967022411, -66.32757794978103, '2665294835', 'CuartelcolibriesSL@gmail.com', 1),
(6, 'Bomberos Voluntarios de Moron', 'Hipólito Yrigoyen Nº1460 esquina Colón', -34.659190517702676, -58.62781630752246, '4629-2222', 'www.bomberosmoron.org.ar', 1),
(7, 'Santa Teresas', 'Rt. Los Pescadores', -33.29498919318194, -66.34584462106838, '2664525497', 'SantateresaSL@gmail.com', 1),
(8, 'Yanqui', 'Gregoria Perez 1501', -31, -35, '115853232', 'yanqui@gmail.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `siniestro`
--

DROP TABLE IF EXISTS `siniestro`;
CREATE TABLE `siniestro` (
  `codigo` int(11) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `fecha_siniestro` date NOT NULL,
  `hora_siniestro` time NOT NULL,
  `coord_X` int(11) NOT NULL,
  `coord_Y` int(11) NOT NULL,
  `detalles` text NOT NULL,
  `fecha_resol` date DEFAULT NULL,
  `hora_resol` time DEFAULT NULL,
  `puntuacion` int(11) DEFAULT NULL,
  `cod_brigada` int(11) DEFAULT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `siniestro`
--

INSERT INTO `siniestro` (`codigo`, `tipo`, `fecha_siniestro`, `hora_siniestro`, `coord_X`, `coord_Y`, `detalles`, `fecha_resol`, `hora_resol`, `puntuacion`, `cod_brigada`, `estado`) VALUES
(18, 'Incendios en viviendas e industrias', '2023-10-25', '18:27:37', 32, 23, 'incendio en cas', '2023-10-11', '02:30:00', 4, 6, 0),
(19, 'Salvamento en derrumbes', '2023-10-25', '20:06:08', 23, 22, 'fefe', NULL, NULL, 0, 2, 1),
(21, 'Incendios en viviendas e industrias', '2023-10-26', '19:09:14', 54, 54, 'htrh', '2023-10-13', '02:15:00', 2, 3, 0),
(22, 'Rescates en ámbito montaña', '2023-10-26', '19:58:47', 21, 1, 'ccq', NULL, NULL, 0, 3, 1),
(23, 'Incendios en viviendas e industrias', '2023-10-26', '20:14:14', 23, 43, 'fewf', NULL, NULL, 0, NULL, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD PRIMARY KEY (`id_bombero`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `bombero_ibfk_1` (`cod_brigada`);

--
-- Indices de la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD PRIMARY KEY (`cod_brigada`),
  ADD KEY `brigada_ibfk_1` (`nro_cuartel`);

--
-- Indices de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  ADD PRIMARY KEY (`cod_cuartel`);

--
-- Indices de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `siniestro_ibfk_1` (`cod_brigada`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bombero`
--
ALTER TABLE `bombero`
  MODIFY `id_bombero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `brigada`
--
ALTER TABLE `brigada`
  MODIFY `cod_brigada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  MODIFY `cod_cuartel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD CONSTRAINT `bombero_ibfk_1` FOREIGN KEY (`cod_brigada`) REFERENCES `brigada` (`cod_brigada`);

--
-- Filtros para la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD CONSTRAINT `brigada_ibfk_1` FOREIGN KEY (`nro_cuartel`) REFERENCES `cuartel` (`cod_cuartel`);

--
-- Filtros para la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD CONSTRAINT `siniestro_ibfk_1` FOREIGN KEY (`cod_brigada`) REFERENCES `brigada` (`cod_brigada`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
