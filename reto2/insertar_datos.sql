INSERT INTO ESTADO (nombre_estado) VALUES
('Pendiente'),
('En progreso'),
('Completada'),
('Cancelada');

INSERT INTO USUARIO (nombre, email, contraseña) VALUES
('Sergio', 'sergio@email.com', '1234');

INSERT INTO CATEGORIA (nombre_categoria) VALUES
('Trabajo'),
('Personal');

INSERT INTO TAREAS (titulo, descripcion, fecha_creacion, fecha_limite, id_usuario, id_estado, id_categoria)
VALUES
('Estudiar SQL', 'Practicar base de datos', '2026-04-01', '2026-04-10', 1, 1, 1);