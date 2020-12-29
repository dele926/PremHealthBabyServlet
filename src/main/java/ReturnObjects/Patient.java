package ReturnObjects;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import java.util.List;

public class Patient {
    public Patient(ResultSet rset) {
    }

    public Map<String, Object>  resultSetToList(ResultSet rs) throws SQLException{
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        ArrayList<String> time = new ArrayList<String>();
        ArrayList<String> lactate = new ArrayList<String>();
        while (rs.next()){ // resultset maintains cursor and it initally points before first row
            time.add(rs.getString("time"));
            lactate.add(rs.getString("lactate"));
        }
        Map<String, Object> info = new HashMap<>();
        info.put("time", time);
        info.put("lactate",lactate);

        return info;
    }
}
