package SQLConstructor;

public class SQLView {
    //fields
    String patientID;

    public SQLView(String patientID){
        this.patientID = patientID;
    }

    public String getSQL(){
        String sqlStr;
        sqlStr = "SELECT *" + " FROM " + "patient_"+ patientID + ";";
        return sqlStr;
    }

    public String getPatientID(){
        return patientID;
    }
}
