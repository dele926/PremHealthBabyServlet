package SQLConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This Class Creates a SQLQuery which returns all information
 * for a given clientID
 */
public abstract class SQLEdit extends SQLQuery implements Executeable {
    //edited
    //fields
    protected int patientID;

    public SQLEdit(int patientID){
        super();
        this.patientID = patientID;
    }

    @Override
    public ResultSet execute(Statement s) throws SQLException {
        //carrying out Edit
        System.out.println("The SQL Query Is " + sqlStr);
        try {
            s.executeUpdate(sqlStr);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //Returning updated patient
        SQLViewPatient viewPatient = new SQLViewPatient(patientID);
        ResultSet rset=s.executeQuery(viewPatient.getSQL());
        return rset;
    }

    @Override
    public String getSQL(){
        return sqlStr;
    }

    public int getPatientID(){
        return patientID;
    }


}
