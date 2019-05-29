import java.io.Serializable;

public class respa implements Serializable {
    private static final long serialVersionUID = -557757908121807034L;
    private int id;
    private String name;
    private String active;
    private int price;
    
    public respa() {
//    	id=1;
//    	name="labas";
//    	active="true";
//    	price = 10;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setPrice(int price) {
        this.price = price;    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getActive() {
        return active;
    }
    public int getPrice() {
        return price;
    }
    

}