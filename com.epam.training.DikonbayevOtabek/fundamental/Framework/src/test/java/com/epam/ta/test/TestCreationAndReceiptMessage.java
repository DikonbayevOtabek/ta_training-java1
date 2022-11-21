package com.epam.ta.test;

import com.epam.ta.model.User;
import com.epam.ta.page.LoginPage;
import com.epam.ta.service.UserCreator;
import com.epam.ta.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

//mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testng-TestCreationAndReceiptMessage.xml -Denvironment=dev clean test
public class TestCreationAndReceiptMessage extends CommonConditions{
    private static final int MESSAGE_POSTFIX_LENGTH = 10;
    private static  final String EXPECTED_MESSAGE_VALUE = StringUtils.generateRandomMessageValueWithPostfixLength(MESSAGE_POSTFIX_LENGTH);
    private static final String MESSAGE_THEME = "test";
    private static final String EXPECTED_SENDER_ADDRESS = "Otabek Dikonbayev";


    @Test
    public void emailIsSent() throws InterruptedException {
        User testUser = UserCreator.withCredentialsFromPropertyForGmail();
        String sentMessageValue = new LoginPage(driver)
                .openPageGmail()
                .gmailLogin(testUser)
                .invokeNewEmailCreation()
                .createNewEmail(EXPECTED_MESSAGE_VALUE, MESSAGE_THEME)
                .openPageGmail()
                .getValueOfMessage();

        Assert.assertEquals(sentMessageValue, EXPECTED_MESSAGE_VALUE);
    }

    @Test
    public void isEmailArrived(){
        User testUser = UserCreator.withCredentialsFromPropertyForMail();
        boolean isArrived = new LoginPage(driver)
                .openPageMail()
                .mailLogin(testUser)
                .isMessageArrived();

        Assert.assertTrue(isArrived);
    }
    @Test
    public void isSenderAddressCorrect(){
        User testUser = UserCreator.withCredentialsFromPropertyForMail();
        String messageSentAddress = new LoginPage(driver)
                .openPageMail()
                .mailLogin(testUser)
                .invokeEmailReceivePage()
                .getSenderName();
        Assert.assertEquals(messageSentAddress, EXPECTED_SENDER_ADDRESS);
    }
    @Test
    public void isTextMessageCorrect(){
        User testUser = UserCreator.withCredentialsFromPropertyForMail();
        String textOfReceivedMessage = new LoginPage(driver)
                .openPageMail()
                .mailLogin(testUser)
                .invokeEmailReceivePage()
                .getValueOfMessage();

        Assert.assertEquals(textOfReceivedMessage, EXPECTED_MESSAGE_VALUE);
    }
}
