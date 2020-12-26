package SQLConstructor;

public class SQLQuery {

    //fields
    protected String type;

    //constructor, although you would never need to use this?
    public SQLQuery(){
        type = "None";
    }

    //
    public String getType() {
        return type;
    }

    public String getSQL() {
        return "No Query Found";
    }
}
