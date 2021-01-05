package SQLConstructor;

import java.sql.Time;

/**
 * This Class Creates a SQLQuery which returns all information
 * for a given clientID
 */
public abstract class SQLEdit extends SQLQuery {
    //edited
    //fields
    protected int patientID;

    public SQLEdit(int patientID){
        super();
        this.patientID = patientID;
    }
    public int getPatientID(){
        return patientID;
    }

}
