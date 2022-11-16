package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSenderAndReceiver {
    // This string will be send as a message text
    String messageForSending = "Assalomu alekum";

    @Test
    public void testEmailIsSent() {
        EmailSenderServices emailSender = new EmailSenderServices();
        emailSender.login();
        Assert.assertTrue(emailSender.sendEmail(messageForSending));

    }

    @Test
    public void testIsEmailArrivedAndDisplayedAsUnread() {
        EmailReceiverServices emailReceiver = new EmailReceiverServices();
        emailReceiver.login();
        Assert.assertTrue(emailReceiver.emailIsArrived());
    }

    @Test
    public void testSender() {
        EmailReceiverServices emailReceiver = new EmailReceiverServices();
        emailReceiver.login();
        Assert.assertEquals(emailReceiver.getSenderName(), "Otabek Dikonbayev");
    }

    @Test
    public void testMatchesSendOne() throws InterruptedException {
        EmailReceiverServices emailReceiver = new EmailReceiverServices();
        emailReceiver.login();
        Assert.assertEquals(emailReceiver.getValueOfMessage(), messageForSending);
    }
}
