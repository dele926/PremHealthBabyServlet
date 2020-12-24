package SQLConstructor;

public abstract class SQLQuery implements Getable {
    protected String type;

    public SQLQuery(){
    }

    public String getType() {
        return type;
    }

}
