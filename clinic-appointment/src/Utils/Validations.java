package Utils;

public class Validations {


    Validations(){}

    public static boolean validAMKA(String AMKA){
        return AMKA.trim().matches("^[0-9]{11}$");
    }

    public static boolean validPhone(String phone){
        return phone.trim().matches("^[0-9]{10}$");
    }

}
