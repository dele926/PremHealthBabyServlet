package SQLConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Superclass of all View queries. Implements execute
 * The execute differs to that of the "Edit" classes as we are using
 * .executeQuery as opposed to .executeUpdate
 */

public abstract class SQLView extends SQLQuery implements Executeable{

    public SQLView(){
        super();
        _type="Generic View";
    }

    @Override
    public ResultSet execute(Statement s){
        ResultSet rset = null;
        System.out.println("The SQL Query Is " + sqlStr);
        try {
            rset = s.executeQuery(sqlStr);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Successfully Executed!");
        return rset;
    }

    @Override
    public String getSQL(){
        return sqlStr;
    }

}
