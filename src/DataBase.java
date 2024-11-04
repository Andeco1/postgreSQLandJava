import java.sql.*;
import java.util.ArrayList;

public class DataBase implements Selectable {
    private static DataBase instance;
    private Connection connection;
    private String URL, USER,PASSWORD;
    private DataBase(String url,String user, String password) throws SQLException {
        this.URL = url;
        this.USER = user;
        this.PASSWORD = password;
        connection = DriverManager.getConnection(url,user,password);
    };

    public static DataBase getInstance(String url,String user, String password) throws SQLException {
        if(instance == null){
            instance = new DataBase(url,user,password);
        }
        return instance;
    }

    public ResultSet selectByInterval(Date from_date, Date to_date) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM public.records WHERE date_operation>='"+from_date.toString()+"' AND date_operation<='"+to_date.toString()+"'");
        while (results.next()) {
            Integer id = results.getInt(1);
            Boolean name = results.getBoolean(2);
            Integer id_cat = results.getInt(3);
            Date date = results.getDate(4);
            Float total = results.getFloat(5);
            System.out.println(id+" "+name+" "+id_cat+" "+ date+" "+ total);
        }
        return results;
    }

    public ResultSet selectByCategory(ArrayList<Integer> category_names) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM public.records WHERE id_category in ("+category_names.toString().substring(1,category_names.toString().length()-1)+")");
        while (results.next()) {
            Integer id = results.getInt(1);
            Boolean name = results.getBoolean(2);
            Integer id_cat = results.getInt(3);
            Date date = results.getDate(4);
            Float total = results.getFloat(5);
            System.out.println(id+" "+name+" "+id_cat+" "+ date+" "+ total);
        }
        return results;
    }
}
