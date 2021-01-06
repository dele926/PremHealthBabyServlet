import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This code tests if the correct response is outputted
 * when the request is sent


public class TestServlet {
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testServlet() throws IOException, ServletException{
        //HttpServletRequest request = mock(HttpServletRequest.class);
        //HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getReader().lines().collect(Collectors.joining(System.lineSeparator()))).thenReturn("{\"sqlStr\":\"UPDATE patients SET comments \u003d \u0027this is EditOne\u0027 WHERE time \u003d \u002700:00:00\u0027 AND patient_ID \u003d 2342;\",\"patientID\":2342,\"_type\":\"EditOne\"}");
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        MyServlet myServlet = new MyServlet();
        myServlet.doPost(request, response);
        String output=stringWriter.getBuffer().toString();
        Assert.assertEquals(output,"{\"date\":[\"2012-01-20\"],\"glucose\":[\"2.607\"],\"potassium\":[\"5.537\"],\"comments\":[\"this is EditOne\"],\"sodium_input\":[null],\"lactate_input\":[null],\"potassium_input\":[null],\"glucose_input\":[null],\"sodium\":[\"143.153\"],\"event_type\":[null],\"prescription\":[null],\"filter_type\":[\"Savitzky–Golay filter \"],\"patient_id\":[\"2342\"],\"time\":[\"00:00:00\"],\"lactate\":[\"0.589\"]}");
    }


}

 **/
