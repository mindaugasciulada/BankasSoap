import javax.jws.WebService;
import javax.xml.ws.Endpoint;

public class SOAPPublisher {

    public static void main(String[] args) {
        UserData userData = new UserData();

        Endpoint.publish("http://localhost:5001/ws/user", userData);

    }

}
