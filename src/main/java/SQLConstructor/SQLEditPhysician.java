package SQLConstructor;
import java.sql.Time;

/**
 * physicians can update the prescription whereas clinicians can't
 */

public class SQLEditPhysician extends SQLEditClinician {
    //additional field
    private String prescription;

    //constructor
    public SQLEditPhysician(String patientID, String comment, double glucose_manual,
                            double lactate_manual, double sodium_manual, double potassium_manual,
                            Time time, String event_type, String prescription){
        super(patientID, comment, glucose_manual, lactate_manual, sodium_manual, potassium_manual, event_type, time);
        this.prescription = prescription;
        type = "EditPhysician";
    }

    @Override
    public String getSQL(){
        String sqlStr;
        sqlStr = "UPDATE " + "patient_" + patientID + "SET glucose_manual = " + glucose_manual + ", potassium_manual = " +
                potassium_manual + ", sodium_manual = " + sodium_manual + ", lactate_manual = " + lactate_manual + " prescription = " +
                prescription + " WHERE time = " + time + ";";
        return sqlStr;
    }

    public String getPrescription() {
        return prescription;
    }
}
