package take5;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Response {

    private List<Row> response;

    public Response(List<Row> response) {
        this.response = response;
    }

    public Response() {
    }

    public List<Row> getResponse() {
        return response;
    }

    public void setResponse(List<Row> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Response{" +
                "response=" + response +
                '}';
    }
}
