package SQLConstructor;
import java.sql.Time;

/**
 * This Class Creates a SQLQuery which returns all information
 * for a given clientID
 */
public abstract class SQLEdit {
    //fields
    protected String patientID;

    public SQLEdit(String patientID){
        this.patientID = patientID;
    }

    protected String getPatientID(){
        return patientID;
    }

}
