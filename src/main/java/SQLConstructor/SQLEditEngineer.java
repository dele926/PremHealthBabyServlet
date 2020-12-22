package SQLConstructor;

public class SQLEditEngineer extends SQLEdit{
    //extra fields
    String filter;

    //constructor
    public SQLEditEngineer (String patientID, String filter){
        super(patientID);
        this.filter = filter;
    }

    public String GetSQL(){
        String sqlStr;
        sqlStr = "UPDATE " + "patient_" + patientID + "SET filter = " + glucose_manual + ", potassium_manual = " +
                potassium_manual + ", sodium_manual = " + sodium_manual + ", lactate_manual = " + lactate_manual +
                " WHERE time = " + time + ",";
        return sqlStr;
    }

    public String getFilter() {
        return filter;
    }
}
