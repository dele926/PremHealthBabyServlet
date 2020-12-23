package ReturnObjects;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {
    public Group(ResultSet rset) {
    }

    public List resultSetToList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String,Object>> list = new ArrayList<>();
        while (rs.next()){ // resultset maintains cursor and it initally points before first row
            Map<String,Object> row = new HashMap<>(columns);
            for (int i=1 ; i<= columns; ++i){
                if (rs.getObject("potassium_manual") != "null") {
                    // getObject retrives column values from current row - index/ column name
                    row.put(md.getColumnName(i), rs.getObject(i));
                }
            }
            list.add(row);
        }
        return list;
    }

}
