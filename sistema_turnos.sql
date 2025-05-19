-- Crear base de datos
CREATE DATABASE IF NOT EXISTS sistema_turnos;
USE sistema_turnos;

-- Tabla Cliente
CREATE TABLE Cliente (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    email VARCHAR(100)
);

-- Tabla Servicio
CREATE TABLE Servicio (
    idServicio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    duracion INT NOT NULL, -- en minutos
    precio DECIMAL(10, 2) NOT NULL
);

-- Tabla Turno
CREATE TABLE Turno (
    idTurno INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    observaciones VARCHAR(255),
    idCliente INT NOT NULL,
    idServicio INT NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY (idServicio) REFERENCES Servicio(idServicio)
);

