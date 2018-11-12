-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-11-2018 a las 05:50:26
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `app_desarrollo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulos`
--

CREATE TABLE `articulos` (
  `idarticulos` int(10) UNSIGNED NOT NULL,
  `idcategorias` int(10) UNSIGNED DEFAULT NULL,
  `nombre` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cod_articulo` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `precio_venta` double(8,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `estado` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `articulos`
--

INSERT INTO `articulos` (`idarticulos`, `idcategorias`, `nombre`, `cod_articulo`, `precio_venta`, `stock`, `estado`, `created_at`, `updated_at`) VALUES
(1, 1, 'cable azul ttt1', '9990', 6000.00, 2, 'Activo', NULL, NULL),
(2, 1, 'cable rojo 441', '6611', 5600.00, 2, 'Activo', NULL, NULL),
(10, 1, 'capo', '2579', 1500.00, 4, 'Activo', NULL, NULL),
(14, 2, 'Bateria', '8529', 8000.00, 50, 'Activo', NULL, NULL),
(15, 2, 'Bateria 12000 v', '8555', 80000.00, 20, 'Activo', NULL, NULL),
(16, 1, 'capo', '2579', 1500.00, 4, 'Activo', NULL, NULL),
(17, 2, 'Puerta Modelo 2228', '8547', 5200.00, 40, 'Activo', NULL, NULL),
(18, 2, 'asiento', '2588', 25.00, 50, 'Activo', NULL, NULL),
(19, 2, 'Bateria Fiat 2003', '2578', 2500.00, 36, 'Activo', NULL, NULL),
(20, 1, 'capo', '2579', 1500.00, 4, 'Activo', NULL, NULL),
(21, 1, 'bujia fiat siena', '8524', 80000.00, 10, 'Activo', NULL, NULL),
(22, 1, 'Bujia fiat 2008', '8527', 5000.00, 50, 'Activo', NULL, NULL),
(23, 1, 'Capo', '8599', 50000.00, 0, 'Activo', NULL, NULL),
(24, 1, 'CAPO FIAT 2003', '7000', 200000.00, 25, 'Activo', NULL, NULL),
(25, 1, 's', '2500', 1.00, 10, 'Activo', NULL, NULL),
(26, 1, 'fusible 11', '8122', 6000.00, 2, 'Activo', NULL, NULL),
(27, 2, 'Cuacho', '8520', 10000.00, 5, 'Activo', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `idcategorias` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`idcategorias`, `nombre`, `descripcion`, `created_at`, `updated_at`) VALUES
(1, 'Sistema Electrico Fiat', 'fusiblea fiat 1', NULL, NULL),
(2, 'motores Fiat', 'Motor para automoviles Fiat T11', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ingresos`
--

CREATE TABLE `detalle_ingresos` (
  `iddetalle_ingresos` int(10) UNSIGNED NOT NULL,
  `idingresos` int(10) UNSIGNED DEFAULT NULL,
  `idarticulos` int(10) UNSIGNED DEFAULT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_compra` double(8,2) NOT NULL,
  `precio_venta` double(8,2) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

CREATE TABLE `detalle_ventas` (
  `iddetalle_ventas` int(10) UNSIGNED NOT NULL,
  `idarticulos` int(10) UNSIGNED DEFAULT NULL,
  `idventas` int(10) UNSIGNED DEFAULT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_venta` double(8,2) NOT NULL,
  `descuento` double(8,2) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingresos`
--

CREATE TABLE `ingresos` (
  `idingresos` int(10) UNSIGNED NOT NULL,
  `idarticulos` int(10) UNSIGNED DEFAULT NULL,
  `tipo_comprobante` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `serie_comprobante` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nro_comprobante` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha_hora` date NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_compra` double(8,2) NOT NULL,
  `precio_venta` double(8,2) NOT NULL,
  `total_compra` double(8,2) NOT NULL,
  `estado` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(9, '2014_10_12_000000_create_users_table', 1),
(10, '2014_10_12_100000_create_password_resets_table', 1),
(11, '2018_10_06_182449_tabla_categorias', 1),
(12, '2018_10_06_182818_tabla_articulos', 1),
(13, '2018_10_13_155929_tabla_ingresos', 1),
(14, '2018_10_13_190001_tabla_detalle_ingresos', 1),
(15, '2018_10_14_171139_tabla_venta', 1),
(16, '2018_10_14_171358_tabla_detalle_venta', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cedula` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `name`, `cedula`, `email`, `email_verified_at`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'Pool Lopez', '20806613', 'alexpoolx@gmail.com', NULL, NULL, '2018-10-20 19:59:50', '2018-10-20 19:59:50'),
(2, 'alexander', '22333111', 'alexander-346@hotmail.com', NULL, NULL, NULL, NULL),
(3, 'merys del vaye', '8523973', 'merys13@hotmail.com', NULL, NULL, '2018-10-22 03:52:31', '2018-10-22 03:52:31'),
(4, 'andreina', '990011', 'andreina@hotmail.com', NULL, NULL, '2018-10-22 03:55:04', '2018-10-22 03:55:04'),
(5, 'jose abraham', '20999111', 'jose133@example.com', NULL, NULL, '2018-10-22 03:56:17', '2018-10-22 03:56:17'),
(6, 'cintia lopez', '11233456', 'cintia333@gmail.com', NULL, NULL, '2018-10-22 03:56:59', '2018-10-22 03:56:59'),
(7, 'aquiles gonzales', '20111333', 'aquilestt@example.com', NULL, NULL, '2018-10-22 03:57:35', '2018-10-22 03:57:35'),
(8, 'alva rodriguez', '10999888', 'alva@gmail.com', NULL, NULL, '2018-10-22 03:58:02', '2018-10-22 03:58:02'),
(9, 'juan tirado', '25444331', 'juan@example.com', NULL, NULL, '2018-10-22 04:06:54', '2018-10-22 04:06:54');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idventas` int(10) UNSIGNED NOT NULL,
  `idcliente` int(10) UNSIGNED DEFAULT NULL,
  `idarticulos` int(10) UNSIGNED DEFAULT NULL,
  `tipo_pago` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `serie_comprobante` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nro_comprobante` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha_hora` date NOT NULL,
  `cantidad` int(11) NOT NULL,
  `total_venta` double(8,2) NOT NULL,
  `estado` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idventas`, `idcliente`, `idarticulos`, `tipo_pago`, `serie_comprobante`, `nro_comprobante`, `fecha_hora`, `cantidad`, `total_venta`, `estado`, `created_at`, `updated_at`) VALUES
(1, 1, 1, 'debito', '66221', '44156', '2018-10-20', 2, 12000.00, 'Activo', NULL, NULL),
(3, 2, 1, 'debito', '52522', '55561', '2018-10-20', 2, 12000.00, 'Activo', NULL, NULL),
(4, 1, 1, 'credito', '12315', '12233', '2018-10-20', 3, 18000.00, 'Activo', NULL, NULL),
(5, 8, 1, 'credito', '43523', '55112', '2018-10-21', 2, 12000.00, 'Activo', NULL, NULL),
(6, 3, 2, 'debito', '31341', '22213', '2018-10-21', 1, 5600.00, 'Activo', NULL, NULL),
(7, 1, 2, 'debito', '44136', '55555', '2018-10-21', 1, 5600.00, 'Activo', NULL, NULL),
(8, 1, 2, 'credito', '31132', '11123', '2018-10-21', 2, 11200.00, 'Activo', NULL, NULL),
(9, 5, 2, 'debito', '55521', '31314', '2018-10-21', 4, 22400.00, 'Activo', NULL, NULL);

--
-- Disparadores `ventas`
--
DELIMITER $$
CREATE TRIGGER `tr_updStockVenta` AFTER INSERT ON `ventas` FOR EACH ROW BEGIN
        	UPDATE articulos SET stock = stock - NEW.cantidad
            WHERE articulos.idarticulos = NEW.idarticulos;
         END
$$
DELIMITER ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulos`
--
ALTER TABLE `articulos`
  ADD PRIMARY KEY (`idarticulos`),
  ADD KEY `articulos_idcategorias_foreign` (`idcategorias`);

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`idcategorias`),
  ADD UNIQUE KEY `categorias_nombre_unique` (`nombre`);

--
-- Indices de la tabla `detalle_ingresos`
--
ALTER TABLE `detalle_ingresos`
  ADD PRIMARY KEY (`iddetalle_ingresos`),
  ADD KEY `detalle_ingresos_idingresos_foreign` (`idingresos`),
  ADD KEY `detalle_ingresos_idarticulos_foreign` (`idarticulos`);

--
-- Indices de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD PRIMARY KEY (`iddetalle_ventas`),
  ADD KEY `detalle_ventas_idarticulos_foreign` (`idarticulos`),
  ADD KEY `detalle_ventas_idventas_foreign` (`idventas`);

--
-- Indices de la tabla `ingresos`
--
ALTER TABLE `ingresos`
  ADD PRIMARY KEY (`idingresos`),
  ADD KEY `ingresos_idarticulos_foreign` (`idarticulos`);

--
-- Indices de la tabla `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `password_resets`
--
ALTER TABLE `password_resets`
  ADD KEY `password_resets_email_index` (`email`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idventas`),
  ADD KEY `ventas_idcliente_foreign` (`idcliente`),
  ADD KEY `ventas_idarticulos_foreign` (`idarticulos`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulos`
--
ALTER TABLE `articulos`
  MODIFY `idarticulos` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `idcategorias` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `detalle_ingresos`
--
ALTER TABLE `detalle_ingresos`
  MODIFY `iddetalle_ingresos` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  MODIFY `iddetalle_ventas` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ingresos`
--
ALTER TABLE `ingresos`
  MODIFY `idingresos` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idventas` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `articulos`
--
ALTER TABLE `articulos`
  ADD CONSTRAINT `articulos_idcategorias_foreign` FOREIGN KEY (`idcategorias`) REFERENCES `categorias` (`idcategorias`);

--
-- Filtros para la tabla `detalle_ingresos`
--
ALTER TABLE `detalle_ingresos`
  ADD CONSTRAINT `detalle_ingresos_idarticulos_foreign` FOREIGN KEY (`idarticulos`) REFERENCES `articulos` (`idarticulos`),
  ADD CONSTRAINT `detalle_ingresos_idingresos_foreign` FOREIGN KEY (`idingresos`) REFERENCES `ingresos` (`idingresos`);

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `detalle_ventas_idarticulos_foreign` FOREIGN KEY (`idarticulos`) REFERENCES `articulos` (`idarticulos`),
  ADD CONSTRAINT `detalle_ventas_idventas_foreign` FOREIGN KEY (`idventas`) REFERENCES `ventas` (`idventas`);

--
-- Filtros para la tabla `ingresos`
--
ALTER TABLE `ingresos`
  ADD CONSTRAINT `ingresos_idarticulos_foreign` FOREIGN KEY (`idarticulos`) REFERENCES `articulos` (`idarticulos`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_idarticulos_foreign` FOREIGN KEY (`idarticulos`) REFERENCES `articulos` (`idarticulos`),
  ADD CONSTRAINT `ventas_idcliente_foreign` FOREIGN KEY (`idcliente`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
