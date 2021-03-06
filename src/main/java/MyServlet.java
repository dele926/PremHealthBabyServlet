import ReturnObjects.*;
import SQLConstructor.*;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Servlet declares a doPost and a doGet Method
 * doPost primarily handles Edit requests whereas doGet exclusively handles View requests
 * However, View requests are also executeable by doPost
 */

@WebServlet(urlPatterns = {"/patients"}, displayName = "Baby Health Servlet", loadOnStartup = 1)
public class MyServlet extends HttpServlet{
    @Override
    //The DoPost Method edits the database and sends an updated information back to client
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        //Setup
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(reqBody);
        resp.setContentType("application/json");
        resp.getWriter().write(reqBody);
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

        //SQL Execution
        try {
            Statement s=conn.createStatement();
            Gson gson = new Gson();
            /*
            Constructs the superclass object SQLQuery from the request
            which type of command the client is sending to us
             */
            SQLQuery initquery = gson.fromJson(reqBody, SQLQuery.class);
            ResultSet rset = null;
            Map<String, Object> results = new HashMap<>();
            if (initquery.get_type().equals("EditClinician")) {
                SQLEditClinician query = gson.fromJson(reqBody,SQLEditClinician.class);
                rset=query.execute(s);
                Patient patient = new Patient (rset);
                //create new patient object where the info from the sql query will be stored to be returned to android client
                results = patient.resultSetToList(rset);
            }
            else if (initquery.get_type().equals("EditEngineer")) {
                SQLEditEngineer query = gson.fromJson(reqBody, SQLEditEngineer.class);
                rset=query.execute(s);
                Patient patient = new Patient (rset);
                results = patient.resultSetToList(rset);
            }
            else if (initquery.get_type().equals("EditPhysician")) {
                SQLEditPhysician query = gson.fromJson(reqBody, SQLEditPhysician.class);
                rset=query.execute(s);
                Patient patient = new Patient (rset);
                results = patient.resultSetToList(rset);
            }
            else if (initquery.get_type().equals("ViewPatient"))
            {
                SQLViewPatient query = gson.fromJson(reqBody,SQLViewPatient.class);
                rset=query.execute(s);
                Patient patient = new Patient (rset);
                results = patient.resultSetToList(rset);
            }
            else if (initquery.get_type().equals("ViewAll"))
            {
                SQLViewAll query = gson.fromJson(reqBody, SQLViewAll.class);
                rset=query.execute(s);
                Group group = new Group (rset);
                results = group.resultSetToList(rset);
            }
            //if the request is not a SQLConstructor class or not any of the classes declared above
            //the system prints out the _type field (if there is one)
            else System.out.println("Type is " + initquery.get_type() + " AND Request Did Not Work");
            String jsonString = gson.toJson(results);
            resp.getWriter().write(jsonString);
            rset.close();
            s.close();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //Setup
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        resp.setContentType("application/json");
        resp.getWriter().write(reqBody);
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

        //Carrying out SQL
        try {
            Statement s = conn.createStatement();
            Gson gson = new Gson();
            //Takes in Initial Query in the superclass InitQuery. This is used to identify
            //which type of command the client is sending to us
            SQLQuery initquery = gson.fromJson(reqBody, SQLQuery.class);
            ResultSet rset = null;
            Map<String, Object> results = new HashMap<>();
            if (initquery.get_type().equals("ViewPatient"))
            {
                SQLViewPatient query = gson.fromJson(reqBody,SQLViewPatient.class);
                rset=query.execute(s);
                Patient patient = new Patient (rset);
                results = patient.resultSetToList(rset);
            }
            else if (initquery.get_type().equals("ViewAll"))
            {
                SQLViewAll query = gson.fromJson(reqBody, SQLViewAll.class);
                rset=query.execute(s);
                Group group = new Group (rset);
                results = group.resultSetToList(rset);
            }
            String jsonString = gson.toJson(results); // RETURN THIS
            resp.getWriter().write(jsonString);
            rset.close();
            s.close();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
