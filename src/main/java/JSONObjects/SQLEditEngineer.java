package JSONObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The Engineer can update the filter method for one particular patient
 */

public class SQLEditEngineer extends SQLEdit implements Gettable, Executeable{
    //extra fields
    String newFilter;
    String sqlStr = "";

    //constructor
    public SQLEditEngineer (int patientID, String newFilter){
        super(patientID);
        _type = "EditEngineer";
        this.newFilter = newFilter;
    }

    @Override
    public String getSQL(){
        sqlStr = "UPDATE " + "patients" + " SET filter_type = " + newFilter +
                " WHERE patient_id = " + patientID + ";";
        return sqlStr;
    }

    @Override
    public ResultSet execute(Statement s) throws SQLException {
        //carrying out Edit
        System.out.println("The SQL Query Is " + sqlStr);
        try {
            s.executeUpdate(sqlStr);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //Returning updated patient
        SQLViewAll viewAll = new SQLViewAll(patientID);
        ResultSet rset=s.executeQuery(viewAll.getSQL());
        return rset;
    }

    public String getFilter() {
        return newFilter;
    }


}
