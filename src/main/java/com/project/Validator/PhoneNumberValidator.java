package com.project.Validator;

public class PhoneNumberValidator {

    public static boolean validatePhoneNumber(String phoneNumber) {
        //validate phone numbers of format "1234567890"
        if (phoneNumber.matches("\\d{10}")) return true;
        //validating phone number with -, . or spaces 1234-567-890||
        else if(phoneNumber.matches("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}")) return true;
        //return false if nothing matches the input
        else return false;
    }

}
