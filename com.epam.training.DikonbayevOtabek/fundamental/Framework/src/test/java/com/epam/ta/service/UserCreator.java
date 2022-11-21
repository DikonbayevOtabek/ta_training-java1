package com.epam.ta.service;

import com.epam.ta.model.User;
import com.epam.ta.util.StringUtils;

public class UserCreator {

    public static final String USER_NAME_GMAIL = TestDataReader.getTestData("gmail.user.name");
    public static final String USER_PASSWORD_GMAIL = TestDataReader.getTestData("gmail.user.password");
    public static final String USER_NAME_MAIL = TestDataReader.getTestData("mail.user.name");
    public static final String USER_PASSWORD_MAIL = TestDataReader.getTestData("mail.user.password");

    public static User withCredentialsFromPropertyForGmail(){
        return new User(USER_NAME_GMAIL,USER_PASSWORD_GMAIL);
    }
    public static User withCredentialsFromPropertyForMail(){
        return new User(USER_NAME_MAIL,USER_PASSWORD_MAIL);
    }

    public static User withWrongUsernameGmail(){
        return new User(StringUtils.generateRandomUsernameWithPostfixLength(5),
                USER_PASSWORD_GMAIL);
    }
    public static User withWrongPasswordGmail(){
        return new User(USER_NAME_GMAIL,
                StringUtils.generateRandomPasswordWithPostfixLength(6));
    }
    public static User withWrongUsernameMail(){
        return new User(StringUtils.generateRandomUsernameWithPostfixLength(5),
                USER_PASSWORD_MAIL);
    }
    public static User withWrongPasswordMail(){
        return new User(USER_NAME_MAIL,
                StringUtils.generateRandomPasswordWithPostfixLength(6));
    }

    public static User withEmptyUsernameGmail(){
        return new User("", USER_PASSWORD_GMAIL);
    }
    public static User withEmptyPasswordGmail(){
        return new User(USER_NAME_GMAIL, "");
    }
    public static User withEmptyUsernameMail(){
        return new User("", USER_PASSWORD_MAIL);
    }
    public static User withEmptyPasswordMail(){
        return new User(USER_NAME_MAIL, "");
    }
}
