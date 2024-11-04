import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","@Ynik2005");

        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM sweets_types");

        while (results.next()) {
            Integer id = results.getInt(1);
            String name = results.getString(2);
            System.out.println(results.getRow() + ". " + id + "\t"+ name);
        }
        connection.close();
    }
}