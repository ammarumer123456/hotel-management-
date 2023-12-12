
abstract public class Person {

    private String firstName;
    private String lastName;
    private String gender;

    public Person() {
        firstName = "-";
        lastName = "-";
        gender= "-";
}
    public Person(String Fname, String Lname, String sex) {
        firstName=Fname;
        lastName=Lname;
        gender=sex;
    }
    public void setFirstName(String Fname)
    {
        firstName=Fname;
    }
    public void setLastName(String Lname)
    {
        lastName=Lname;
    }
    public void setGender( String sex)
    {
        gender=sex;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getGender()
    {
        return  gender;
    }

    public abstract void printDetails();
}
// The Person class is defined as an abstract class using the abstract keyword.
//It contains regular fields (firstName, lastName, and gender) to store the personal details of a person.


//the printDetails method is declared as abstract using the abstract keyword. It doesn't have a method body in the Person class itself.
//The purpose of the printDetails method is to provide a common interface for subclasses of Person to print the personal details of a person.
// Each subclass will implement this method according to its specific requirements.