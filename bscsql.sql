-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bsc
-- ------------------------------------------------------
-- Server version	5.7.42-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bsc_inventario_item`
--

DROP TABLE IF EXISTS `bsc_inventario_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_inventario_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(255) DEFAULT NULL,
  `bsc_inventario_unidad_id` int(11) NOT NULL,
  `bsc_plan_de_cuentas_id` int(11) NOT NULL,
  `bsc_proveedor_id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_registro` date NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `observacion` varchar(255) DEFAULT NULL,
  `org_persona_id_registrado_por` int(11) NOT NULL,
  `precio_con_impuesto` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_inventario_item`
--

LOCK TABLES `bsc_inventario_item` WRITE;
/*!40000 ALTER TABLE `bsc_inventario_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_inventario_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_inventario_unidad`
--

DROP TABLE IF EXISTS `bsc_inventario_unidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_inventario_unidad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(5) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_inventario_unidad`
--

LOCK TABLES `bsc_inventario_unidad` WRITE;
/*!40000 ALTER TABLE `bsc_inventario_unidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_inventario_unidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_kapi`
--

DROP TABLE IF EXISTS `bsc_kapi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_kapi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(255) DEFAULT NULL,
  `bscobjetivoid` int(11) NOT NULL,
  `bscproyectoid` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecharegistro` datetime(6) NOT NULL,
  `formula` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `orden` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_kapi`
--

