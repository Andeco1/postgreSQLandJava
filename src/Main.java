import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/Records";
        String user = "postgres";
        String password = "@Ynik2005";
        DataBase newDataBase = DataBase.getInstance(url,user,password);
        newDataBase.selectByInterval(new Date(2020-1900,9,2),new Date(2024-1900,1,1));
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        newDataBase.selectByCategory(arr);
 //        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Records","postgres","@Ynik2005");
//
//        Statement statement = connection.createStatement();
//        ResultSet results = statement.executeQuery("SELECT * FROM public.records");
//
//        while (results.next()) {
//            Integer id = results.getInt(1);
//            Boolean name = results.getBoolean(2);
//            Integer id_cat = results.getInt(3);
//            Date date = results.getDate(4);
//            Float total = results.getFloat(5);
//            System.out.println(results.getRow() + id+" "+name+" "+id_cat+" "+ date+" "+ total);
//        }
//        connection.close();
    }
}