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

//This declares this program to be a servlet
@WebServlet(urlPatterns = {"/patients"}, displayName = "Baby Health Servlet", loadOnStartup = 1)
public class MyServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        //the response sent back by the server will be a JSON
        resp.setContentType("application/json");
        //Why does this response show up on my server?
        resp.getWriter().write("Hello, world!");
    }
}
