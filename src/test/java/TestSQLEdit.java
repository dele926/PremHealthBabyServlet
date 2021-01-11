import SQLConstructor.SQLEditClinician;
import SQLConstructor.SQLEditEngineer;
import SQLConstructor.SQLEditPhysician;
import SQLConstructor.SQLQuery;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class TestSQLEdit {

    @Test
    public void testEditClinician(){
        SQLEditClinician query = new SQLEditClinician(2342, "Test Comment", 7.0, 7.0,
                7.0, 7.0, "test event", Time.valueOf("08:00:08"));
        Assert.assertEquals("UPDATE patients SET glucose_input = 7.0, potassium_input = 7.0, " +
                "sodium_input = 7.0, lactate_input = 7.0, event_type = 'test event', comments = 'Test Comment' " +
                "WHERE time = '08:00:08' AND patient_id = 2342;", query.getSQL());

    }


    @Test
    public void testEditPhysician(){
        SQLEditPhysician query = new SQLEditPhysician(2342, "test comment", 7.0,
                7.0, 7.0, 7.0, Time.valueOf("08:00:08"),"prescription",
                "this is the prescription");
        Assert.assertEquals("UPDATE patients SET glucose_manual = 7.0, potassium_manual = 7.0, " +
                "sodium_manual = 7.0, lactate_manual = 7.0 prescription = 'this is the prescription', comments = 'test comment' " +
                "WHERE time = '08:00:08' AND patient_id = 2342;", query.getSQL());
    }

    @Test
    public void testEditEngineer(){
        SQLEditEngineer query = new SQLEditEngineer(2342, "Sliding Window");
        Assert.assertEquals("UPDATE patients SET filter_type = 'Sliding Window' WHERE patient_id = 2342;", query.getSQL());
    }

    /*
    @Test
    public void testEditExecute() throws SQLException {
        String dbUrl = "jdbc:postgresql://ec2-34-194-198-238.compute-1.amazonaws.com:5432/d5o0sajebkt8h3";
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        Connection conn = null;
        try {
            conn= DriverManager.getConnection(dbUrl, "sycqsrtspaehfa", "dc02d39d3fcb5602eb6c4cef062954511ebc2641c7d85ca4a1b8b88fe563f116");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Statement s=conn.createStatement();
        SQLEditEngineer query = new SQLEditEngineer(2342, "Sliding Window");
        ResultSet rset = null;
        rset = query.execute(s);
        Gson gson = new Gson();
        String results = gson.toJson(rset);
        Assert.assertEquals("NOT SURE", results);
    }

     */

}
