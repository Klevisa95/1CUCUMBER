package utils;

public class APIPayloadConstants {

    public static String generateTokenPayload(){

        String generateToken ="{\n" +
                "  \"email\": \"testbatch1721@gmail.com\",\n" +
                "  \"password\": \"Test@1231\"\n" +
                "}";
        return generateToken;

    }



    public static String createEmployeePayload(){

        String createEmployeePayload=  "{\n" +
                "  \"emp_firstname\": \"klevisa\",\n" +
                "  \"emp_lastname\": \"kolaj\",\n" +
                "  \"emp_middle_name\": \"ms\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1995-10-10\",\n" +
                "  \"emp_status\": \"confirmed\",\n" +
                "  \"emp_job_title\": \"sdet\"\n" +
                "}";

    }



}



//here we pass all payload (nothing should be hardcoded in step definition )