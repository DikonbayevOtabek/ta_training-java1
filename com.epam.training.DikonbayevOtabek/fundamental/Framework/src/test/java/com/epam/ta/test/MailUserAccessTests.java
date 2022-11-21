package com.epam.ta.test;

import com.epam.ta.model.User;
import com.epam.ta.page.LoginPage;
import com.epam.ta.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MailUserAccessTests extends CommonConditions{

    @Test
    public void loginWithCorrectUsernamePassword(){
        User testUser = UserCreator.withCredentialsFromPropertyForMail();
        boolean isLoggedIn = new LoginPage(driver)
                .openPageMail()
                .mailLogin(testUser)
                .isButtonVisible();
        Assert.assertTrue(isLoggedIn);
    }
    @Test
    public void loginWithWrongUsername(){
        User testUser = UserCreator.withWrongUsernameMail();
        boolean isLoggedIn = new LoginPage(driver)
                .openPageMail()
                .mailLogin(testUser)
                .isButtonVisible();
        Assert.assertFalse(isLoggedIn);
    }
    @Test
    public void loginWithWrongPassword(){
        User testUser = UserCreator.withWrongPasswordMail();
        boolean isLoggedIn = new LoginPage(driver)
                .openPageMail()
                .mailLogin(testUser)
                .isButtonVisible();
        Assert.assertFalse(isLoggedIn);
    }
    @Test
    public void loginWithEmptyUsername(){
        User testUser = UserCreator.withEmptyUsernameMail();
        boolean isLoggedIn = new LoginPage(driver)
                .openPageMail()
                .mailLogin(testUser)
                .isButtonVisible();
        Assert.assertFalse(isLoggedIn);
    }
    @Test
    public void loginWithEmptyPassword(){
        User testUser = UserCreator.withEmptyPasswordMail();
        boolean isLoggedIn = new LoginPage(driver)
                .openPageMail()
                .mailLogin(testUser)
                .isButtonVisible();
        Assert.assertFalse(isLoggedIn);
    }
}
