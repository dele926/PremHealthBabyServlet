package SQLConstructor;

public class SQLQuery {

    //fields
    protected String _type = "None";
    protected String sqlStr = "Null";

    public SQLQuery(){
    }

    public String get_type() {
        return _type;
    }

    public String getSQL() {
        return "No Query Found";
    }
}
