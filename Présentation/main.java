package Présentation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class main {
    private static final String URL = "jdbc:postgresql://localhost:5432/biblio";

    private static final String USER = "postgres";

    private static final String PASSWORD = "123";

    public static void main(String[] args) {

        verifierConnexion();
    }

    public static void verifierConnexion() {
        Connection connection = null;

        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            if (connection != null) {
                System.out.println("Connexion à la base de données réussie !");
            } else {
                System.out.println("Échec de la connexion à la base de données.");
            }

        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données : " + e.getMessage());
        } finally {
            try {

                if (connection != null) {
                    connection.close();
                    System.out.println("Connexion fermée.");
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}
