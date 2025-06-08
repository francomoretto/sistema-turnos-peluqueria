use sistema_turnos;

-- 3) Crear la tabla Cliente
CREATE TABLE Cliente (
  idCliente INT AUTO_INCREMENT PRIMARY KEY,
  nombre    VARCHAR(100) NOT NULL,
  telefono  VARCHAR(20)   NOT NULL,
  email     VARCHAR(100)
);

-- 4) Crear la tabla Servicio
CREATE TABLE Servicio (
  idServicio INT AUTO_INCREMENT PRIMARY KEY,
  nombre     VARCHAR(100) NOT NULL,
  duracion   INT           NOT NULL,  -- duración en minutos
  precio     DECIMAL(10,2) NOT NULL
);

-- 5) Crear la tabla EstadoTurno
CREATE TABLE EstadoTurno (
  idEstado INT AUTO_INCREMENT PRIMARY KEY,
  nombre   VARCHAR(50) NOT NULL
);

-- 6) Insertar valores iniciales en EstadoTurno
INSERT INTO EstadoTurno (nombre)
VALUES ('Pendiente'), ('Confirmado'), ('Cancelado');

-- 7) Crear la tabla Turno
CREATE TABLE Turno (
  idTurno      INT AUTO_INCREMENT PRIMARY KEY,
  fecha        DATE            NOT NULL,
  hora         TIME            NOT NULL,
  observaciones VARCHAR(255),
  idCliente    INT             NOT NULL,
  idServicio   INT             NOT NULL,
  idEstado     INT             NOT NULL,
  FOREIGN KEY (idCliente)  REFERENCES Cliente(idCliente),
  FOREIGN KEY (idServicio) REFERENCES Servicio(idServicio),
  FOREIGN KEY (idEstado)   REFERENCES EstadoTurno(idEstado)
);

-- 8) Insertar algunos registros de ejemplo
INSERT INTO Cliente (nombre, telefono, email)
VALUES 
  ('Laura Torres', '3511234567', 'laura@gmail.com'),
  ('Carlos Pérez', '3517654321', 'carlos@hotmail.com');

INSERT INTO Servicio (nombre, duracion, precio)
VALUES 
  ('Corte de cabello', 30, 2500.00),
  ('Coloración',     90, 6000.00);

INSERT INTO Turno (fecha, hora, observaciones, idCliente, idServicio, idEstado)
VALUES 
  ('2025-06-20', '10:00:00', 'Cliente puntual',    1, 1, 1),
  ('2025-06-21', '11:30:00', 'Aplicar color rubio', 2, 2, 1);
  
-- 9) Listar todos los turnos con cliente y servicio
SELECT 
  t.idTurno, 
  t.fecha, 
  t.hora, 
  c.nombre AS cliente, 
  s.nombre AS servicio
FROM Turno t
JOIN Cliente c    ON t.idCliente  = c.idCliente
JOIN Servicio s   ON t.idServicio = s.idServicio
JOIN EstadoTurno e ON t.idEstado   = e.idEstado;

-- Buscar turnos por fecha específica
SELECT 
  t.hora, 
  c.nombre AS cliente, 
  s.nombre AS servicio
FROM Turno t
JOIN Cliente c  ON t.idCliente  = c.idCliente
JOIN Servicio s ON t.idServicio = s.idServicio
WHERE t.fecha = '2025-06-11';

-- Consultar el historial de turnos de un cliente concreto
SELECT 
  t.fecha, 
  t.hora, 
  s.nombre AS servicio
FROM Turno t
JOIN Servicio s ON t.idServicio = s.idServicio
WHERE t.idCliente = 1;

-- Turnos confirmados para una fecha dada
SELECT 
  t.idTurno, 
  t.fecha, 
  t.hora, 
  c.nombre AS cliente
FROM Turno t
JOIN Cliente c      ON t.idCliente  = c.idCliente
JOIN EstadoTurno e  ON t.idEstado   = e.idEstado
WHERE e.nombre = 'Confirmado' AND t.fecha = '2025-06-11';

-- Cantidad de turnos por servicio
SELECT 
  s.nombre AS servicio, 
  COUNT(*) AS cantidad_turnos
FROM Turno t
JOIN Servicio s ON t.idServicio = s.idServicio
GROUP BY s.nombre;

-- Ingresos estimados por servicio
SELECT 
  s.nombre AS servicio, 
  COUNT(*) AS cantidad, 
  s.precio, 
  COUNT(*) * s.precio AS total_estimado
FROM Turno t
JOIN Servicio s ON t.idServicio = s.idServicio
GROUP BY s.nombre, s.precio;

-- Clientes frecuentes (más de un turno)
SELECT 
  c.nombre, 
  COUNT(*) AS total_turnos
FROM Turno t
JOIN Cliente c ON t.idCliente = c.idCliente
GROUP BY c.idCliente
HAVING COUNT(*) > 1;

-- Próximos turnos (desde hoy en adelante)
SELECT 
  t.fecha, 
  t.hora, 
  c.nombre AS cliente, 
  s.nombre AS servicio
FROM Turno t
JOIN Cliente c  ON t.idCliente  = c.idCliente
JOIN Servicio s ON t.idServicio = s.idServicio
WHERE t.fecha >= CURDATE()
ORDER BY t.fecha, t.hora;

-- 10) Eliminar un turno específico
DELETE FROM Turno WHERE idTurno = 2;

-- Eliminar un cliente (solo si no tiene turnos asociados)
DELETE FROM Cliente 
WHERE idCliente = 2;

