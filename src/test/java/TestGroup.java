import ReturnObjects.Group;
import ReturnObjects.Patient;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.Map;
import java.util.HashMap;


import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

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
