package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUsernamePassword {
    @Test
    public void testGmailAbilityToEnterWithCorrectUsernamePassword() throws InterruptedException {
        Email email = new Email();
        Assert.assertTrue(email.loginGmail("otabeksenderemail@gmail.com", "SenderEmail"));
    }

    @Test
    public void testGmailImpossibilityOfEnteringWithWrongPasswordUsername() throws InterruptedException {
        Email email = new Email();
        Assert.assertFalse(email.loginGmail("otabeksenderemail@gmail.com", "Sender1Email"));
        Assert.assertFalse(email.loginGmail("otabekreceivaremail@mail.ru", "ReceiverEmail"));
    }

    @Test
    public void testGmailImpossibilityOfEnteringWithEmptyUsernamePassword() throws InterruptedException {
        Email email = new Email();
        Assert.assertFalse(email.loginGmail("", "ReceiverEmail"));
        Assert.assertFalse(email.loginGmail("otabekreceiveremail@gmail.com", ""));
    }

    @Test
    public void testMailAbilityToEnterWithCorrectUsernamePassword() throws InterruptedException {
        Email email = new Email();
        Assert.assertTrue(email.loginMail("otabekreceiveremail@mail.ru", "ReceiverEmail"));
    }

    @Test
    public void testMailImpossibilityOfEnteringWithWrongPasswordUsername() throws InterruptedException {
        Email email = new Email();
        Assert.assertFalse(email.loginMail("otabeksenderemail@gmail.com", "Sender1Email"));
        Assert.assertFalse(email.loginMail("otabekreceivaremail@mail.ru", "Receiver20001Email"));
    }

    @Test
    public void testMailImpossibilityOfEnteringWithEmptyUsernamePassword() throws InterruptedException {
        Email email = new Email();
        Assert.assertFalse(email.loginMail("", "SenderEmail"));
        Assert.assertFalse(email.loginMail("otabeksenderemail@gmail.com", ""));
    }
}
