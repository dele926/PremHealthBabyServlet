package SQLConstructor;

public class SQLViewEngineer extends SQLEdit implements Getable{

    public SQLViewEngineer(){
        super("2342,2343,2344");
        type = "ViewEngineer";
    }

    @Override
    public String getSQL(){
        String sqlStr = "";
        for (int ID = 2342; ID <= 2344; ID++) {
            sqlStr = (sqlStr + "SELECT time, patient_id, sodium, potassium, lactate, glucose, potassium_input, sodium_input, " +
                    "lactate_input, glucose_input FROM " + "patient_" + ID + " WHERE NOT potassium_input is NULL");
            if (ID != 2344) {
                sqlStr = (sqlStr + " UNION ALL ");
            }
        }
        return sqlStr;
    }
}
