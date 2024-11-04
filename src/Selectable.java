import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Selectable {
    ResultSet selectByInterval(Date from_date, Date to_Date) throws SQLException;
    ResultSet selectByCategory(ArrayList<Integer> category_names) throws SQLException;
}
