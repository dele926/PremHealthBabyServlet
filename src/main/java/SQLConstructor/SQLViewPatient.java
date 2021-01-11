package SQLConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLViewPatient extends SQLView implements Executeable{
        //fields
        int patientID;

        public SQLViewPatient(int patientID){
            super();
            this.patientID = patientID;
            _type = "ViewPatient";
            sqlStr = "SELECT *" + " FROM " + "patients WHERE patient_id = "+ patientID + ";";
        }

        //access methods
        public int getPatientID(){
            return patientID;
        }

}
