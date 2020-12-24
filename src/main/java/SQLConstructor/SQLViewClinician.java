package SQLConstructor;

public class SQLViewClinician implements Getable{
    //fields
    String patientID;
    String type = "View";

    public SQLViewClinician(String patientID){

        this.patientID = patientID;
    }

    @Override
    public String getSQL(){
        String sqlStr;
        sqlStr = "SELECT *" + " FROM " + "patient_"+ patientID + ";";
        return sqlStr;
    }

    public String getPatientID(){
        return patientID;
    }

    public String getType(){
        return type;
    }
}
