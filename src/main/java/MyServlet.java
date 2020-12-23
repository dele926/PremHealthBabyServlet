import SQLConstructor.*;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.stream.Collectors;

//This declares this program to be a servlet
@WebServlet(urlPatterns = {"/patients"}, displayName = "Baby Health Servlet", loadOnStartup = 1)
public class MyServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String reqBody=req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        //the response sent back by the server will be a JSON
        //resp.setContentType("text/html");
        resp.setContentType("application/json");
        resp.getWriter().write(reqBody);
        /*
        Here's the SQL Query Part
         */
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        Connection conn = null;
        try {
            conn= DriverManager.getConnection(dbUrl);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            Statement s=conn.createStatement();
            Gson gson = new Gson();
            SQLQuery initQuery = gson.fromJson(reqBody,SQLQuery.class);
            if (initQuery.getType() == "EditClinician") {
                SQLEditClinician query = gson.fromJson(reqBody,SQLEditClinician.class);
            }
            else if (initQuery.getType() == "EditEngineer") {
                SQLEditEngineer query = gson.fromJson(reqBody, SQLEditEngineer.class);
            }
            else if (initQuery.getType() == "EditPhysician") {
                SQLEditPhysician query = gson.fromJson(reqBody, SQLEditPhysician.class);
            }
            else if (initQuery.getType() == "EditClinician") {
                SQLEditClinician query = gson.fromJson(reqBody, SQLEditClinician.class);
            }
            else if (initQuery.getType() == "ViewAll") {
                SQLViewAll query = gson.fromJson(reqBody, SQLViewAll.class);
            }
            System.out.println(query.getSQL());
            ResultSet rset=s.executeQuery(query.getSQL());
            Query returnquery = new Query("2342", "glucose");
            String jsonString = gson.toJson(returnquery);
            resp.getWriter().write(jsonString);
            //rset.close();
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
        resp.setContentType("application/json"); //setting type of response
//        resp.getWriter().write("This Servlet is working!"); //writing hello world to response
//        resp.getWriter().write("<title>Servlet for Premature Baby Health Monitoring</title>");
        Gson gson = new Gson();
        Query returnquery = new Query("2342", "glucose");
        String jsonString = gson.toJson(returnquery);
        resp.getWriter().write(jsonString);
        System.out.print(jsonString);
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
    }


}
