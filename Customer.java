import java.io.* ; // IMPORT ALL INPUT OUTPUT utilities
import java.lang.*;
public class Customer extends Person {
    private int customerID;
    private String dateOfArrival;
    private String password;
    private String roomType;
    private Invoice expenses;

    public Customer() {
        customerID=0;
        dateOfArrival="-";
        password="-";
        roomType="-";
        expenses=new Invoice();
    }
    public Customer(String fname, String lname, String gender, int custID, String DoA, String pswd,float roomCharges,String rType) {
        setFirstName(fname);
        setLastName(lname);
        setGender(gender);
        customerID=custID;
        dateOfArrival=DoA;
        password=pswd;
        roomType=rType;
        expenses=new Invoice(roomCharges,+15);// set the room charges based on room selected by customer
        // provide a random service charges applied to customer
    }
    public void setPassword(String pswd)
    {
        password=pswd;
    }
    public int getCustomerID()
    {
        return  customerID;
    }
    public String getPassword()
    {
        return  password;
    }
    public String getDateOfArrival()
    {
        return  dateOfArrival;
    }
    public void printDetails()
    {

        System.out.print("\n\t\t        Customer ID: " + customerID +"\t\t\t ");

        System.out.print("\n\t\t      First Name: " + getFirstName());
        System.out.print("\n\t\t       Last Name: " + getLastName());
        System.out.print("\n\t\t          Gender: " + getGender());
        System.out.print("\n\t\tAccount Password: " + password);
        System.out.print("\n\t\t Date Of Arrival: " + dateOfArrival);
        System.out.print("\n\t\t       Room Type: " + roomType);
        System.out.print("\n\t\t    Room Charges: " + expenses.getRoomCharge());
        System.out.print("\n\t\t Service Charges: " + expenses.getServiceCharges());
        System.out.print("\n\n");
    }
    public void printPersonalDetails()

    {
        System.out.println("\n\t\t-------->Personal Details <-------");

        System.out.print("\n\t\t        Customer ID: " + customerID +"\t\t\t ");

        System.out.print("\n\n\t\t      First Name: " + getFirstName());
        System.out.print("\n\t\t       Last Name: " + getLastName());
        System.out.print("\n\t\t          Gender: " + getGender());
        System.out.print("\n\t\tAccount Password: " + password);
        System.out.print("\n\t\t Date Of Arrival: " + dateOfArrival);
        System.out.print("\n\t\t       Room Type: " + roomType);
        System.out.print("\n\n");
    }
    public void printInvoice()
    {
        float total=expenses.getTotal();
        System.out.println("   Invoice ");

        System.out.print("\n\t\t    Room Charges: " + expenses.getRoomCharge());
        System.out.print("\n\t\t Service Charges: " + expenses.getServiceCharges());
        System.out.print("\n\t\t\t\t\t\t       Total Charges: " + total);
        System.out.print("\n\n");
    }
}
