package com.epam.ta.test;

import com.epam.ta.model.User;
import com.epam.ta.page.LoginPage;
import com.epam.ta.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GmailUserAccessTests extends CommonConditions{


    @Test
    public void loginWithCorrectUsernamePassword(){
        User testUser = UserCreator.withCredentialsFromPropertyForGmail();
        boolean isLoggedIn = new LoginPage(driver)
                .openPageGmail()
                .gmailLogin(testUser)
                .isButtonVisible();

        Assert.assertTrue(isLoggedIn);
    }
    @Test
    public void loginWithWrongUsername(){
        User testUser = UserCreator.withWrongUsernameGmail();
        boolean isLoggedIn = new LoginPage(driver)
                .openPageGmail()
                .gmailLogin(testUser)
                .isButtonVisible();
        Assert.assertFalse(isLoggedIn);
    }
    @Test
    public void loginWithWrongPassword(){
        User testUser = UserCreator.withWrongPasswordGmail();
        boolean isLoggedIn = new LoginPage(driver)
                .openPageGmail()
                .gmailLogin(testUser)
                .isButtonVisible();
        Assert.assertFalse(isLoggedIn);
    }
    @Test
    public void loginWithEmptyUsername(){
        User testUser = UserCreator.withEmptyUsernameGmail();
        boolean isLoggedIn = new LoginPage(driver)
                .openPageGmail()
                .gmailLogin(testUser)
                .isButtonVisible();
        Assert.assertFalse(isLoggedIn);
    }
    @Test
    public void loginWithEmptyPassword(){
        User testUser = UserCreator.withEmptyPasswordGmail();
        boolean isLoggedIn = new LoginPage(driver)
                .openPageGmail()
                .gmailLogin(testUser)
                .isButtonVisible();
        Assert.assertFalse(isLoggedIn);
    }
}
