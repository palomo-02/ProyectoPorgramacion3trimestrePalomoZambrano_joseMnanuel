use Proyecto_jose_manuel_palomo_zambrano;

-- CONSULTAS --
-- 1. Libros con sus autores y categoría:
SELECT l.titulo, a.nombre AS autor, c.nombre AS categoria
FROM libros l
JOIN autor_libro al ON l.id_libro = al.id_libro
JOIN autor a ON al.id_autor = a.id_autor
JOIN categorias c ON l.id_categoria = c.id_categoria;

-- 2. Puntuación promedio de cada libro con más de 2 valoraciones:
SELECT l.titulo, AVG(v.puntuacion) AS promedio_puntuacion, COUNT(*) AS cantidad_valoraciones
FROM libros l
JOIN valoracion v ON l.id_libro = v.id_libro
GROUP BY l.titulo
HAVING COUNT(*) > 2;

-- 3. Usuarios con más preguntas en foros:
SELECT u.nombre, COUNT(p.id_pregunta) AS total_preguntas
FROM usuario u
JOIN pregunta p ON u.id_usuario = p.id_usuario
GROUP BY u.id_usuario
ORDER BY total_preguntas DESC;

-- 4 Libros con puntuación mayor al promedio global:
SELECT l.titulo, AVG(v.puntuacion) AS puntuacion_media
FROM libros l
JOIN valoracion v ON l.id_libro = v.id_libro
GROUP BY l.id_libro
HAVING AVG(v.puntuacion) > (
    SELECT AVG(puntuacion) FROM valoracion
);

-- 5. Autores que han escrito más de 1 libro:
SELECT a.nombre, COUNT(al.id_libro) AS total_libros
FROM autor a
JOIN autor_libro al ON a.id_autor = al.id_autor
GROUP BY a.id_autor
HAVING COUNT(al.id_libro) > 1;

SET SQL_SAFE_UPDATES = 0;


-- UPDATES--
-- 6. Actualizar sinopsis de libros sin puntuación y añadir nota de "pendiente de valorar"
UPDATE libros
SET sinopsis = COALESCE(sinopsis, '') || ' (Pendiente de valoración)'
WHERE id_libro NOT IN (SELECT DISTINCT id_libro FROM valoracion);

-- 7 Actualizar la nacionalidad de un autor si no la tiene asignada 
UPDATE autor
SET nacionalidad = 'Desconocida'
WHERE (nacionalidad IS NULL OR nacionalidad = '')
  AND id_autor IN (
    SELECT DISTINCT id_autor
    FROM autor_libro
);

-- DELETE--
-- 8. Eliminar preguntas sin respuestas después de 30 días:
DELETE FROM pregunta
WHERE id_pregunta NOT IN (SELECT id_pregunta FROM respuesta)
AND fecha < NOW() - INTERVAL 30 DAY;

-- VISTAS --
-- 1. Vista de libros con su puntuación promedio y número de valoraciones:
CREATE VIEW vista_libros_valorados AS
SELECT l.id_libro, l.titulo, AVG(v.puntuacion) AS media, COUNT(v.id_valoracion) AS total_valoraciones
FROM libros l
JOIN valoracion v ON l.id_libro = v.id_libro
GROUP BY l.id_libro;

-- 2. Vista de usuarios con su actividad en preguntas y respuestas:
CREATE VIEW vista_actividad_usuarios AS
SELECT u.id_usuario, u.nombre,
       COUNT(DISTINCT p.id_pregunta) AS num_preguntas,
       COUNT(DISTINCT r.id_respuesta) AS num_respuestas
FROM usuario u
LEFT JOIN pregunta p ON u.id_usuario = p.id_usuario
LEFT JOIN respuesta r ON u.id_usuario = r.id_usuario
GROUP BY u.id_usuario;

-- PROCEDIMIENTOS--
-- 1. Función para obtener la media de puntuación de un libro:
DELIMITER //
CREATE FUNCTION obtener_media_puntuacion(libro_id INT) RETURNS FLOAT
DETERMINISTIC
BEGIN
  DECLARE media FLOAT;
  SELECT AVG(puntuacion) INTO media
  FROM valoracion
  WHERE id_libro = libro_id;
  RETURN media;
END //
DELIMITER ;

-- 2. Procedimiento para insertar una nueva valoración solo si el usuario aún no valoró ese libro: 

DELIMITER //
CREATE PROCEDURE insertar_valoracion(
    IN p_id_libro INT,
    IN p_id_usuario INT,
    IN p_puntuacion INT,
    IN p_comentario TEXT
)
BEGIN
  IF NOT EXISTS (
      SELECT 1 FROM valoracion
      WHERE id_libro = p_id_libro AND id_usuario = p_id_usuario
  ) THEN
    INSERT INTO valoracion (id_libro, id_usuario, puntuacion, comentario)
    VALUES (p_id_libro, p_id_usuario, p_puntuacion, p_comentario);
  END IF;
END //
DELIMITER ;


-- 3. Procedimiento para añadir un libro favorito (verifica duplicados):
DELIMITER //
CREATE PROCEDURE agregar_favorito(
    IN p_id_usuario INT,
    IN p_id_libro INT
)
BEGIN
  IF NOT EXISTS (
    SELECT 1 FROM favoritos WHERE id_usuario = p_id_usuario AND id_libro = p_id_libro
  ) THEN
    INSERT INTO favoritos (id_usuario, id_libro)
    VALUES (p_id_usuario, p_id_libro);
  END IF;
END //
DELIMITER ;

-- TRIGGERS--
-- 1. 
DELIMITER //
CREATE TRIGGER before_insert_valoracion
BEFORE INSERT ON valoracion
FOR EACH ROW
BEGIN
  IF NEW.puntuacion < 1 OR NEW.puntuacion > 5 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Puntuación fuera de rango (1-5)';
  END IF;
END //
DELIMITER ;

-- 2. 
CREATE TABLE IF NOT EXISTS log_preguntas (
    id_log INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_pregunta INT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER //
CREATE TRIGGER after_insert_pregunta
AFTER INSERT ON pregunta
FOR EACH ROW
BEGIN
  INSERT INTO log_preguntas (id_usuario, id_pregunta)
  VALUES (NEW.id_usuario, NEW.id_pregunta);
END //
DELIMITER ;























