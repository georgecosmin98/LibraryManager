package com.project.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {

    public static boolean isValid(String name) {

        String regx = "^[\\p{L} .'-]+$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();

    }
}
