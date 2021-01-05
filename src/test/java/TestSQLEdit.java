import SQLConstructor.SQLEditClinician;
import SQLConstructor.SQLEditPhysician;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Time;

public class TestSQLEdit {
    /**
    @Test
    public void testEngineerEdit() {
        SQLEditEngineer sqlEditEngineer = new SQLEditEngineer("2342", "Sliding_Frame");
        Assert.assertEquals(sqlEditEngineer.getSQL(), "UPDATE patient_2342 SET filter_type = Sliding_Frame WHERE" +
                " patient_id = 2342;");
    }
     **/

    @Test
    public void testClinicianEdit(){
        SQLEditClinician query = new SQLEditClinician(2342, "Test Comment", 7.0, 7.0,
                7.0, 7.0, "test event", Time.valueOf("08:00:08"));
        Assert.assertEquals(query.getSQL(), "UPDATE patients SET glucose_input = 7.0, potassium_input = 7.0, " +
                "sodium_input = 7.0, lactate_input = 7.0, event_type = 'test event', comments = 'Test Comment' " +
                "WHERE time = '08:00:08' AND patient_id = 2342;");

    }

    @Test
    public void testPhysicianEdit(){
        SQLEditPhysician query = new SQLEditPhysician(2342, "test comment", 7.0,
                7.0, 7.0, 7.0, Time.valueOf("08:00:08"),"prescription",
                "this is the prescription");
        Assert.assertEquals(query.getSQL(), "UPDATE patients SET glucose_manual = 7.0, potassium_manual = 7.0, " +
                "sodium_manual = 7.0, lactate_manual = 7.0 prescription = 'this is the prescription', comments = 'test comment' " +
                "WHERE time = '08:00:08' AND patient_id = 2342;");
    }
}
