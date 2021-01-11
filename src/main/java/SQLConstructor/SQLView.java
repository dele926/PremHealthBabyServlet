package SQLConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        return rset;
    }

    @Override
    public String getSQL(){
        return sqlStr;
    }

}
