-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-06-2024 a las 21:59:43
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `recoveruser`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `databasechangelog`
--

CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `databasechangelog`
--

INSERT INTO `databasechangelog` (`ID`, `AUTHOR`, `FILENAME`, `DATEEXECUTED`, `ORDEREXECUTED`, `EXECTYPE`, `MD5SUM`, `DESCRIPTION`, `COMMENTS`, `TAG`, `LIQUIBASE`, `CONTEXTS`, `LABELS`, `DEPLOYMENT_ID`) VALUES
('20181024130500-1', 'olehs', 'config/liquibase/changelog/202300808202358_alter_Entity_Employee.xml', '2023-08-08 23:15:55', 1, 'EXECUTED', '8:e0e2ebf99bd87ce53a33c61f926b8a17', 'addColumn tableName=employee', '', NULL, '4.17.2', NULL, NULL, '1529355481'),
('20230829224900', 'olehs', 'config/liquibase/changelog/20230829224900_alter_entity_Employee.xml', '2023-08-30 21:09:08', 2, 'EXECUTED', '8:60171c629382046f6c31704abbe872ae', 'addColumn tableName=employee', '', NULL, '4.17.2', NULL, NULL, '3422548594'),
('20230830222000', 'olehs', 'config/liquibase/changelog/20230830222000_alter_entity_Employee.xml', '2023-08-30 21:23:28', 3, 'EXECUTED', '8:41c7b8e8cef25d9468dc467b0dbcb5db', 'modifyDataType columnName=active, tableName=employee', '', NULL, '4.17.2', NULL, NULL, '3423408073'),
('20230903124300', 'olehs', 'config/liquibase/changelog/20230903124300_alter_entity_Employee.xml', '2023-09-03 12:49:07', 4, 'EXECUTED', '8:6d4b634f9319a8754096712cb6857804', 'addColumn tableName=employee', '', NULL, '4.17.2', NULL, NULL, '3738147310'),
('20230903130000', 'olehs', 'config/liquibase/changelog/20230903130000_alter_entity_Employee.xml', '2023-09-03 13:04:13', 5, 'EXECUTED', '8:29637b737e67aec6156a13206c7a7945', 'renameColumn newColumnName=language, oldColumnName=lenguage, tableName=employee', '', NULL, '4.17.2', NULL, NULL, '3739053690'),
('20240526163000', 'olehs', 'config/liquibase/changelog/20240526163000_alter_entity_User.xml', '2024-05-26 16:33:30', 6, 'EXECUTED', '8:f55fae94a5f354fb3484800591c73536', 'addColumn tableName=user', '', NULL, '4.17.2', NULL, NULL, '6734010473'),
('20240605233600', 'olehs', 'config/liquibase/changelog/20240605233600_alter_entity_User.xml', '2024-06-05 23:40:14', 7, 'EXECUTED', '8:2f805d738625770a04e88a5336205382', 'addColumn tableName=user; addColumn tableName=user', '', NULL, '4.17.2', NULL, NULL, '7623614823'),
('change-isSuscribed-type', 'oleh', 'config/liquibase/changelog/20240605234300_alter_entity_User.xml', '2024-06-05 23:45:50', 8, 'EXECUTED', '8:92fd2c82539837d8d429d02ea7703ace', 'modifyDataType columnName=isSuscribed, tableName=user', '', NULL, '4.17.2', NULL, NULL, '7623949986');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `databasechangeloglock`
--

CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `databasechangeloglock`
--

