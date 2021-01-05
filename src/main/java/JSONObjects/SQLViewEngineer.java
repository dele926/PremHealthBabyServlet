package JSONObjects;

public class SQLViewEngineer extends SQLQuery {

    public SQLViewEngineer(){
        super();
        _type = "ViewEngineer";
    }

    @Override
    public String getSQL(){
        String sqlStr = "SELECT time, patient_id, sodium, potassium, lactate, glucose, potassium_input, sodium_input, " +
                    "lactate_input, glucose_input FROM patients WHERE NOT potassium_input is NULL";
        return sqlStr;
    }
}
