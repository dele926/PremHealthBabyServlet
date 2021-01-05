package SQLConstructor;

public class SQLViewAll extends SQLQuery {
        //fields
        int patientID;

        public SQLViewAll(int patientID){
            super();
            this.patientID = patientID;
            _type = "ViewAll";
        }

        @Override
        public String getSQL(){
            String sqlStr;
            sqlStr = "SELECT *" + " FROM " + "patients WHERE patient_id = "+ patientID + ";";
            return sqlStr;
        }
        public int getPatientID(){
            return patientID;
        }

}
