package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManager {
    //URL y credenciales de MySQL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/tubasededatos";
    private static final String DB_USER = "tu_usuario";
    private static final String DB_PASSWORD = "tu_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void closeStatement(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
    }


    //Crea la Tabla Libros en el Schema si todavia no existe
    public static void createTableLibros() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();

            String sql = "CREATE TABLE IF NOT EXISTS libros (id INT AUTO_INCREMENT PRIMARY KEY," +
                    "titulo VARCHAR(255) NOT NULL, leido BOOLEAN NOT NULL)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                closeStatement(preparedStatement);
                closeConnection(connection);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Agrega un libro a la base de datos
    public static void addLibro(Libro libro) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String sql = "INSERT INTO libros (titulo, leido) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, libro.getTitle());
            preparedStatement.setBoolean(2, libro.isReaded());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeStatement(preparedStatement);
                closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Obtiene la lista de todos los libros desde la base de datos
    public static List<Libro> allLibros() {
        List<Libro> books = new ArrayList<Libro>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String sql = "SELECT id, titulo, leido FROM libros";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                boolean leido = resultSet.getBoolean("leido");
                Libro book = new Libro(id, titulo, leido);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResultSet(resultSet);
                closeStatement(preparedStatement);
                closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return books;
    }

    // Marca un libro como leído
    public static void readed(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String sql = "UPDATE libros SET leido = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeStatement(preparedStatement);
                closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Marca un libro como por leer
    public static void toRead(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            String sql = "UPDATE libros SET leido = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeStatement(preparedStatement);
                closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Elimina un libro de la base de datos
    public static void deleteLibro(int id) {
        Connection connection = null;
        PreparedStatement PreparedStatement = null;

        try {
            connection = getConnection();
            String sql = "DELETE FROM libros WHERE id = ?";
            PreparedStatement = connection.prepareStatement(sql);
            PreparedStatement.setInt(1, id);
            PreparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeStatement(PreparedStatement);
                closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}