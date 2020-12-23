import SQLConstructor.SQLEditEngineer;
import SQLConstructor.SQLViewAll;
import SQLConstructor.SQLViewEngineer;
import org.junit.Assert;
import org.junit.Test;


public class TestSQLViewAll {
    @Test
    public void testViewConstruction() {
        SQLViewAll sqlView = new SQLViewAll("2342");
        Assert.assertEquals(sqlView.getSQL(), "SELECT * FROM patient_2342;");

    }

    @Test
    public void testEngineerView() {
        String sql = SQLViewEngineer.getSQL();
        Assert.assertEquals(sql, "SELECT");

    }
}
