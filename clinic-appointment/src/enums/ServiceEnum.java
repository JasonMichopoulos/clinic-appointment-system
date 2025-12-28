package enums;

public enum ServiceEnum {
    SUCCESSFULL("Successfull"),
    FAILED("Failed"),
    PATIENT_NOT_FOUND("Patient not found"),
    INVALID_DATE_OF_BIRTH("Invalid Date of birth"),
    WRONG_AMKA("Wrong AMKA"),
    WRONG_PHONE("Wrong Phone number");

    private final String desc;
    ServiceEnum(String desc){this.desc=desc;}
    public String getDesc(){return desc;}

}
