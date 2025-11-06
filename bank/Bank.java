package bank;
import static utils.InputUtils.*;

//Access Modifier

class Account{
    public String name;
    protected String email;
    private String password;
    public void setPassword(String pass){
        this.password = pass;
    }
    public void printInfo(){
        print("Name: " + this.name + " Email: " + this.email + " Password: " + this.password);
    }
}

public class Bank {
    public String name;
    protected String email;
    String number;
    private String password;
    public void setPassword(String pass){
        this.password = pass;
    }
    public void printInfo(){
        print("Name: " + this.name + " Email: " + this.email + " Number: " + this.number + " Password: " + this.password);
    }
    public static void main(String [] args){
        Account a1 = new Account();
        a1.name = "Aashu";
        a1.email = "aashu@gmail.com from Bank.java";
        // a1.password = "!234675"; //Private not available
        a1.setPassword("123475");
        a1.printInfo();
    }
}
