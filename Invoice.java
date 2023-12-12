public class Invoice {

    private    float roomCharge;

    private   float serviceCharges;
    Invoice(){ // Default constructor
        roomCharge=0;
        serviceCharges=0;
    }
    Invoice(float roomChrg, float serviceChrg){  // Parameterized constructor
        roomCharge=roomChrg;

        serviceCharges=serviceChrg;
    }

    public   void setRoomCharge(float value){
        roomCharge=value;
    } // Setter method for roomCharge

    public   void setServiceCharges(float value){
        serviceCharges=value;
    }
    public float getRoomCharge(){
        return roomCharge;
    } // Getter method for roomCharge

    public   float getServiceCharges() {
        return serviceCharges;
    } // Getter method for serviceCharges
    public  float getTotal(){return roomCharge+serviceCharges;}  // Method to calculate the total invoice amount
}
