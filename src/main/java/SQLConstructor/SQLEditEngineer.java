package SQLConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Used by engineers to update the filter method for one particular patient
 */

public class SQLEditEngineer extends SQLEdit implements Executeable{
    //extra fields
    protected String newFilter;

    //constructor
    public SQLEditEngineer (int patientID, String newFilter){
        super(patientID);
        _type = "EditEngineer";
        this.newFilter = newFilter;
        sqlStr = "UPDATE " + "patients" + " SET filter_type = \'" + newFilter +
                "\' WHERE patient_id = " + patientID + ";";
    }

    public String getSQL(){
        return sqlStr;
    }

    //Additional access Methods
    public String getFilter() {
        return newFilter;
    }


}
