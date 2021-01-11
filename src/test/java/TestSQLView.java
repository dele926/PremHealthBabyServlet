import SQLConstructor.*;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;


public class TestSQLView {

    @Test
    public void testViewALL(){
        SQLViewAll query = new SQLViewAll();
        Assert.assertEquals("SELECT time, patient_id, sodium, potassium, lactate, glucose, potassium_input, sodium_input, " +
               "lactate_input, glucose_input FROM patients WHERE NOT potassium_input is NULL", query.getSQL());
        Assert.assertEquals("ViewAll", query.get_type());
    }

    @Test
    public void testViewPatient() {
        SQLViewPatient query = new SQLViewPatient(2342);
        Assert.assertEquals("SELECT * FROM patients WHERE patient_id = 2342;", query.getSQL());
        Assert.assertEquals("ViewPatient", query.get_type());
    }

}
