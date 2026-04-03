CREATE TABLE USUARIO (
    id_usuario SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL
);

CREATE TABLE ESTADO (
    id_estado SERIAL PRIMARY KEY,
    nombre_estado VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100)
);

CREATE TABLE CATEGORIA (
    id_categoria SERIAL PRIMARY KEY,
    nombre_categoria VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100)
);

CREATE TABLE TAREAS (
    id_tarea SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion VARCHAR(100),
    fecha_creacion DATE NOT NULL,
    fecha_limite DATE,
    observaciones VARCHAR(100),
    id_usuario INT NOT NULL,
    id_estado INT NOT NULL,
    id_categoria INT NOT NULL,

    FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario),
    FOREIGN KEY (id_estado) REFERENCES ESTADO(id_estado),
    FOREIGN KEY (id_categoria) REFERENCES CATEGORIA(id_categoria),

    CHECK (fecha_limite >= fecha_creacion)
);