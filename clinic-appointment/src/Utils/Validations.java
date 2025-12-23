package Utils;

import java.time.LocalDate;

public class Validations {


    Validations(){}

    public static boolean validAMKA(String AMKA){
        return AMKA.trim().matches("^[0-9]{11}$");
    }

    public static boolean validPhone(String phone){
        return phone.trim().matches("^[0-9]{10}$");
    }
    public static boolean isBlank(String string){
        return string == null || string.trim().isEmpty();
    }
    public static boolean validDate(LocalDate date){
        return !date.isAfter(LocalDate.now());
    }
}
