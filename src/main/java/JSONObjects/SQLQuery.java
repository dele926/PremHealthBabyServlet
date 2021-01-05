package JSONObjects;

public class SQLQuery {

    //fields
    protected String _type;

    //constructor, although you would never need to use this?
    public SQLQuery(){
        _type = "None";
    }

    //
    public String get_type() {
        return _type;
    }

    public String getSQL() {
        return "No Query Found";
    }
}
