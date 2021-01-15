import ReturnObjects.Group;
import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.Map;
import java.util.HashMap;


import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * The TestGroup ensures that the first column of the map object returned contains patientID and to ensure that the list
 * that comes with the patientID contains a patientID 2322
 */

public class TestGroup {
    @Mock
    ResultSet rset;

    @Test
    public void testResulttolist(){
        try {
            createList();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Group group = new Group (rset);
        Map<String, Object> results = new HashMap<>();
        try {
            results = group.resultSetToList(rset);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Map.Entry<String,Object> entry = results.entrySet().iterator().next();
        String key = entry.getKey();
        String value = entry.getKey();

        assertEquals(key,"patientID");
        Assert.assertTrue(value.contains("2322"));


    }

    private void createList() throws SQLException{
        Mockito.when(rset.next()).thenReturn(true).thenReturn(false);
        Mockito.when(rset.getString("patientID"));

    }
}
