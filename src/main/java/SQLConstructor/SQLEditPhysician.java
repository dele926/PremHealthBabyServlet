package SQLConstructor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

/**
 * physicians can update the prescription whereas clinicians can't
 */

public class SQLEditPhysician extends SQLEditClinician implements Gettable, Executeable {
    //additional field
    private String prescription;

    //constructor
    public SQLEditPhysician(int patientID, String comment, double glucose_input,
                            double lactate_input, double sodium_input, double potassium_input,
                            Time time, String event_type, String prescription){
        super(patientID, comment, glucose_input, lactate_input, sodium_input, potassium_input, event_type, time);
        this.prescription = prescription;
        _type = "EditPhysician";
    }

    @Override
    public String getSQL(){
        String sqlStr;
        sqlStr = "UPDATE " + "patients" + " SET glucose_manual = " + glucose_input + ", potassium_manual = " +
                potassium_input + ", sodium_manual = " + sodium_input + ", lactate_manual = " + lactate_input + " prescription = \'" +
                prescription + "\', comments = \'" + comment + "\' WHERE time = \'" + time + "\' AND patient_id = " + patientID + ";";
        return sqlStr;
    }

    @Override
    public ResultSet execute(Statement s) throws SQLException {
        //carrying out Edit
        getSQL();
        System.out.println("The SQL Query Is " + sqlStr);
        try {
            s.executeUpdate(sqlStr);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //Returning updated patient
        SQLViewClinician viewClinician = new SQLViewClinician(patientID);
        ResultSet rset=s.executeQuery(viewClinician.getSQL());
        return rset;
    }

    public String getPrescription() {
        return prescription;
    }
}
