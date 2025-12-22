package Enums;

public enum RegisterStatus {
    WRONG_PHONE("Wrong Phone Number"),
    WRONG_AMKA("Wrong AMKA"),
    SUCCESSFULL("Successfully logged in");

    private final String desc;
    RegisterStatus(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return desc;
    }
}
