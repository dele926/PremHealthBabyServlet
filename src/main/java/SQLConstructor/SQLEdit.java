package SQLConstructor;

import java.sql.Time;

/**
 * This Class Creates a SQLQuery which returns all information
 * for a given clientID
 */
public abstract class SQLEdit extends SQLQuery {
    //fields
    protected String patientID;

    public SQLEdit(String patientID){
        super();
        this.patientID = patientID;
    }
    public String getPatientID(){
        return patientID;
    }

}
