## Aplicación de Gestión de Libros

Esta es una aplicación de consola en Java que te permite gestionar una
lista de libros. Puedes agregar nuevos libros, marcarlos como leídos o
por leer, eliminar libros y listar todos los libros almacenados en una
base de datos MySQL.

## Requisitos

Antes de ejecutar la aplicación, asegúrate de tener instalado lo
siguiente:

* Java Development Kit (JDK) 8 o superior.

* MySQL Server instalado y configurado.

## Configuración de la Base de Datos

* 1 Crea una base de datos en MySQL para almacenar la información de los
libros. Puedes utilizar el siguiente comando SQL como referencia:

     CREATE DATABASE tu_base_de_datos;

* 2 Actualiza la configuración de acceso a la base de datos en la clase
\`DatabaseManager.java\` con tu información de conexión MySQL (URL,
usuario y contraseña).
* 3 En la clase DataBaseManager están las variables donde deberás
deberás poner la url de tu base de datos, el usuario y la contrasenia.

## Ejecución de la Aplicación

* 1 Clona o descarga este repositorio en tu computadora.

* 2\. Abre una terminal o línea de comandos y navega al directorio donde
se encuentra la aplicación.

* 3\. Compila el código fuente utilizando el siguiente comando:

      javac MainApp.java

* 4\. Ejecuta la aplicación con el siguiente comando:

             java MainApp

* 5\. La aplicación mostrará un menú interactivo en la consola que te
permitirá realizar varias operaciones de gestión de libros.

## Uso de la Aplicación

* Agregar Libro: Agrega un nuevo libro a la lista. Debes proporcionar
el título del libro y especificar si lo has leído o no.

* Marcar Libro como Leído: Marca un libro existente como leído.

* Marcar Libro como por Leer: Marca un libro existente como por leer.

* Eliminar Libro: Elimina un libro de la lista.

* Listar Libros: Muestra la lista de todos los libros almacenados en la
base de datos.

* Salir: Cierra la aplicación.
