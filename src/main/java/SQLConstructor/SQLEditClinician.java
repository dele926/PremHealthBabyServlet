package SQLConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class SQLEditClinician extends SQLEdit implements Executeable, Gettable{
    protected String comment;
    protected double glucose_input;
    protected double lactate_input;
    protected double sodium_input;
    protected double potassium_input;
    protected String event_type;
    protected Time time;
    protected String sqlStr = "";

    public SQLEditClinician(int patientID, String comment, double glucose_input, double lactate_input,
                            double sodium_input, double potassium_input, String event_type, Time time){
        super(patientID);
        _type = "EditClinician";
        this.comment = comment;
        this.glucose_input = glucose_input;
        this.lactate_input = lactate_input;
        this.sodium_input = sodium_input;
        this.potassium_input = potassium_input;
        this.event_type = event_type;
        this.time = time;
    }

    @Override
    public String getSQL(){
        sqlStr = "UPDATE " + "patients"+ " SET glucose_input = " + glucose_input + ", potassium_input = " +
                potassium_input + ", sodium_input = " + sodium_input + ", lactate_input = " + lactate_input +
                ", event_type = \'" +  event_type + "\', comments = \'" + comment + "\' WHERE time = \'" + time + "\' AND patient_id = 2342;";
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

    //Access Methods

}
