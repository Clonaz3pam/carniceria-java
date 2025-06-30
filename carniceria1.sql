-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 30-06-2025 a las 02:50:51
-- Versión del servidor: 9.1.0
-- Versión de PHP: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `carniceria1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

DROP TABLE IF EXISTS `compra`;
CREATE TABLE IF NOT EXISTS `compra` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FECHA` datetime DEFAULT NULL,
  `HORA` time(3) DEFAULT NULL,
  `USUARIO_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_COMPRA_USUARIO_ID` (`USUARIO_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`ID`, `FECHA`, `HORA`, `USUARIO_ID`) VALUES
(1, '2025-06-21 20:26:34', '20:26:34.363', 2),
(2, '2025-06-21 20:27:59', '20:27:58.582', 2),
(3, '2025-06-21 20:31:50', '20:31:49.820', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecompra`
--

DROP TABLE IF EXISTS `detallecompra`;
CREATE TABLE IF NOT EXISTS `detallecompra` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CANTIDAD` double DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `HORA` time(3) DEFAULT NULL,
  `SUBTOTAL` double DEFAULT NULL,
  `COMPRA_ID` int DEFAULT NULL,
  `PRODUCTO_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_DETALLECOMPRA_PRODUCTO_ID` (`PRODUCTO_ID`),
  KEY `FK_DETALLECOMPRA_COMPRA_ID` (`COMPRA_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

--
-- Volcado de datos para la tabla `detallecompra`
--

INSERT INTO `detallecompra` (`ID`, `CANTIDAD`, `FECHA`, `HORA`, `SUBTOTAL`, `COMPRA_ID`, `PRODUCTO_ID`) VALUES
(1, 4, '2025-06-21 20:26:34', '20:26:34.367', 6400, 1, 4),
(2, 7.8, '2025-06-21 20:27:59', '20:27:58.588', 12480, 2, 4),
(3, 5.6, '2025-06-21 20:27:59', '20:27:58.585', 840, 2, 1),
(4, 44, '2025-06-21 20:31:50', '20:31:49.826', 70400, 3, 4),
(5, 12, '2025-06-21 20:31:50', '20:31:49.823', 8400, 3, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `OBSERVACION` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `PRECIO` double DEFAULT NULL,
  `STOCK` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`ID`, `DESCRIPCION`, `NOMBRE`, `OBSERVACION`, `PRECIO`, `STOCK`) VALUES
(1, 'Milanesas de pollo echas a partir de la pechuga del pollo fileteada, luego rebozada con pan rallado.', 'Milanesas de pollo', NULL, 150, 200),
(2, 'Chorizos de puro cerdo.', 'Chorizos cerdo', NULL, 850, 1000),
(5, 'Hamburguesas echas a partir de carne vacuna', 'Hamburguesas de carne', NULL, 700, 700),
(4, 'Milanesas de carne vacuna', 'Milanesas de carne', NULL, 1600, 55);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `CONTRASENIA` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `NOMBREUSUARIO` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `TIPO` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID`, `CONTRASENIA`, `NOMBREUSUARIO`, `TIPO`) VALUES
(1, '12345', 'duenio', 'duenio'),
(3, 'cliente', 'cliente3', 'cliente');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
