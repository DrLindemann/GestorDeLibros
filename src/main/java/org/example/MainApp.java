package org.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        boolean close = false;

        //Conecta a la base de datos
        DataBaseManager.getConnection();
        //Crea la tabla libros si no existe en tu Schema
        DataBaseManager.createTableLibros();

        //Menu principal de la App
        while (!close) {
            System.out.println("-------------------------------------");
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Agregar libro");
            System.out.println("2. Marcar libro como leído");
            System.out.println("3. Marcar libro como por leer");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Listar libros");
            System.out.println("6. Salir");
            System.out.println("-------------------------------------");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addLibro();
                    break;
                case 2:
                    readed();
                    break;
                case 3:
                    toRead();
                    break;
                case 4:
                    deleteLibro();
                    break;
                case 5:
                    allLibros();
                    break;
                case 6:
                    close = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }


        }

    }

    private static void addLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título del libro: ");
        String title = scanner.nextLine();
        System.out.println("¿Ha leído este libro? (Sí/No): ");
        String option = scanner.nextLine();
        boolean readed = option.equalsIgnoreCase("Si");

        Libro book = new Libro(0, title, readed);
        DataBaseManager.addLibro(book);
        System.out.println("Libro agregado con éxito.");
    }

    // Método para listar todos los libros
    private static void allLibros() {
        List<Libro> books = DataBaseManager.allLibros();

        if (books.isEmpty()) {
            System.out.println("No hay libros en la lista.");
        } else {
            System.out.println("Lista de libros:");
            for (Libro book : books) {
                String estado = book.isReaded() ? "Leído" : "Por leer";
                System.out.println(book.getId() + ". " + book.getTitle() + " - " + estado);
            }
        }
    }

    // Método para marcar un libro como leído
    private static void readed() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del libro que desea marcar como leído: ");
        int id = scanner.nextInt();
        DataBaseManager.readed(id);
        System.out.println("Libro marcado como leído con éxito.");
    }

    // Método para marcar un libro como por leer
    private static void toRead() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del libro que desea marcar como por leer: ");
        int id = scanner.nextInt();
        DataBaseManager.toRead(id);
        System.out.println("Libro marcado como por leer con éxito.");
    }

    // Método para eliminar un libro
    private static void deleteLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del libro que desea eliminar: ");
        int id = scanner.nextInt();
        DataBaseManager.deleteLibro(id);
        System.out.println("Libro eliminado con éxito.");
    }
}
