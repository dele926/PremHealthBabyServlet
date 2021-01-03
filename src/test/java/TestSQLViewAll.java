import SQLConstructor.*;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;


public class TestSQLViewAll {
/**
    @Test
    public void testViewConstruction() {
        //SQLViewAll sqlView = new SQLViewAll("2342");
        //Assert.assertEquals(sqlView.getSQL(), "SELECT * FROM patient_2342;");
        SQLViewClinician original = new SQLViewClinician("2342");
        Gson gson = new Gson();
        String reqBody = gson.toJson(original);
        SQLQuery query = gson.fromJson(reqBody, SQLQuery.class);
        Assert.assertEquals("ViewClinician", query.get_type());
        //Assert.assertEquals("SELECT * FROM patient_2342;", query.getSQL());

    }


    @Test
    public void testEngineerView() {
        SQLViewEngineer sqlViewEngineer = new SQLViewEngineer();
        String sql = sqlViewEngineer.getSQL();
        Assert.assertEquals(sql, "SELECT time, patient_id, sodium, potassium, lactate, glucose, " +
                "potassium_input, sodium_input, lactate_input, glucose_input FROM patient_2342 WHERE NOT " +
                "potassium_input is NULL UNION ALL SELECT time, patient_id, sodium, potassium, lactate, " +
                "glucose, potassium_input, sodium_input, lactate_input, glucose_input FROM patient_2343 " +
                "WHERE NOT potassium_input is NULL UNION ALL SELECT time, patient_id, sodium, potassium, " +
                "lactate, glucose, potassium_input, sodium_input, lactate_input, glucose_input FROM patient_2344 " +
                "WHERE NOT potassium_input is NULL");

    }
**/
}
