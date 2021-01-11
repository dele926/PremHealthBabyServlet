package SQLConstructor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

/**
 * physicians can update the prescription whereas clinicians can't
 */

public class SQLEditPhysician extends SQLEditClinician implements Executeable {
    //additional field
    protected String prescription;

    //constructor
    public SQLEditPhysician(int patientID, String comment, double glucose_input,
                            double lactate_input, double sodium_input, double potassium_input,
                            Time time, String event_type, String prescription){
        super(patientID, comment, glucose_input, lactate_input, sodium_input, potassium_input, event_type, time);
        this.prescription = prescription;
        _type = "EditPhysician";
        sqlStr = "UPDATE " + "patients" + " SET glucose_manual = " + glucose_input + ", potassium_manual = " +
                potassium_input + ", sodium_manual = " + sodium_input + ", lactate_manual = " + lactate_input + " prescription = \'" +
                prescription + "\', comments = \'" + comment + "\' WHERE time = \'" + time + "\' AND patient_id = " + patientID + ";";
    }

    //access methods
    public String getPrescription() {
        return prescription;
    }
}
