package Utils;

public class Validations {


    Validations(){}

    public static boolean validAMKA(String AMKA){
        return AMKA.trim().matches("^[0-9]{11}$");
    }

    public static boolean validPhone(String phone){
        return phone.trim().matches("^[0-9]{10}$");
    }

    public static boolean validSector(String sector){return sector.matches("^[a-zA-Zα-ωΑ-Ω\\s]{3,30}$");}

    public static boolean validLastName(String lastName){return lastName.matches("^[a-zA-Zα-ωΑ-Ω\\s]{3,30}$");}

}
