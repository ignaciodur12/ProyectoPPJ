package Proyectoppj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApWebGestionApplicationTests {

    // Utiliza los datos de configuración proporcionados
    private static final String URL = "jdbc:mysql://localhost:3310/base_gestion_tareas";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";

    @Test
    void contextLoads() {
        // Este método se utiliza para verificar que el contexto de Spring se carga correctamente.
    }

    @Test
    public void testDatabaseConnection() {
        Connection connection = null;
        try {
            // Establece la conexión a la base de datos
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            assertNotNull(connection); // Verifica que la conexión no sea nula
        } catch (SQLException e) {
            e.printStackTrace(); // Muestra el error en caso de que falle la conexión
        } finally {
            if (connection != null) {
                try {
                    connection.close(); // Cierra la conexión
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

