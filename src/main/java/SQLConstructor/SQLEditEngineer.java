package SQLConstructor;

/**
 * The Engineer can update the filter method for one particular patient
 */

public class SQLEditEngineer extends SQLEdit {
    //extra fields
    String newfilter;

    //constructor
    public SQLEditEngineer (String patientID, String newfilter){
        super(patientID);
        _type = "EditEngineer";
        this.newfilter = newfilter;
    }

    @Override
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
