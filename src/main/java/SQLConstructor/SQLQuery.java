package SQLConstructor;

/**
 * Superclass for all other Constructors
 * Two fields: sqlStr and _type are inherited amongst all class
 * _type is declared in every subclass so that when the SQLQuery is read
 * by the servlet, the servlet knows which type of object to convert the
 * JSONString into
 */

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