LOCK TABLES `bsc_kapi` WRITE;
/*!40000 ALTER TABLE `bsc_kapi` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_kapi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_lugar`
--

DROP TABLE IF EXISTS `bsc_lugar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_lugar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(255) DEFAULT NULL,
  `bsc_lugar_id_padre` int(11) DEFAULT NULL,
  `edificio` varchar(255) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `lugar` varchar(255) DEFAULT NULL,
  `nivel` int(11) DEFAULT NULL,
  `piso` int(11) DEFAULT NULL,
  `subarea` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_lugar`
--

LOCK TABLES `bsc_lugar` WRITE;
/*!40000 ALTER TABLE `bsc_lugar` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_objetivo`
--

DROP TABLE IF EXISTS `bsc_objetivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_objetivo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(255) NOT NULL,
  `bsc_tema_id` int(11) DEFAULT NULL,
  `bsc_tipo_objetivo_id` int(11) NOT NULL,
  `codigo` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_registro` datetime(6) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `orden` int(11) DEFAULT NULL,
  `org_departamento_id_responsable` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_objetivo`
--

LOCK TABLES `bsc_objetivo` WRITE;
/*!40000 ALTER TABLE `bsc_objetivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_objetivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_perspectiva`
--

DROP TABLE IF EXISTS `bsc_perspectiva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_perspectiva` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_registro` datetime(6) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_perspectiva`
--

LOCK TABLES `bsc_perspectiva` WRITE;
/*!40000 ALTER TABLE `bsc_perspectiva` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_perspectiva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_proveedor`
--

DROP TABLE IF EXISTS `bsc_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_proveedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cargo` varchar(50) DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `codigo_postal` varchar(10) DEFAULT NULL,
  `contacto` varchar(50) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `estado_provincia` varchar(100) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  `observaciones` longtext,
  `organizacion` varchar(50) NOT NULL,
  `pagina_web` varchar(100) DEFAULT NULL,
  `pais_region` varchar(50) DEFAULT NULL,
  `telefono_movil` varchar(25) DEFAULT NULL,
  `telefono_personal` varchar(25) DEFAULT NULL,
  `telefono_trabajo` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_proveedor`
--

LOCK TABLES `bsc_proveedor` WRITE;
/*!40000 ALTER TABLE `bsc_proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_proyecto`
--

DROP TABLE IF EXISTS `bsc_proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_proyecto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(5) DEFAULT NULL,
  `bsc_proceso_id` int(11) DEFAULT NULL,
  `bsc_tipo_proyecto_id` int(11) DEFAULT NULL,
  `codigo` varchar(5) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `incluir` bit(1) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `objetivo_general` varchar(500) DEFAULT NULL,
  `observaciones` varchar(500) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  `org_departamento_id_responsable` int(11) DEFAULT NULL,
  `org_persona_id_responsable` int(11) DEFAULT NULL,
  `presupuesto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_proyecto`
--

LOCK TABLES `bsc_proyecto` WRITE;
/*!40000 ALTER TABLE `bsc_proyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_proyecto_actividad`
--

DROP TABLE IF EXISTS `bsc_proyecto_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_proyecto_actividad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bsc_lugar_id` int(11) DEFAULT NULL,
  `bsc_proyecto_actividad_tipoactividad_id` int(11) DEFAULT NULL,
  `bsc_proyecto_objetivo_especifico_id` int(11) DEFAULT NULL,
  `col_pdca_id` int(11) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  `fecha_termino` date DEFAULT NULL,
  `incluir_en_pao` bit(1) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `observacion_control_gestion` varchar(255) DEFAULT NULL,
  `org_ambito_id` int(11) DEFAULT NULL,
  `org_centro_costo_id` int(11) DEFAULT NULL,
  `org_persona_id_registrador_por` int(11) DEFAULT NULL,
  `org_persona_id_responsable` int(11) DEFAULT NULL,
  `porcentaje_completado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_proyecto_actividad`
--

LOCK TABLES `bsc_proyecto_actividad` WRITE;
/*!40000 ALTER TABLE `bsc_proyecto_actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_proyecto_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_proyecto_actividad_tipoactividad`
--

DROP TABLE IF EXISTS `bsc_proyecto_actividad_tipoactividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_proyecto_actividad_tipoactividad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_registro` varchar(255) DEFAULT NULL,
  `nivel` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_proyecto_actividad_tipoactividad`
--

LOCK TABLES `bsc_proyecto_actividad_tipoactividad` WRITE;
/*!40000 ALTER TABLE `bsc_proyecto_actividad_tipoactividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_proyecto_actividad_tipoactividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_proyecto_pedido`
--

DROP TABLE IF EXISTS `bsc_proyecto_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_proyecto_pedido` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_cierre` date DEFAULT NULL,
  `fecha_proceso` date DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_proyecto_pedido`
--

LOCK TABLES `bsc_proyecto_pedido` WRITE;
/*!40000 ALTER TABLE `bsc_proyecto_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_proyecto_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_r_proyecto_persona`
--

DROP TABLE IF EXISTS `bsc_r_proyecto_persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_r_proyecto_persona` (
  `bsc_proyecto_id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_registro` date NOT NULL,
  `org_persona_id` int(11) NOT NULL,
  PRIMARY KEY (`bsc_proyecto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_r_proyecto_persona`
--

LOCK TABLES `bsc_r_proyecto_persona` WRITE;
/*!40000 ALTER TABLE `bsc_r_proyecto_persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_r_proyecto_persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_situacion_departamento_idea_proyecto`
--

DROP TABLE IF EXISTS `bsc_situacion_departamento_idea_proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_situacion_departamento_idea_proyecto` (
  `id_bsc_situacion_departamento_idea_proyecto` int(11) NOT NULL AUTO_INCREMENT,
  `bsc_idea_id` int(11) DEFAULT NULL,
  `bsc_proyecto_id` int(11) DEFAULT NULL,
  `bsc_r_situacion_departamento_id` int(11) DEFAULT NULL,
  `cantidad_votos` int(11) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  `incluir` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_bsc_situacion_departamento_idea_proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_situacion_departamento_idea_proyecto`
--

LOCK TABLES `bsc_situacion_departamento_idea_proyecto` WRITE;
/*!40000 ALTER TABLE `bsc_situacion_departamento_idea_proyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_situacion_departamento_idea_proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_tema`
--

DROP TABLE IF EXISTS `bsc_tema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_tema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(255) DEFAULT NULL,
  `bsc_perspectiva_id` int(11) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_tema`
--

LOCK TABLES `bsc_tema` WRITE;
/*!40000 ALTER TABLE `bsc_tema` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_tema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_tipo_documento`
--

DROP TABLE IF EXISTS `bsc_tipo_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_tipo_documento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `alias` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `impuesto` float NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `orden` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_tipo_documento`
--

LOCK TABLES `bsc_tipo_documento` WRITE;
/*!40000 ALTER TABLE `bsc_tipo_documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_tipo_documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bsc_tipo_objetivo_id_padre`
--

DROP TABLE IF EXISTS `bsc_tipo_objetivo_id_padre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bsc_tipo_objetivo_id_padre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(255) DEFAULT NULL,
  `bsc_tipo_objetivo_id_padre` int(11) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_registro` datetime(6) NOT NULL,
  `nivel` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bsc_tipo_objetivo_id_padre`
--

LOCK TABLES `bsc_tipo_objetivo_id_padre` WRITE;
/*!40000 ALTER TABLE `bsc_tipo_objetivo_id_padre` DISABLE KEYS */;
/*!40000 ALTER TABLE `bsc_tipo_objetivo_id_padre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `est_modelo`
--

DROP TABLE IF EXISTS `est_modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `est_modelo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alias` varchar(255) DEFAULT NULL,
  `aplica_solo_a_departamentos` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_registro` datetime(6) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `orden` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `est_modelo`
--

LOCK TABLES `est_modelo` WRITE;
/*!40000 ALTER TABLE `est_modelo` DISABLE KEYS */;
/*!40000 ALTER TABLE `est_modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kpi_meta`
--

DROP TABLE IF EXISTS `kpi_meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpi_meta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bsc_kpi_id` int(11) DEFAULT NULL,
  `evaluacion` varchar(500) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `observacion` longtext,
  `periodo` varchar(255) DEFAULT NULL,
  `resultado` varchar(500) DEFAULT NULL,
  `x1` varchar(500) DEFAULT NULL,
  `x2` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi_meta`
--

LOCK TABLES `kpi_meta` WRITE;
/*!40000 ALTER TABLE `kpi_meta` DISABLE KEYS */;
/*!40000 ALTER TABLE `kpi_meta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-04 23:58:04
