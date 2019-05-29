
import java.io.IOException;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;

import org.json.JSONException;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserDataService {

    @WebMethod
    public User createUser(@WebParam(name = "userId")  @XmlElement(name = "userId", required = false) int id,@WebParam(name = "name")  @XmlElement(name = "name", required = true) String name, @WebParam(name = "lastName") @XmlElement(name = "lastName", required = true) String lastName,@WebParam(name = "balance") @XmlElement(name = "balance", required = false) int balance, @WebParam(name = "courseId") @XmlElement(name = "courseId", required = false) int courseId) throws IOException, JSONException;
    @WebMethod
    public String deleteUser(@WebParam(name = "userId") @XmlElement(name = "userId", required = false) int id);      
    @WebMethod
    public User updateUser(@WebParam(name = "userId") @XmlElement(name = "userId", required = true) int id, @WebParam(name = "user") @XmlElement(name = "user", required = true)  User user);
    @WebMethod
    public User getUser(@WebParam(name = "userId") @XmlElement(name = "userId", required = true) int id);
    @WebMethod
    public ArrayList<User> searchUserBalanceObject(@WebParam(name = "balance") @XmlElement(name = "balance", required = true) int balance);
    @WebMethod
    public User addCourse(@WebParam(name = "UserId") @XmlElement(name = "UserId", required = true) int id, @WebParam(name = "CourseId") @XmlElement(name = "CourseId", required = true) int buy) throws IOException, JSONException;
    @WebMethod
    public ArrayList<User> searchUserNameObject(@WebParam(name = "name") @XmlElement(name = "name", required = true) String name);
    @WebMethod
    public Object searchUserName (@WebParam(name = "name") @XmlElement(name = "name", required = true) String name);   
}