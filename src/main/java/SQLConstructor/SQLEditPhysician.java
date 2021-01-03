package SQLConstructor;
import java.sql.Time;

/**
 * physicians can update the prescription whereas clinicians can't
 */

public class SQLEditPhysician extends SQLEditClinician {
    //additional field
    private String prescription;

    //constructor
    public SQLEditPhysician(String patientID, String comment, double glucose_input,
                            double lactate_input, double sodium_input, double potassium_input,
                            Time time, String event_type, String prescription){
        super(patientID, comment, glucose_input, lactate_input, sodium_input, potassium_input, event_type, time);
        this.prescription = prescription;
        type = "EditPhysician";
    }

    @Override
    public String getSQL(){
        String sqlStr;
        sqlStr = "UPDATE " + "patient_" + patientID + "SET glucose_manual = " + glucose_input + ", potassium_manual = " +
                potassium_input + ", sodium_manual = " + sodium_input + ", lactate_manual = " + lactate_input + " prescription = " +
                prescription + " WHERE time = " + time + ";";
        return sqlStr;
    }

    public String getPrescription() {
        return prescription;
    }
}
