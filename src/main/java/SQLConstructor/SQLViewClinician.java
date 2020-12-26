package SQLConstructor;

public class SQLViewClinician extends SQLQuery {
    //fields
    String patientID;
    String type = "ViewClinician";

    public SQLViewClinician(String patientID){

        this.patientID = patientID;
    }

    @Override
    public String getSQL(){
        String sqlStr;
        sqlStr = "SELECT patient_id, date, time, potassium, sodium, lactate, " +
                "glucose, sodium_input, lactate_input, glucose_input, " +
                "event_type, comments, prescription" + " FROM " + "patient_"+ patientID + ";";
        return sqlStr;
    }

    public String getPatientID(){
        return patientID;
    }

    public String getType(){
        return type;
    }
}
