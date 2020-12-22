import SQLConstructor.SQLView;
import org.junit.Assert;
import org.junit.Test;


public class TestSQLView {
    @Test
    public void testQueryConstruction(){
        SQLView sqlView = new SQLView("2342");
        Assert.assertEquals(sqlView.getSQL(), "SELECT * FROM patient_2342;");

    }
}
