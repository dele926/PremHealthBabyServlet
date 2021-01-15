package SQLConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

/**
 * Used by clinicians to add comments and manually measured metabolite inputs
 */

public class SQLEditClinician extends SQLEdit implements Executeable{
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
        sqlStr = "UPDATE " + "patients"+ " SET glucose_input = " + glucose_input + ", potassium_input = " +
                potassium_input + ", sodium_input = " + sodium_input + ", lactate_input = " + lactate_input +
                ", event_type = \'" +  event_type + "\', comments = \'" + comment + "\' WHERE time = \'" + time + "\' AND patient_id = 2342;";
    }

    //Access Methods
    public String getComment() {
        return comment;
    }

    public double getGlucose_input() {
        return glucose_input;
    }

    public double getLactate_input(){
        return lactate_input;
    }

    public double getSodium_input() {
        return sodium_input;
    }


    public double getPotassium_input() {
        return potassium_input;
    }

    public String getEvent_type() {
        return event_type;
    }

    public Time getTime(){
        return time;
    }
}
