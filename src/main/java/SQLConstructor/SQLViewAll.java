package SQLConstructor;

public class SQLViewAll {
        //fields
        String patientID;

        public SQLViewAll(String patientID){
            this.patientID = patientID;
        }

        public String getSQL(){
            String sqlStr;
            sqlStr = "SELECT *" + " FROM " + "patient_"+ patientID + ";";
            return sqlStr;
        }
        public String getPatientID(){
            return patientID;
        }

}
