import javax.jws.WebService;
import javax.xml.ws.Endpoint;

public class SOAPPublisher {

    public static void main(String[] args) {
        UserData userData = new UserData();
//sadfsfasu
        Endpoint.publish("http://localhost:5000/ws/user", userData);

    }

}
