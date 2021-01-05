package SQLConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface Executeable{
    //edited
    ResultSet execute(Statement s) throws SQLException;
}
