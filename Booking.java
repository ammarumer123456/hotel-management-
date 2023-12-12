public class Booking { // booking class uses array to manage list of customers

    public Customer[] customerList;
    private int max_Customers = 10;
    private int customerCount;

    Booking()
    {
        customerCount = 0;
        max_Customers = 10;
        customerList = new Customer[max_Customers];
    }
    public int getCustomerCount()
    {
        return customerCount;
    } //array is initiliazed using the "new" keyword

    public void updateArray(int index)
    {
        for (int j = index; j < customerCount; j++)
        {
            customerList[j] = customerList[j + 1];                 // move all the front bookings one step backwards into the array
        }
        customerCount--;                                   // decrement customer counter
    }
    public void addBooking(Customer obj)
    {
        if (customerCount < max_Customers)
        {
            customerList[customerCount] = obj;
            customerCount++;
        }
        else
        {
            System.out.println("\n\t\t--->Cant Book Customer As Hotel Is Currently Full<---\n\n");
        }
    }
    public void removeBooking(int ID, String fname)
    {
        boolean found=false;    // Initially, We haven't found the respective Customer, so we can set it to false
        int index;
        for (index = 0; index < customerCount && !found; index++)  // iterate until we reach end of list OR customer is found
        {
            if(customerList[index].getCustomerID() ==ID && customerList[index].getFirstName().equals(fname))
            {
                found=true;  // WE found the respective Customer, so we can delete it
            }
        }
        if(found==true) {
            updateArray(index - 1); // Remove booking from array and save it in file
            System.out.println("\n\t\t Check out Successful\n");
        }
        else {
            System.out.println("\nERROR: Customer Doesn't Exist!\n");
        }
    }
    public int getBookingIndex(int ID, String passwrd){
        int index;
        boolean found=false;    // Initially, We haven't found the respective Customer, so we can set it to false
        for (index = 0; index < customerCount && !found; index++)  // iterate until we reach end of list OR customer is found
        {
            if(customerList[index].getCustomerID() ==ID && customerList[index].getPassword().equals(passwrd))
            {
                found=true;  // WE found the respective Customer, so we can delete it
                break;
            }
        }
        if(found == false) {
            index=-1; // since we didn't find that particular customer, we return less than zero
        }
        return index;
    }
    public void printCustomerList()
    {
        System.out.println("\n\t\t-------->Printing Customers List<-------");
        for (int i = 0; i < customerCount; i++)
        {
            customerList[i].printDetails();
        }
    }
}
