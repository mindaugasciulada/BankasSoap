import javax.jws.WebService;
import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String[] args) {
        UserData userData = new UserData();
        //asdhugytsdaugfysdgbcvre
        //dasfasdfasd
        Endpoint.publish("http://localhost:5000/ws/user", userData);

    }

}
