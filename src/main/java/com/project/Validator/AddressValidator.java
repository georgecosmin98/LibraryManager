package com.project.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressValidator {

    public static boolean isValid(String address) {

        String regx = "^St.*";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(address);
        return matcher.find();
    }

}
