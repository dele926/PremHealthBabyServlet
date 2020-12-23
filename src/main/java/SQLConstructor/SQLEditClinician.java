package SQLConstructor;

import java.sql.Time;

public class SQLEditClinician extends SQLEdit{
    protected String comment;
    protected double glucose_manual;
    protected double lactate_manual;
    protected double sodium_manual;
    protected double potassium_manual;
    protected String event_type;
    protected Time time;

    public SQLEditClinician(String patientID, String comment, double glucose_manual, double lactate_manual,
                            double sodium_manual, double potassium_manual, String event_type, Time time){
        super(patientID);
        this.comment = comment;
        this.glucose_manual = glucose_manual;
        this.lactate_manual = lactate_manual;
        this.sodium_manual = sodium_manual;
        this.potassium_manual = potassium_manual;
        this.event_type = event_type;
        this.time = time;
    }

    public String getSQL(){
        String sqlStr;
        sqlStr = "UPDATE " + "patient_" + patientID + "SET glucose_manual = " + glucose_manual + ", potassium_manual = " +
                potassium_manual + ", sodium_manual = " + sodium_manual + ", lactate_manual = " + lactate_manual +
                " event_type = " + event_type + " WHERE time = " + time + ";";
        return sqlStr;
    }



}
