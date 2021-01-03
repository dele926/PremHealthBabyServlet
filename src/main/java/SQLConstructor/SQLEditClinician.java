package SQLConstructor;

import java.sql.Time;

public class SQLEditClinician extends SQLEdit {
    protected String comment;
    protected double glucose_input;
    protected double lactate_input;
    protected double sodium_input;
    protected double potassium_input;
    protected String event_type;
    protected Time time;

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
        String sqlStr;
        sqlStr = "UPDATE " + "patients"+ " SET glucose_input = " + glucose_input + ", potassium_input = " +
                potassium_input + ", sodium_input = " + sodium_input + ", lactate_input = " + lactate_input +
                ", event_type = \'" +  event_type + "\' WHERE time = \'" + time + "\' AND patient_id = 2342;";
        return sqlStr;
    }

    //Access Methods

}
