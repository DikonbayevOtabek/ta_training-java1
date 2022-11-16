package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUsernamePassword {
    @Test
    public void testGmailAbilityToEnterWithCorrectUsernamePassword() throws InterruptedException {
        Login login = new Login();
        Assert.assertTrue(login.loginGmail("otabeksenderemail@gmail.com", "SenderEmail"));
        login.quit();
    }

    @Test
    public void testGmailImpossibilityOfEnteringWithWrongPasswordUsername() throws InterruptedException {
        Login loginWithIncorrectPassword = new Login();
        Login loginWithIncorrectUsername = new Login();
        Assert.assertFalse(loginWithIncorrectPassword.loginGmail("otabeksenderemail@gmail.com", "Sender1Email"));
        Assert.assertFalse(loginWithIncorrectUsername.loginGmail("otabekreceivaremail@mail.ru", "ReceiverEmail"));
        loginWithIncorrectPassword.quit();
        loginWithIncorrectUsername.quit();
    }

    @Test
    public void testGmailImpossibilityOfEnteringWithEmptyUsernamePassword() {
        Login loginWithEmptyUsername = new Login();
        Login loginWithEmptyPassword = new Login();
        Assert.assertFalse(loginWithEmptyUsername.loginGmail("", "ReceiverEmail"));
        Assert.assertFalse(loginWithEmptyPassword.loginGmail("otabekreceiveremail@gmail.com", ""));
        loginWithEmptyUsername.quit();
        loginWithEmptyPassword.quit();
    }

    @Test
    public void testMailAbilityToEnterWithCorrectUsernamePassword() {
        Login login = new Login();
        Assert.assertTrue(login.loginMail("otabekreceiveremail@mail.ru", "ReceiverEmail"));
        login.quit();
    }

    @Test
    public void testMailImpossibilityOfEnteringWithWrongPasswordUsername() {
        Login loginWithIncorrectUsername = new Login();
        Login loginWithIncorrectPassword = new Login();
        Assert.assertFalse(loginWithIncorrectUsername.loginMail("otabeksenderemail@gmail.com", "Sender1Email"));
        Assert.assertFalse(loginWithIncorrectPassword.loginMail("otabekreceivaremail@mail.ru", "Receiver20001Email"));
        loginWithIncorrectPassword.quit();
        loginWithIncorrectUsername.quit();
    }

    @Test
    public void testMailImpossibilityOfEnteringWithEmptyUsernamePassword() throws InterruptedException {
        Login loginWithEmptyUsername = new Login();
        Login loginWithEmptyPassword = new Login();
        Assert.assertFalse(loginWithEmptyUsername.loginMail("", "SenderEmail"));
        Assert.assertFalse(loginWithEmptyPassword.loginMail("otabeksenderemail@gmail.com", ""));
        loginWithEmptyUsername.quit();
        loginWithEmptyPassword.quit();
    }
}
