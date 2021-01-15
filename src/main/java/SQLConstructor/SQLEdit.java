package SQLConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Superclass of all SQLEdit Objects
 * Implements Executeable by overriding .execute method
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
        //For troubleshooting purposes, print SQL Query to server console
        System.out.println("The SQL Query Is " + sqlStr);
        try {
            //executing UPDATE query
            s.executeUpdate(sqlStr);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //after updating, need to return the new updated patient information
        //this is done through executing a SQLViewPatient object of the correct ID:
        SQLViewPatient viewPatient = new SQLViewPatient(patientID);
        ResultSet rset=s.executeQuery(viewPatient.getSQL());
        System.out.println("Successfully Executed!");
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