INSERT INTO `databasechangeloglock` (`ID`, `LOCKED`, `LOCKGRANTED`, `LOCKEDBY`) VALUES
(1, b'0', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plan`
--

CREATE TABLE `plan` (
  `id` int(11) NOT NULL,
  `content` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `plan`
--

INSERT INTO `plan` (`id`, `content`) VALUES
(1, '{\"martes\":[{\"time\":\"10:00 - 10:10\",\"activity\":\"Calentamiento\"},{\"time\":\"10:10 - 10:30\",\"activity\":\"Técnica de Golpes\"},{\"time\":\"10:30 - 10:50\",\"activity\":\"Movilidad en la Cancha\"},{\"time\":\"10:50 - 11:00\",\"activity\":\"Estiramientos y Vuelta a la Calma\"}],\"jueves\":[{\"time\":\"10:00 - 10:10\",\"activity\":\"Calentamiento\"},{\"time\":\"10:10 - 10:30\",\"activity\":\"Servicio\"},{\"time\":\"10:30 - 10:50\",\"activity\":\"Juego en la Red\"},{\"time\":\"10:50 - 11:00\",\"activity\":\"Estiramientos y Vuelta a la Calma\"}],\"descripcion\":[{\"title\":\"Calentamiento\",\"description\":\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"},{\"title\":\"Técnica de Golpes\",\"description\":\"Mejorar los golpes de derecha y revés. Practicar golpes con un compañero, enfocándose en mantener la pelota en juego, la precisión y el control de la pelota.\"},{\"title\":\"Movilidad en la Cancha\",\"description\":\"Mejorar la movilidad y el desplazamiento en la cancha. Realizar ejercicios de desplazamiento lateral y ejercicios de \\\"ataque y defensa\\\" para mejorar la agilidad y la capacidad de cobertura de la cancha.\"},{\"title\":\"Servicio\",\"description\":\"Mejorar la técnica y precisión del servicio. Practicar el lanzamiento y la técnica del servicio, enfocándose en la consistencia y precisión, dirigiendo el servicio a diferentes áreas del cuadro de saque.\"},{\"title\":\"Juego en la Red\",\"description\":\"Mejorar el juego en la red y las voleas. Practicar voleas y aproximaciones a la red, realizar ejercicios de \\\"ataque y defensa\\\" y partidos cortos enfocados en el juego de la red.\"},{\"title\":\"Estiramientos y Vuelta a la Calma\",\"description\":\"Relajar los músculos después del ejercicio y evitar lesiones. Realizar estiramientos de los principales grupos musculares utilizados durante la sesión.\"}]}');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservation`
--

CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `is_created` int(11) DEFAULT NULL,
  `is_paid` int(11) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reservation`
--

INSERT INTO `reservation` (`id`, `creation_date`, `is_created`, `is_paid`, `user_email`, `end_date`, `start_date`) VALUES
(5, '2024-06-03 12:12:44.000000', 1, 0, 'test2@admin.com', '2024-06-04 10:00:00.000000', '2024-06-04 09:00:00.000000'),
(6, '2024-06-03 12:13:46.000000', 1, 0, 'test2@admin.com', '2024-06-06 09:00:00.000000', '2024-06-06 08:00:00.000000'),
(7, '2024-06-03 12:24:40.000000', 1, 0, 'oleh@admin.com', '2024-06-08 08:00:00.000000', '2024-06-08 07:00:00.000000'),
(8, '2024-06-03 12:35:53.000000', 1, 0, 'oleh2@admin.com', '2024-06-05 09:00:00.000000', '2024-06-05 08:00:00.000000'),
(9, '2024-06-03 12:44:17.000000', 1, 0, 'test2@admin.com', '2024-06-07 15:00:00.000000', '2024-06-07 14:00:00.000000'),
(10, '2024-06-03 12:45:00.000000', 1, 0, 'test2@admin.com', '2024-06-07 16:00:00.000000', '2024-06-07 15:00:00.000000'),
(11, '2024-06-03 12:52:28.000000', 1, 0, 'test2@admin.com', '2024-06-10 09:00:00.000000', '2024-06-10 08:00:00.000000'),
(12, '2024-06-03 13:04:15.000000', 1, 0, 'test2@admin.com', '2024-06-05 14:00:00.000000', '2024-06-05 13:00:00.000000'),
(13, '2024-06-03 13:04:24.000000', 1, 0, 'test2@admin.com', '2024-06-05 15:00:00.000000', '2024-06-05 14:00:00.000000'),
(23, '2024-06-03 21:16:50.000000', 1, 0, 'test2@admin.com', '2024-06-04 17:00:00.000000', '2024-06-04 16:00:00.000000'),
(24, '2024-06-03 21:21:08.000000', 1, 0, 'test2@admin.com', '2024-06-06 13:00:00.000000', '2024-06-06 12:00:00.000000'),
(25, '2024-06-03 22:05:02.000000', 1, 0, 'test2@admin.com', '2024-06-08 12:00:00.000000', '2024-06-08 11:00:00.000000'),
(26, '2024-06-04 19:33:55.000000', 1, 0, 'test2@admin.com', '2024-06-10 12:00:00.000000', '2024-06-10 11:00:00.000000'),
(28, '2024-06-08 09:44:12.000000', 1, 0, 'cuc@gmail.com', '2024-06-12 13:00:00.000000', '2024-06-12 12:00:00.000000'),
(29, '2024-06-08 09:46:56.000000', 1, 0, 'cuc@gmail.com', '2024-06-13 11:00:00.000000', '2024-06-13 10:00:00.000000'),
(30, '2024-06-08 09:48:40.000000', 1, 0, 'cuc@gmail.com', '2024-06-15 11:00:00.000000', '2024-06-15 10:00:00.000000'),
(31, '2024-06-08 10:01:53.000000', 1, 0, 'cuc@gmail.com', '2024-06-16 10:00:00.000000', '2024-06-16 09:00:00.000000'),
(32, '2024-06-08 10:03:30.000000', 1, 0, 'cuc@gmail.com', '2024-06-16 15:00:00.000000', '2024-06-16 14:00:00.000000'),
(33, '2024-06-08 10:18:52.000000', 1, 0, 'cuc@gmail.com', '2024-06-18 10:00:00.000000', '2024-06-18 09:00:00.000000'),
(34, '2024-06-10 20:03:05.000000', 1, 0, 'oleh.s.199@gmail.com', '2024-06-20 11:00:00.000000', '2024-06-20 10:00:00.000000'),
(36, '2024-06-11 20:02:11.000000', 1, 0, '1997@gmail.com', '2024-06-22 13:00:00.000000', '2024-06-22 12:00:00.000000'),
(37, '2024-06-16 11:39:46.000000', 1, 0, '1997@gmail.com', '2024-06-23 10:00:00.000000', '2024-06-23 09:00:00.000000'),
(39, '2024-06-17 18:03:24.000000', 1, 0, '1997@gmail.com', '2024-06-17 17:00:00.000000', '2024-06-17 16:00:00.000000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `nif` varchar(255) DEFAULT NULL,
  `personal_phone` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `is_suscribed` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `active`, `country`, `creation_date`, `email`, `language`, `nif`, `personal_phone`, `password`, `role`, `username`, `full_name`, `photo`, `is_suscribed`) VALUES
(23, 0, 'test', '2024-05-24 17:12:21.000000', 'test6@gmail.com', 'test', 'TEST', '664487248', '$2a$10$oDJGN54PwHvkX1aPG0aCneG6sl.nDqGHI9ZFoU1xVcwEjQ4WEw1ni', 'USER', 'test6', 'TESTS', NULL, 0),
(27, 1, 'España', '2024-06-16 12:51:33.000000', 'junaaa@gmail.com', 'es', 'X87554355', '645388826', '$2a$10$skqDZshr2UxcS.xkg9UB/.T1/p6cjIFHVnv6I3ErubAKws8clW1mG', 'USER', 'junaaa', 'Pepito Fulanito', NULL, 0),
(28, 0, 'España', NULL, 'oleh.s@gmail.com', 'Spanish', 'X8209873T', '645388826', '$2a$10$uJr.3sWPWg9dQMjJNp7X4uAgujQNh3JzT8qX8glGGtiGbtJc.EpOe', 'USER', NULL, NULL, NULL, 0),
(29, 1, 'test', '2024-05-31 16:55:47.000000', 'test@gmail.com', 'PT', '3EDD344VGF', '645382875', '$2a$10$tuzhlj/.Ztu1KAuonLhFW.gwcV.QTo5d6jw.UFVY.Qw.fOBb5gCwS', 'USER', 'test', NULL, NULL, 0),
(30, 1, 'test3', '2024-05-31 16:58:47.000000', 'test3@gmail.com', 'spanish', 'X9I76473XX', '645383976', '$2a$10$od0MayEH/IApsp3qjwjyQellMGiPY6d2epIF6LTvH3VxJK.A53Qlm', 'USER', 'test3', 'Test 3', NULL, 0),
(33, 1, 'España', '2024-06-01 15:42:40.000000', 'oleh@gmail.com', 'PT', 'X8209873T', '645388826', '$2a$10$8X5zEIfIM87fP/uxgiHwkOQx3mQHwbxfiIMDpxpd6rGVPwGVlGsLW', 'USER', 'oleh2', 'Oleh Sobolevskyy', NULL, 0),
(34, 1, 'Españitaaaaaaaaaaaa', '2024-06-01 15:44:57.000000', 'oleh44@gmail.com', 'gsr', 'X8209873T', '645388826', '$2a$10$8X5zEIfIM87fP/uxgiHwkOQx3mQHwbxfiIMDpxpd6rGVPwGVlGsLW', 'USER', 'oleh44', 'Oleh Sobolevskyy', NULL, 0),
(35, 1, 'test33', '2024-06-01 15:55:56.000000', 'admin@admin.com', 'gsr', '3EDD344VGF', '645388826', '$2a$10$6pdWor5EK98jkBcwZCaNzeadPH4cfZLaRl10TsvxAeMpj/aD3I74e', 'ADMIN', 'admin', 'TEST ADMIN', NULL, 1),
(37, 1, 'cuc', '2024-06-05 22:01:56.000000', 'cuccu@gmail.com', 'es', 'X9I76473B', '645388826', '$2a$10$8X5zEIfIM87fP/uxgiHwkOQx3mQHwbxfiIMDpxpd6rGVPwGVlGsLW', 'USER', 'cuc', 'cucucu', NULL, 1),
(38, 1, 'españa', '2024-06-08 12:28:45.000000', 'olehtest@gmail.com', 'español', 'X982747N', '645388826', '$2a$10$ctYWgQskjRD8XRDvhGzNGOxfOPAc7luwwtYYkiyDnaqugNcZBFm5C', 'USER', 'olehtest', 'Oleh test', NULL, 0),
(39, 1, 'Espana', '2024-06-10 18:10:57.000000', 'test2@gmail.com', 'es', 'X8209873T', '645388826', '$2a$10$xJEbmIniNN9o3eEnCGjwuO4c8UdP6rkYMSc1s1VZN.C4R1/wxN/Wa', 'USER', 'test2', 'test user back', NULL, 0),
(40, 1, 'Espana', '2024-06-10 18:52:02.000000', 'admin3@gmail.com', 'PT', 'X8209873T', '+34645388826', '$2a$10$fVoAwE51TzKHES.9KZh3q.ZYkaUcbhMTNBBvePEbO34xwdq9QKTu.', 'ADMIN', 'admin3', 'admin 3', NULL, 0),
(41, 1, 'España', '2024-06-10 19:22:19.000000', '1997@gmail.com', 'es', 'X8209873T', '6453888266', '$2a$10$MixrbPhRRJhTHbC38V/E8uFupwJjug1ej4425z7etAn3Qu35U88RW', 'USER', '1997', 'Oleh Sobolevskyy 22', NULL, 1),
(42, 1, 'España', '2024-06-10 19:37:08.000000', 'oleh.s.1997@gmail.com', 'PT', 'X820987', '+34645388826', '$2a$10$UtXjOOHd7mITgTXb7h3ihuL78vMBfBBDQ25k4KUHni00PoTrpOH/K', 'ADMIN', 'oleh.s.1997', 'Oleh Sobolevskyy', NULL, 1),
(43, 1, 'España', '2024-06-13 19:40:11.000000', 'perez@gmail.com', 'Español', 'X8673857B', '666666666', '$2a$10$6pdWor5EK98jkBcwZCaNzeadPH4cfZLaRl10TsvxAeMpj/aD3I74e', 'USER', 'perez', 'Paco Perez', NULL, 0),
(51, 1, 'España', '2024-06-13 20:02:49.000000', 'admin5@gmail.com', 'PT', 'X8209873T', '645388826', '$2a$10$dV7hgSnMhM6/ThWQ.vAO7OX9Yr.P9nIeoKkq8u/2gkdUom8jmEMJu', 'ADMIN', 'admin5', 'Oleh Sobolevskyy', NULL, 0),
(53, 1, 'España', '2024-06-13 20:10:59.000000', 'oleh.s.1997@gmail.com', 'es', 'X8209873T', '645388826', '$2a$10$9GVp/KArv1I/6eOg6AlDAuNW/d.SYWO8kBKrsu/lysFGJ62PqkF4W', 'USER', 'oleh.s.1997', 'Oleh Sobolevskyy', NULL, 0),
(55, 1, 'España', '2024-06-16 12:33:20.000000', 'oleh.s.1997@gmail.com', 'PT', 'X8209873T', '645388826', '$2a$10$BxMu71FPxoKWSe8rNYphROl7/PU0IGIQguZQ1Adyha/J89TIerGwe', 'USER', 'oleh.s.1997', 'Oleh Sobolevskyy', NULL, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `databasechangeloglock`
--
ALTER TABLE `databasechangeloglock`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `plan`
--
ALTER TABLE `plan`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `plan`
--
ALTER TABLE `plan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
