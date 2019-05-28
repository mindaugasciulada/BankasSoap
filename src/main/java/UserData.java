import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
@WebService(targetNamespace="http://localhost/ws/user")

public class UserData implements UserDataService {
	private Map<Integer, User> users = new HashMap();
    private User context;

    public UserData() {
        List<User> usersArray = Arrays.asList(
                new User(1, "Tomas", "Kalinauskas", 1578),
                new User(2, "Martynas", "Buinauskas", 4540),
                new User(3, "Alvydaa", "Ramanauskaite", 6585),
                new User(4, "Agne", "Kavaliauskaite", 1578)
        );

        usersArray.forEach(user -> {this.users.put(user.getId(), user);
        });
    }
//rest
//    public void createUser(User user) {
//        user.setId(users.size() + 1);
//        users.put(user.getId(), user);
//    }
    
    //soap
    public User createUser(@WebParam(name = "name")  @XmlElement(name = "name", required = true) String name, @WebParam(name = "lastName") @XmlElement(name = "lastName", required = true) String lastName,@WebParam(name = "balance") @XmlElement(name = "balance", required = false) int balance) {
    	
    	User user = new User();
    	System.out.println(name);
    	user.setId(users.size() + 1);
        user.setName(name);
        user.setLastName(lastName);
        user.setBalance(balance);
        try {
        if ( user.getLastName().equals("?") || user.getName().equals("?")|| user.getBalance() == 0) {
        	 throw new SOAPFaultException(createSoapFault("403", "Data exception"));
        }}
        catch (SOAPFaultException e) {
        	throw e;
        };
        users.put(user.getId(), user);
		return user;
        }
        	
    public User updateUser(@WebParam(name = "userId") @XmlElement(name = "userId", required = true) int id, @WebParam(name = "user") @XmlElement(name = "user", required = true)  User user) {
        try {
        	
        if (getUser(id) == null) { 
        throw new SOAPFaultException(createSoapFault("404", "There is no such user"));
        }}
        catch (SOAPFaultException e) {
        	throw e;
        };    	
        user.setId(id);
        users.put(id, user);
        return user;
    }
    
    public String deleteUser(@WebParam(name = "userId") @XmlElement(name = "userId", required = false) int id) {
        try {
        	
        if (getUser(id) == null) { 
        throw new SOAPFaultException(createSoapFault("404", "There is no such user"));
        }}
        catch (SOAPFaultException e) {
        	throw e;
        };   
        users.remove(id);
        return "User deleted";
    }

    public User getUser(@WebParam(name = "userId") @XmlElement(name = "userId", required = true) int id) {
        try {
        	
        if (users.get(id) == null) { 
        throw new SOAPFaultException(createSoapFault("404", "There is no such user"));
        }}
        catch (SOAPFaultException e) {
        	throw e;
        };   
    	User user2 = users.get(id);
        return users.get(id);
    }
    
//    public User getCourses(int id) {
//    	User user2 = users.get(id);
//        return users.get(user2.getCourses());
//    }
    
//    @WebMethod(exclude = true)
    public int getSize() {
        int i = Integer.valueOf(users.size());
        return i;
    }
    
    public ArrayList<User> searchUserNameObject(@WebParam(name = "name") @XmlElement(name = "name", required = true) String name) {
       
            ArrayList<User> usersArray = new ArrayList<>();
            String reqName=name;
            String names = "";
            User[] userArray = new User[1];
            User user = getUser(1);
            for (int i = 1; i <= getSize(); i++) {
                user = getUser(i);
                if (user.getName().contains(reqName)){
                    names+=user.getName() + " ";
                    usersArray.add(user);
                }
            }
            return usersArray;  
    }
    
