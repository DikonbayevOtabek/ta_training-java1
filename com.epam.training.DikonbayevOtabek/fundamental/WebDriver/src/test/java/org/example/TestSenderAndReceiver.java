package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSenderAndReceiver {
    String messageForSending = "Assalomu alekum";

    @Test
    public void testEmailIsSent() {
        EmailSender emailSender = new EmailSender();
        emailSender.login();
        Assert.assertTrue(emailSender.sendEmail(messageForSending));

    }

    @Test
    public void testIsEmailArrivedAndDisplayedAsUnread() {
        EmailReceiver emailReceiver = new EmailReceiver();
        emailReceiver.login();
        Assert.assertTrue(emailReceiver.emailIsArrived());
    }

    @Test
    public void testSender() {
        EmailReceiver emailReceiver = new EmailReceiver();
        emailReceiver.login();
        Assert.assertEquals(emailReceiver.getSenderName(), "Otabek Dikonbayev");
    }

    @Test
    public void testMatchesSendOne() throws InterruptedException {
        EmailReceiver emailReceiver = new EmailReceiver();
        emailReceiver.login();
        Assert.assertEquals(emailReceiver.getValueOfMessage(), messageForSending);
    }
}
