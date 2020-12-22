package SQLConstructor;
import java.sql.Time;

public class SQLEditClinician extends SQLEdit{
    private String comment;
    private double glucose_manual;
    private double lactate_manual;
    private double sodium_manual;
    private double potassium_manual;
    private Time time;

    public SQLEditClinician(String patientID, String comment, double glucose_manual, double lactate_manual, double sodium_manual, double potassium_manual){
        super(patientID);



    }



}
