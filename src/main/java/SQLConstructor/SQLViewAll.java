package SQLConstructor;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is used for to retrieve all inputted information regardless
 * of their patientID. It is used for Engineers to analyze the accuracy of the
 * device by comparing the device-measured values to manually-taken blood values
 */

public class SQLViewAll extends SQLView implements Executeable{

    public SQLViewAll(){
        super();
        _type = "ViewAll";
        sqlStr = "SELECT * FROM patients WHERE NOT potassium_input is NULL";
    }

}
