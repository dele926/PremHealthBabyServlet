package SQLConstructor;
import java.sql.Time;

public class SQLEditClinician extends SQLEdit{
    private String comment;
    private double glucose_manual;
    private double lactate_manual;
    private double sodium_manual;
    private double potassium_manual;
    private Time time;
    String[] values;

    public SQLEditClinician(String patientID, String comment, double glucose_manual, double lactate_manual, double sodium_manual, double potassium_manual, Time time){
        super(patientID);
        this.comment = comment;
        this.glucose_manual = glucose_manual;
        this.lactate_manual = lactate_manual;
        this.sodium_manual = sodium_manual;
        this.potassium_manual = potassium_manual;
        this.time = time;
    }

    public String getSQL(){
        String sqlStr;
        sqlStr = "UPDATE " + "patient_" + patientID + "SET glucose_manual = " + glucose_manual + ", potassium_manual = " +
                potassium_manual + ", sodium_manual = " + sodium_manual + ", lactate_manual = " + lactate_manual +
                " WHERE time = " + time + ";";
        return sqlStr;
    }



}
