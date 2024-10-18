import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MariaDBQuery {
    public static void main(String[] args) {
        // JDBC URL, Benutzername und Passwort
        String url = "jdbc:mariadb://localhost:3306/itl12db";
        String user = "root";
        String password = "";

        // Verbindung zur Datenbank herstellen
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // SQL-Abfrage ausführen
            String sql = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP";
            ResultSet resultSet = statement.executeQuery(sql);

            // Ergebnistabelle ausgeben
            System.out.println("EMPNO | ENAME      | JOB       | SALARY  | DEPTNO");
            System.out.println("-----------------------------------------------");

            // Ergebniszeilen ausgeben
            while (resultSet.next()) {
                int empNo = resultSet.getInt("EMPNO");
                String ename = resultSet.getString("ENAME");
                String job = resultSet.getString("JOB");
                double salary = resultSet.getDouble("SAL");
                int deptNo = resultSet.getInt("DEPTNO");

                System.out.printf("%5d | %-10s | %-9s | %7.2f | %6d%n", empNo, ename, job, salary, deptNo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}