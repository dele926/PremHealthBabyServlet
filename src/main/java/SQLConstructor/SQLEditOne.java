package SQLConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLEditOne extends SQLEdit implements Executeable{

    String what;
    String sqlStr;
    public SQLEditOne(int patientID, String what){
        super(patientID);
        _type = "EditOne";
        this.what = what;
        sqlStr = "UPDATE patients SET comments = 'this is EditOne' WHERE time = '00:00:00' AND patient_ID = 2342;";
    }

    @Override
    public ResultSet execute(Statement s){
        System.out.println("The SQL Query Is " + sqlStr);
        try {
            s.executeUpdate(sqlStr);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //Returning updated patient
        ResultSet rset= null;
        try {
            rset = s.executeQuery("SELECT * FROM patients WHERE time = '00:00:00' AND patient_id = 2342;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rset;
    }
}
