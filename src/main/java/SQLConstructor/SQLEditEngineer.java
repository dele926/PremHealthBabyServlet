package SQLConstructor;

public class SQLEditEngineer extends SQLEdit{
    //extra fields
    String newfilter;

    //constructor
    public SQLEditEngineer (String patientID, String newfilter){
        super(patientID);
        type = "EditEngineer";
        this.newfilter = newfilter;
    }

    public String getSQL(){
        String sqlStr;
        sqlStr = "UPDATE " + "patient_" + patientID + " SET filter_type = " + newfilter +
                " WHERE patient_id = " + patientID + ";";
        return sqlStr;
    }

    public String getFilter() {
        return newfilter;
    }
}
