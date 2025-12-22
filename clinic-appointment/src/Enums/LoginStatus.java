package Enums;

public enum LoginStatus {
    AMKA_NOT_FOUND("AMKA not found"),
    PHONE_NOT_FOUND("Phone not found"),
    SUCCESSFULL("Login was successfull");
    private final String desc;
    LoginStatus(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return desc;
    }
}
