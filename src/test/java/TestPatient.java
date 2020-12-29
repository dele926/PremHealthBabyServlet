import ReturnObjects.Patient;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestPatient {
    //Create mock objects of HttpServletRequest and Response
    @InjectMocks MyServlet conn;
    @Mock private Connection mockConnection;
    @Mock private Statement mockStatement;


    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        // initalizing all mock objects in this test class
    }

    @Test
    public void test() throws Exception{
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any()))
    }
}
