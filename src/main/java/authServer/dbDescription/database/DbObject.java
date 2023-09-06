package authServer.dbDescription.database;

public class DbObject<T extends DataBaseTableUnit> {
    private T Obj;
    private String objName;

    public void setObj(T obj) {
        Obj = obj;
        objName = Obj.getUnitName();
    }

    public T getObj() {
        return Obj;
    }

    public String getObjName() {
        return objName;
    }
}
