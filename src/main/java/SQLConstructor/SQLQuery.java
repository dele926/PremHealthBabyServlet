package SQLConstructor;

public abstract class SQLQuery {
    protected String type;

    public SQLQuery(String type){
        this.type = type;
    }
}
