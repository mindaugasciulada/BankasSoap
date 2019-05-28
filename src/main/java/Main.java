import javax.jws.WebService;
import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String[] args) {
        UserData userData = new UserData();
        
        Endpoint.publish("http://0.0.0.0:5000/ws/user", userData);

    }

}
