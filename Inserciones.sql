use Proyecto_jose_manuel_palomo_zambrano;



INSERT INTO categorias (nombre, descripcion) VALUES
('Novela Histórica', 'Novelas que abordan eventos históricos reales en su trama'),
('Fantasía', 'Novelas que tratan sobre mundos imaginarios y magia'),
('Romance', 'Novelas que exploran las relaciones amorosas entre los personajes'),
('Policial', 'Novelas que se centran en resolver misterios o crímenes');

INSERT INTO autor (nombre, biografia, nacionalidad, fecha_nacimiento) VALUES
('Gabriel García Márquez', 'Escritor colombiano, conocido por Cien años de soledad.', 'Colombia', '1927-03-06'),
('J.K. Rowling', 'Autora británica famosa por la saga de Harry Potter.', 'Reino Unido', '1965-07-31'),
('Jane Austen', 'Escritora inglesa, famosa por sus novelas sobre las costumbres de su tiempo.', 'Reino Unido', '1775-12-16'),
('Agatha Christie', 'Escritora británica, conocida por sus novelas de misterio.', 'Reino Unido', '1890-09-15'),
('Ken Follett', 'Escritor galés, conocido por sus novelas históricas.', 'Reino Unido', '1949-06-05');

INSERT INTO usuario (nombre, email, tipo_usuario) VALUES
('Juan Pérez', 'juan.perez@example.com', 'socio'),
('Ana García', 'ana.garcia@example.com', 'editor'),
('Carlos Rodríguez', 'carlos.rodriguez@example.com', 'socio'),
('Laura Martínez', 'laura.martinez@example.com', 'editor'),
('Pedro Sánchez', 'pedro.sanchez@example.com', 'socio');

INSERT INTO libros (titulo, sinopsis, id_categoria, fecha_publicacion, id_usuario) VALUES
('Cien años de soledad', 'Una novela que narra la historia de la familia Buendía en Macondo.', 1, '1967-05-30', 1),
('Harry Potter y la Piedra Filosofal', 'El primer libro de la saga de Harry Potter, que mezcla magia y aventura.', 2, '1997-06-26', 2),
('Orgullo y prejuicio', 'La historia de Elizabeth Bennet y su relación con el misterioso Mr. Darcy.', 3, '1813-01-28', 3),
('Asesinato en el Orient Express', 'El detective Hercule Poirot resuelve un asesinato en un tren.', 4, '1934-01-01', 4),
('Los pilares de la Tierra', 'Un relato épico sobre la construcción de una catedral en la Edad Media.', 1, '1989-09-01', 5);

INSERT INTO autor_libro (id_autor, id_libro) VALUES
(1, 1),  -- Gabriel García Márquez - Cien años de soledad
(2, 2),  -- J.K. Rowling - Harry Potter y la Piedra Filosofal
(3, 3),  -- Jane Austen - Orgullo y prejuicio
(4, 4),  -- Agatha Christie - Asesinato en el Orient Express
(5, 5);  -- Ken Follett - Los pilares de la Tierra

INSERT INTO valoracion (id_libro, id_usuario, puntuacion, comentario) VALUES
(1, 1, 5, 'Una obra maestra de la literatura.'),
(2, 2, 4, 'Muy entretenido y mágico.'),
(3, 3, 5, 'Una historia de amor que ha trascendido generaciones.'),
(4, 4, 4, 'Un gran misterio, aunque algo predecible en ciertos puntos.'),
(5, 5, 5, 'Una novela histórica fascinante y bien escrita.');

INSERT INTO pregunta (id_libro, id_usuario, contenido) VALUES
(1, 1, '¿Qué significado tiene el realismo mágico en Cien años de soledad?'),
(2, 2, '¿Cómo logró J.K. Rowling crear un mundo tan inmersivo?'),
(3, 3, '¿Qué opinas de la relación entre Elizabeth Bennet y Mr. Darcy?'),
(4, 4, '¿Cómo se siente resolver un caso con tantas pistas falsas?'),
(5, 5, '¿Cómo se logró retratar tan bien la Edad Media en Los pilares de la Tierra?');

INSERT INTO respuesta (id_pregunta, id_usuario, contenido) VALUES
(1, 2, 'El realismo mágico refleja la mezcla entre lo cotidiano y lo extraordinario en la vida de los personajes.'),
(2, 3, 'La clave está en la construcción de personajes complejos y un mundo con reglas propias, pero realistas.'),
(3, 4, 'Es una relación basada en la superación personal y la comprensión de las diferencias entre ambos.'),
(4, 5, 'Poirot usa su observación y la lógica para descubrir detalles que otros pasan por alto.'),
(5, 1, 'Ken Follett se sumerge en la historia con gran detalle, creando un escenario inmersivo y veraz.');

INSERT INTO favoritos (id_usuario, id_libro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);
