# Sistema de Gestión de Turnos - "Estilo Único - Peluquería y Estética"

## Descripción

Este proyecto consiste en el desarrollo de una aplicación de escritorio para la gestión integral de turnos en la peluquería ficticia "Estilo Único".  
Permite registrar clientes, agendar, modificar y cancelar turnos, gestionar estados de cada cita (pendiente, confirmado, cancelado), y consultar la agenda diaria o semanal.

El sistema está desarrollado en Java (usando Swing para la interfaz gráfica) y utiliza MySQL como motor de base de datos relacional.

## Funcionalidades principales

- Registro, edición y baja de clientes.
- Asignación de turnos con selección de cliente, servicio, fecha y hora.
- Gestión del estado de cada turno (Pendiente, Confirmado, Cancelado) de forma normalizada.
- Modificación y cancelación de turnos existentes.
- Consulta de agenda por día y semana, con filtro por estado.
- Registro de observaciones y solicitudes especiales por turno.
- Generación de reportes básicos: cantidad de turnos por servicio, ingresos estimados, clientes frecuentes, próximos turnos.
- Seguridad de acceso mediante usuarios (en desarrollo).

## Tecnologías utilizadas

- Java 17
- Swing (GUI)
- MySQL
- JDBC (Java Database Connectivity)
- (Opcional: MySQL Workbench para administración de la base)

## Instalación

1. Clonar el repositorio:
   git clone https://github.com/francomoretto/sistema-turnos-peluqueria.git
2. Importar el proyecto en tu IDE de preferencia (IntelliJ IDEA, Eclipse, NetBeans, etc.).
3. Crear la base de datos ejecutando el script `/sql/sistema_turnos.sql` en MySQL.
4. Configurar la conexión a la base de datos (en el archivo `config.properties` o directamente en el código, según tu implementación).
5. Ejecutar el proyecto desde el IDE.

## Estructura del Proyecto

- `/src` → Código fuente Java.
- `/sql` → Scripts para creación y carga de la base de datos.
- `/docs` → Documentación técnica, diagramas, manual de usuario y ejemplos de consultas SQL.

## Estado del proyecto

- Fase avanzada: módulo de gestión de clientes, servicios y turnos completo.
- Funcionalidad de gestión de estado de turnos implementada y consultas avanzadas en desarrollo.
- Pendiente: módulo de autenticación y mejoras de interfaz.

