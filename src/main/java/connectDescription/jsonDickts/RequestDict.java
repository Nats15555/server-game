package connectDescription.jsonDickts;

import java.util.Map;

public class RequestDict {
    public String method;
    public Map<String, String> fields;

    public RequestDict(String method, Map<String, String> fields) {
        this.method = method;
        this.fields = fields;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }
}
