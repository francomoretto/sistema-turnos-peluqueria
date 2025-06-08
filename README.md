# Sistema de Gestión de Turnos - "Estilo Único - Peluquería y Estética"

## Descripción

Este proyecto consiste en el desarrollo de una aplicación de escritorio para la gestión integral de turnos en la peluquería ficticia "Estilo Único".  
Actualmente, el sistema funciona como un prototipo ejecutable desde consola, que permite gestionar clientes, turnos, servicios y estados.  
La versión futura incluirá una interfaz gráfica con Swing y persistencia en MySQL.

## Funcionalidades implementadas (TP3)

- Registro de clientes con datos personales.
- Asignación de turnos con selección de cliente, servicio, estado, fecha y hora.
- Consulta de todos los turnos registrados.
- Gestión interna de servicios y estados predefinidos (simulados).
- Menú interactivo desde consola.

## Tecnologías utilizadas

- Java 17
- Consola (ejecución por terminal)
- `ArrayList` para manejo de datos simulados
- (Próximamente: Swing, MySQL y JDBC)

## Instalación

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/francomoretto/sistema-turnos-peluqueria.git
   ```
2. Abrir el proyecto en IntelliJ IDEA (Community Edition).
3. Ejecutar la clase principal `SistemaTurnos.java` desde la carpeta `/src`.

## Estructura del Proyecto

- `SistemaTurnoJava/src` → Código fuente en Java.
- `/sql` → (Próximo TP) Scripts para crear la base de datos MySQL.
- `/docs` → Documentación técnica, diagramas y manuales.

## Estado del proyecto

- ✅ TP3: funcionalidades básicas implementadas en consola.
- 🔄 TP4: integración con base de datos MySQL, aplicación de patrón MVC y manejo completo de excepciones SQL.
- 🔒 Pendiente: autenticación de usuarios y validación avanzada.
