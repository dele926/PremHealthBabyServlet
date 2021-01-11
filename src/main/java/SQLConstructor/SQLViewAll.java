package SQLConstructor;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLViewAll extends SQLView implements Executeable{

    public SQLViewAll(){
        super();
        _type = "ViewAll";
        sqlStr = "SELECT time, patient_id, sodium, potassium, lactate, glucose, potassium_input, sodium_input, " +
                "lactate_input, glucose_input FROM patients WHERE NOT potassium_input is NULL";
    }

}
