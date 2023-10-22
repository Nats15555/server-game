package connectDescription.jsonDickts;

import java.util.Map;

public class AnswerDict {
    public String method;
    public String status;
    public Map<String, String> fields;

    public AnswerDict(String method, String status, Map<String, String> fields) {
        this.method = method;
        this.status = status;
        this.fields = fields;
    }
}
