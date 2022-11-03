package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if(email == null || email.isEmpty() || email.isBlank()){
            return false;
        }
        String expression = "^[(a-z)]{2,}+[_]{1}+[a-z]{1,}+([0-9]?)+@epam.com+$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}





