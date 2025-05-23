
DROP DATABASE IF EXISTS Proyecto_jose_manuel_palomo_zambrano;
CREATE DATABASE IF NOT EXISTS Proyecto_jose_manuel_palomo_zambrano CHARACTER SET utf8mb4;
USE Proyecto_jose_manuel_palomo_zambrano;

-- CATEGORÍAS DE LIBROS
CREATE TABLE categorias (
    id_categoria SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);

-- AUTORES
CREATE TABLE autor (
    id_autor SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    biografia TEXT,
    nacionalidad VARCHAR(100),
    fecha_nacimiento DATE
);

-- USUARIOS (Base común)
CREATE TABLE usuario (
    id_usuario SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    tipo_usuario VARCHAR(20) CHECK (tipo_usuario IN ('socio', 'editor')),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- LIBROS
CREATE TABLE libros (
    id_libro SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    sinopsis TEXT,
    id_categoria INT REFERENCES categorias(id_categoria),
    fecha_publicacion DATE,
    id_usuario INT REFERENCES usuario(id_usuario)
);

CREATE TABLE autor_libro (
    id_autor INT REFERENCES autor(id_autor),
    id_libro INT REFERENCES libros(id_libro),
    PRIMARY KEY (id_autor, id_libro)
);


-- VALORACIONES DE LIBROS
CREATE TABLE valoracion (
    id_valoracion SERIAL PRIMARY KEY,
    id_libro INT REFERENCES libros(id_libro),
    id_usuario INT REFERENCES usuario(id_usuario),
    puntuacion INT CHECK (puntuacion BETWEEN 1 AND 5),
    comentario TEXT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- PREGUNTAS EN FOROS DE LIBROS
CREATE TABLE pregunta (
    id_pregunta SERIAL PRIMARY KEY,
    id_libro INT REFERENCES libros(id_libro),
    id_usuario INT REFERENCES usuario(id_usuario),
    contenido TEXT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- RESPUESTAS A PREGUNTAS
CREATE TABLE respuesta (
    id_respuesta SERIAL PRIMARY KEY,
    id_pregunta INT REFERENCES pregunta(id_pregunta),
    id_usuario INT REFERENCES usuario(id_usuario),
    contenido TEXT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- LIBROS FAVORITOS
CREATE TABLE favoritos (
    id_usuario INT REFERENCES usuario(id_usuario),
    id_libro INT REFERENCES libros(id_libro),
    PRIMARY KEY (id_usuario, id_libro)
);

