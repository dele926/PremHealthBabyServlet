package ReturnObjects;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import java.util.List;

public class Patient {
    public Patient(ResultSet rset) {
    }

    public Map<String, Object>  resultSetToList(ResultSet rs) throws SQLException{
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        ArrayList<String> date = new ArrayList<String>();
        ArrayList<String> time = new ArrayList<String>();
        ArrayList<String> potassium = new ArrayList<String>();
        ArrayList<String> sodium = new ArrayList<String>();
        ArrayList<String> lactate = new ArrayList<String>();
        ArrayList<String> glucose = new ArrayList<String>();
        ArrayList<String> potassium_input = new ArrayList<String>();
        ArrayList<String> sodium_input = new ArrayList<String>();
        ArrayList<String> lactate_input = new ArrayList<String>();
        ArrayList<String> glucose_input = new ArrayList<String>();
        ArrayList<String> event_type = new ArrayList<String>();
        ArrayList<String> comments = new ArrayList<String>();
        ArrayList<String> prescription = new ArrayList<String>();
        ArrayList<String> filter_type = new ArrayList<String>();

        while (rs.next()){ // resultset maintains cursor and it initally points before first row
            date.add(rs.getString("date"));
            time.add(rs.getString("time"));
            potassium.add(rs.getString("potassium"));
            sodium.add(rs.getString("sodium"));
            lactate.add(rs.getString("lactate"));
            glucose.add(rs.getString("glucose"));
            potassium_input.add(rs.getString("potassium_input"));
            sodium_input.add(rs.getString("sodium_input"));
            lactate_input.add(rs.getString("lactate_input"));
            glucose_input.add(rs.getString("glucose_input"));
            event_type.add(rs.getString("event_type"));
            comments.add(rs.getString("comments"));
            prescription.add(rs.getString("prescription"));
            filter_type.add(rs.getString("filter_type"));
        }
        Map<String, Object> info = new HashMap<>();
        info.put("date", date);
        info.put("time", time);
        info.put("potassium",potassium);
        info.put("sodium",sodium);
        info.put("lactate", lactate);
        info.put("glucose", glucose);
        info.put("potassium_input",potassium_input);
        info.put("sodium_input",sodium_input);
        info.put("lactate_input", lactate_input);
        info.put("glucose_input", glucose_input);
        info.put("event_type",event_type);
        info.put("comments",comments);
        info.put("prescription",prescription);
        info.put("filter_type",filter_type);

        return info;
    }
}
