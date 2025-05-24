# ProyectoPalomoZambranoJoseManuel

Objetivo principal del proyecto: Un sistema de gestión de opiniones, valoraciones, preguntas y respuestas de libros independientes, además de permitir que los usuarios suban entradas de libros propios a la app.

FUNCIONALIDADES DETALLADAS:

1. Subir entrada de un libro por categoría 
Permite registrar un nuevo libro en la base de datos. El usuario deberá proporcionar: 
● Título 
● Sinopsis 
● ID de la categoría 
● Fecha de publicación (en formato yyyy-MM-dd) 
● ID del usuario creador 
● IDs de los autores (separados por comas) 
2. Publicar valoración 
El usuario puede publicar una valoración sobre un libro específico. Se solicita:
● ID del libro 
● ID del usuario 
● Puntuación (del 1 al 5) 
● Comentario (opcional)
3. Publicar pregunta en foro de un libro 
Permite al usuario publicar una pregunta relacionada con un libro en el foro correspondiente. Se 
requiere: 
● ID del libro 
● ID del usuario 
● Contenido de la pregunta 
4. Responder una pregunta 
Los usuarios pueden responder preguntas publicadas en el foro. Se deben proporcionar: 
● ID de la pregunta 
● ID del usuario que responde 
● Contenido de la respuesta 
5. Ver historial de preguntas y respuestas 
Muestra todas las preguntas y sus respectivas respuestas asociadas a un libro determinado. Requiere: 
● ID del libro 
6. Ver libros mejor valorados por categoría 
Permite visualizar una lista de los libros con mejores valoraciones dentro de una categoría específica. 
Se solicita: 
● ID de la categoría 
7. Ver libros de un autor específico 
Permite obtener un listado de títulos escritos por un autor en particular. Se requiere:
● ID del autor 
8. Buscar información de un libro 
Permite buscar libros por título o por coincidencias parciales del mismo. Se solicita: 
● Parte o totalidad del título del libro 
9. Añadir libro a favoritos 
El usuario puede marcar un libro como favorito. Se deben ingresar: 
● ID del usuario 
● ID del libro 
10. Ver lista de libros favoritos 
Muestra la lista de libros que un usuario ha marcado como favoritos. Se necesita: 
● ID del usuario
