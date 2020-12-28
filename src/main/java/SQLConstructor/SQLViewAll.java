package SQLConstructor;

public class SQLViewAll extends SQLQuery {
        //fields
        String patientID;

        public SQLViewAll(String patientID){
            super();
            this.patientID = patientID;
            _type = "ViewAll";
        }

        @Override
        public String getSQL(){
            String sqlStr;
            sqlStr = "SELECT *" + " FROM " + "patient_"+ patientID + ";";
            return sqlStr;
        }
        public String getPatientID(){
            return patientID;
        }

}