package JSONObjects;

public class SQLViewClinician extends SQLQuery {
    //fields
    protected int patientID;

    public SQLViewClinician(int patientID){
        _type = "ViewClinician";
        this.patientID = patientID;
    }

    @Override
    public String getSQL(){
        String sqlStr;
        sqlStr = "SELECT patient_id, date, time, potassium, sodium, lactate, " +
                "glucose, sodium_input, lactate_input, glucose_input, " +
                "event_type, comments, prescription" + " FROM " + "patients WHERE patient_id = "+ patientID + ";";
        return sqlStr;
    }

    public int getPatientID(){
        return patientID;
    }

    public String get_type(){
        return _type;
    }
}