    public Object searchUserName (@WebParam(name = "name") @XmlElement(name = "name", required = true) String name){
    	  String reqName=name;
          String names = "";
    	    User user = getUser(1);
            for (int i = 1; i <= getSize(); i++) {
                user = getUser(i);
                if (user.getName().contains(reqName)){
                    names+=user.getName() + " ";
                }
            }
            try {
            if (names.equals("")) { 
            throw new SOAPFaultException(createSoapFault("404", "There is no user with such name '" + name+"'"));
            }}
            catch (SOAPFaultException e) {
            	throw e;
            };
            return names;
        }

    
    private SOAPFault createSoapFault (String reason, String description) {
        SOAPFault soapFault = null;
        try {
            soapFault = SOAPFactory.newInstance().createFault(
                    "Error : " + description,
                    new QName(reason)                
            );
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        return soapFault;
    }


    
    public ArrayList<User> searchUserBalanceObject(@WebParam(name = "balance") @XmlElement(name = "balance", required = true) int balance) {
    
    	ArrayList<User> usersArray = new ArrayList<>();
            int reqname = balance;
//            int reqName=request.params("balance");
            String names = "";
            User[] userArray = new User[1];
            User user = getUser(1);
            for (int i = 1; i <= getSize(); i++) {
                user = getUser(i);
                if (user.getBalance()== reqname){
                    names+=user.getName() + " ";

                    usersArray.add(user);
                }                
            }
            try {
            	
                if (usersArray.isEmpty()) { 
                throw new SOAPFaultException(createSoapFault("404", "There is no such user"));
                }}
                catch (SOAPFaultException e) {
                	throw e;
                };   
            
            return usersArray;
    }
    
    public User addCourse(@WebParam(name = "UserId") @XmlElement(name = "UserId", required = true) int id, @WebParam(name = "CourseId") @XmlElement(name = "CourseId", required = true) int buy) throws IOException, JSONException {
        String result="";
        
        User user = getUser(id);
        try {
        if (user == null) { 
            throw new SOAPFaultException(createSoapFault("404", "There is no such user"));
            }}
            catch (SOAPFaultException e) {
            	throw e;
            };   
        
        

//        try {
//            int id = Integer.valueOf(req.params("id"));
//            if (userData.get(id) == null) {
//                throw new Exception("No user found with id " + req.params("id"));
//            }
//
//        } catch(Exception e) {
//            res.status(HTTP_NOT_FOUND);
//            return new ErrorMessage(e);
//        }
//        System.out.println(userREQ.getBuy());
       
        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpGet getRequest = new HttpGet("http://172.30.1.140:81/api/courses/"+buy);
        HttpGet getRequest = new HttpGet("http://rest:3000/api/courses/"+buy);
        HttpResponse response = httpClient.execute(getRequest);

        // Check for HTTP response code: 200 = success
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
        }
        // Get-Capture Complete application/xml body response
        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        String output;
        while ((output = br.readLine()) != null) {
            result+=output;
        }
        respa respaa = JsonTransformer.fromJson(result, respa.class);
        user.setBalance(user.getBalance()-respaa.getPrice());
        
        user.setCourse(respaa);
        updateUser(user.getId(),user);
        return user;
    }
    
    public Object deleteCourse(@WebParam(name = "userId")  @XmlElement(name = "userId", required = true) int id, @WebParam(name = "CourseId") @XmlElement(name = "CourseId", required = true) int dd) throws IOException, JSONException {
        String result=""; 
        
        try {
            if (getUser(id) == null) { 
                throw new SOAPFaultException(createSoapFault("404", "There is no such user"));
                }}
                catch (SOAPFaultException e) {
                	throw e;
                };  
                User user = getUser(id); 
                System.out.println(user.getCourse(dd));
                try {
                    if (user.getCourse(dd)) { 
                    	user.delCourse(dd);
                        
                        } else {
                        	throw new SOAPFaultException(createSoapFault("404", "User doesn`t have this course"));

                        }                    
                }
                        catch (SOAPFaultException e) {
                        	throw e;
                        };        
                
                         
        
        return user;
    }
    
    public List<User> getAllUsers() {
        return users.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }
}

