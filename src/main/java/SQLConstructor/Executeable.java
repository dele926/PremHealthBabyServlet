package SQLConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Interface Executeable for method "execute"
 * Implemented at the SQLEdit and SQLView levels
 * Purpose is to pass the sqlStr for each object to the SQL database, then store
 * the retrieved object into a ResultSet
 */
public interface Executeable{
    //edited
    ResultSet execute(Statement s) throws SQLException;
}
