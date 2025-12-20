package entities;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Person(){};// κενος constructor για να μπορεσω να αναζητησω ασθενη με βαση το id, στο dao

    public Person(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }



    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setFirstName(String firstname){
        this.firstName = firstname;
    }

    public void setLastName(String lastname){
        this.lastName = lastname;
    }

    public void setPhoneNumber(String phonenumber){
        this.phoneNumber = phonenumber;
    }

}
