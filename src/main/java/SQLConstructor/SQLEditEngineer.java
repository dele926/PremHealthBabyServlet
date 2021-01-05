package SQLConstructor;

/**
 * The Engineer can update the filter method for one particular patient
 */

public class SQLEditEngineer extends SQLEdit implements Getable {
    //extra fields
    String newFilter;

    //constructor
    public SQLEditEngineer (int patientID, String newFilter){
        super(patientID);
        _type = "EditEngineer";
        this.newFilter = newFilter;
    }

    @Override
    public String getSQL(){
        String sqlStr;
        sqlStr = "UPDATE " + "patients" + " SET filter_type = " + newFilter +
                " WHERE patient_id = " + patientID + ";";
        return sqlStr;
    }

    public String getFilter() {
        return newFilter;
    }
}
