package bank;

public class tut17{
    public static void main(String[] args){
        Account a1 = new Account();
        a1.name = "Ashesh";
        a1.email = "aashu@gmail.com";
        // a1.password = "!234656"; //Private not available
        a1.setPassword("210925y");
        a1.printInfo();
    }
}