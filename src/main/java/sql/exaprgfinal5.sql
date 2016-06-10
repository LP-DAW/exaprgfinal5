
-- Base de datos: `exaprgfinal5`

CREATE TABLE IF NOT EXISTS `curso` (
  `id` char(4) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `curso` (`id`, `nombre`) VALUES
('c1', 'curso1');

--
-- Estructura de tabla para la tabla `examen`
--

CREATE TABLE IF NOT EXISTS `examen` (
  `id` char(4) NOT NULL,
  `nombre` varchar(50) NOT NULL,
`idcurso` char(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idcurso` (`idcurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `examen`
--
ALTER TABLE `examen`
  ADD CONSTRAINT `examen_ibfk_1` FOREIGN KEY (`idcurso`) 
  REFERENCES `curso` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;


--
-- Volcado de datos para la tabla `examen`
--

INSERT INTO `examen` (`id`, `nombre`,  `idcurso`) VALUES
('e1', 'Examen1', 'c1');




