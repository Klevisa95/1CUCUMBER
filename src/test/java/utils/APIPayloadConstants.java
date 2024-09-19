package utils;

import org.json.JSONObject;

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
        return createEmployeePayload;

    }


    public static String createEmployeeJsonPayload(){

        JSONObject obj = new JSONObject(); //we crete this object
        obj.put("emp_firstname", "klevisa");
        obj.put("emp_lastname", "kolaj");
        obj.put("emp_middle_name", "ms");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "1995-10-10");
        obj.put("emp_status", "confirmed");
        obj.put("emp_job_title", "sdet"); //kalojme ne "obj.put" method te gjitha info e mesiperme

        return obj.toString();


    }




}



//here we pass all payload (nothing should be hardcoded in step definition )