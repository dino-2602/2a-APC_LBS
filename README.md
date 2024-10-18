# DBAnbindungen

<a name="readme-top"></a>
Author: Dino Haskic <br>
LBS Eibiswald | 2aAPC <br>
Erstellt am 18.10.2024

Diese Anwendung ist die achte Übung vom Labor ITL12...<br>

## Das Ziel der Übung
### •	Anlegen eines DB Servers (MariaDB/MySQL) am Rechner/RaspPI
### •	Einbindung der DB in IntelliJ



<div>•	Integration einer einfachen DB Anwendung am Client <div/>
<div>o	Lokale oder Remote Datenbank<div/>
<div>o	Einbindung in IntelliJ<div/>
<div>o	https://www.jetbrains.com/help/idea/connecting-to-a-database.html#<div/>
<div>•	Vorgang beim Einbinden von Daten aus der Datenbank dokumentieren<div/>
<div>•	Sequenzielles Auslesen aller Datensätze aus einer Tabelle (Employee)<div/>



## Installation

```cmd

git checkout origin/master
```
## oder
```cmd
git clone https://github.com/dino-2602/DBAnbindung
```
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Verwendung
Technologien im Einsatz:
[![Java][java.com]][java-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Die Verbindung zur DB passiert auf der Main.java
```java
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

```
<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[java.com]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[java-url]: https://www.java.com/de/
[product-screenshot]: Screen.png
