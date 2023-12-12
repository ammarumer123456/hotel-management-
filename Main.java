
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  // format current Date to YY/MM/DD utility
import java.time.LocalDateTime;             // get current Date utility

public class Main {
    public static Scanner  scanner = new Scanner(System.in);
    public  static int  customerID=1;
    public  static Booking bookings;

    public static void main(String[] args) {
        int choice;
        bookings=new Booking();

        System.out.println( Math.floor(Math.random() * 15)+5); //generates a random number between 5 and 20
        do {

            System.out.println("\n\t\t\t    ======= LOGIN PORTAL =====");
            System.out.println("\t\t        |    0. Exit             |");
            System.out.println("\t\t        |    1. Admin Login      |");
            System.out.println("\t\t        |    2. User  Login      |");
            System.out.println("\t\t        ==========================");



            System.out.print("Enter your choice: ");
            choice= scanner.nextInt();
            if(choice==0)
            {
                break;
            }
            else if(choice==1)
            {
                adminPortal();
            }
            else if(choice==2)
            {
                customerPortal();
            }
        }while(choice!=0);

        scanner.close();

        System.out.println("\n\n\t\t\tTHANK-YOU FOR USING HOTEL MANAGEMENT SYSTEM");
    }
    // admin login portal
    public static  void  adminPortal(){


        System.out.println("\n\t\t--------> Welcome to Admin Login Portal <-------");
        System.out.print("Admin       ID: ");
        String ID = scanner.next();
        System.out.print("Admin Password: ");
        String password = scanner.next();
        if(ID.equals("1234") && password.equals("0014"))
        {
            adminMenu();
        }
        else
        {
            System.out.print("Incorrect ID Password Admin");
        }
    }
    public static  void  adminMenu(){ // admin menu
        int choice;
        do {
//display the admin menu
            System.out.println("\n\t\t\t    =========== ADMIN PORTAL ========");
            System.out.println("\t\t        |    0. Log Out                 |");
            System.out.println("\t\t        |    1. Check In Customer       |");
            System.out.println("\t\t        |    2. View Customer List      |");
            System.out.println("\t\t        |    3. Check Out Customer      |");
            System.out.println("\t\t        =================================");





            System.out.print("Enter your choice: ");
            choice= scanner.nextInt();
            if(choice==0)
            {
                break;
            }
            else if(choice==1)
            {
                checkInCustomer();                // Function Call to create a booking for a customer
            }
            else if(choice==2)
            {
                bookings.printCustomerList();   // Call this function to print the entire list of customers
            }
            else if(choice==3)
            {
                checkOutCustomer();             // Function Call to delete a booking for customer
            }
        }while(choice!=0);
    }
    public static  void  checkInCustomer()// check-in a customer
    {
        String fname,lname,gender,pswd,rt;
        float roomChrges;
        System.out.println("\n\t\t\t--------> Check In Customer <-------");
        System.out.print("Customer First Name: ");
        fname = scanner.next();
        System.out.print("Customer  Last Name: ");
        lname = scanner.next();
        do {
            System.out.print("Customer Gender[M/F]: ");
            gender =scanner.next();
            if(gender.equals("M")||gender.equals("F"))
            {
                break;
            }
            else {
                System.out.print("\nERROR: Gender Can Be Either 'M' or 'F'\n\n");
            }
        }while(true);
        System.out.print("Customer Password: ");
        pswd = scanner.next();
        do {
// selecting room type either luxury, moderate or small.
            System.out.println("\n\t\t\t--------> Select Room Type <-------");
            System.out.print("1.Luxury   $150\n");
            System.out.print("2.Moderate $100 \n");
            System.out.print("3.Small    $70\n");
            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();
            if(choice==1)
            {
                roomChrges=150;
                rt="Luxury";
                break;
            }
            else if(choice==2)
            {
                roomChrges=100;
                rt="Moderate";
                break;
            }
            else if (choice==3)
            {
                roomChrges=70;
                rt="Small";
                break;
            }
            else
            {
                System.out.print("\nERROR: Incorrect Choice\n\n");
            }
        }while(true);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  // CREATE Date Formatter Object and Intialize it
        LocalDateTime now = LocalDateTime.now();  // GET current date
        Customer obj= new Customer(fname,lname,gender,customerID,dtf.format(now),pswd,roomChrges,rt); // Instantiate Customer object with parametrized Constructor
        bookings.addBooking(obj);  // Book customer into our hotel successfully

        System.out.print("\n\t\tCustomer Registered Successfully  \n"); // Print Recently Booked Customer Details on Screen
        System.out.print("\t          Customer ID: "+ customerID + "\n");    // Print Recently Booked Customer Details on Screen
        System.out.print("\t    Customer Password: "+ pswd + "\n");          // Print Recently Booked Customer Details on Screen

        customerID++;    // Unique ID to give to new customer registered in Hotel
    }
    public static  void   checkOutCustomer() // customer checking out
    {
        String fname;
        int Id;

        System.out.println("\n\t\t--------> Check Out Customer <-------");

        System.out.print("\t          Customer  ID        : ");
        Id = scanner.nextInt();
        System.out.print("\t          Customer  First Name: ");
        fname = scanner.next();
        bookings.removeBooking(Id,fname);            // Delete Booked customer from our hotel successfully

    }
    public static  void  customerPortal(){ // customer login portal

        System.out.println("\n\t\t--------> Welcome to User Login Portal <-------");
        System.out.print("      Customer ID: ");
        int ID = scanner.nextInt();
        System.out.print("Customer Password: ");
        String password = scanner.next();

        int index= bookings.getBookingIndex(ID,password);

        if(index>=0)   // we have found the customer booking index
        {
            customerMenu(index);
        }
        else {
            System.out.print("\n\nERROR:Incorrect ID/Password\n\n");
        }
    }
    public static void customerMenu(int index) // customer menu
    {
        int choice;
        do {

            System.out.println("\n\t\t\t      Welcome "+bookings.customerList[index].getFirstName());
            System.out.println("\n\t\t\t    =========== USER PORTAL  ========");
            System.out.println("\t\t        |    0. Log Out                 |");
            System.out.println("\t\t        |    1. View Details            |");
            System.out.println("\t\t        |    2. View Expenses           |");
            System.out.println("\t\t        |    3. Change Password         |");
            System.out.println("\t\t        |    4. Check Out               |");
            System.out.println("\t\t        =================================");
            System.out.print("Enter your choice: ");
            choice= scanner.nextInt();
            if(choice==0)
            {
                break;
            }
            else if(choice==1)
            {

                bookings.customerList[index].printPersonalDetails();

            }
            else if(choice==2)
            {
                bookings.customerList[index].printInvoice();
            }

            else if(choice==3)
            {


                System.out.println("\n\t\t-------->Change Password <-------");
                System.out.print("\t\t\tEnter Old Password: ");
                String oldPassword = scanner.next();
                if(oldPassword.equals(bookings.customerList[index].getPassword()))
                {
                    System.out.print("\t\t\tEnter New Password: ");
                    String newPassword = scanner.next();
                    bookings.customerList[index].setPassword(newPassword);
                    System.out.print("\n\t\t\t\t Password Updated Successfully\n\n");

                }
                else
                {
                    System.out.print("\n\t\t\t\tERROR: Incorrect Old Password\n\n");

                }
            }
            else if(choice==4)
            {
                bookings.updateArray(index); // remove this customers bookings from the booking array and logout
                System.out.println("\n\t\t\t Check out Successful\n");
                break;   // break do while loop to exit the function thereby logging out the customer
            }
        }while(choice!=0);
    }

    }


