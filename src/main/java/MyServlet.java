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
        resp.getWriter().write("Thank you Client!");
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
            Query query = gson.fromJson(reqBody,Query.class);
            String sqlStr = "SELECT " + query.dataRequested + ", time FROM " + "patient_"+ query.patientID + ";";
            System.out.println(sqlStr);
            ResultSet rset=s.executeQuery(sqlStr);
            while(rset.next()){
                resp.getWriter().write(rset.getDouble("glucose")+" "+ rset.getTime("time") + "\n");
            }
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
        resp.setContentType("text/html"); //setting type of response
        resp.getWriter().write("This Servlet is working!"); //writing hello world to response
        resp.getWriter().write("<title>Servlet for Premature Baby Health Monitoring</title>");
        System.out.print(req.getServletPath());
    }


}
