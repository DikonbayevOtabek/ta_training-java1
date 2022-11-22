package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewEmailPage extends AbstractPage{
    private final String SENT_MESSAGE_URL = "https://mail.google.com/mail/u/0/#sent";
    private final Logger logger = LogManager.getRootLogger();
    private WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement themeOfMessage;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
    private WebElement textOfMessage;
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement sendButton;
    @FindBy(xpath = "//div[@class='a3s aiL ']")
    WebElement valueOfMessage;

    private final By receiverAddressLocator = By.xpath("//input[@class='agP aFw']");
    private final By openSentMessageLocator = By.xpath("//tr[@class='zA yO']");




    public CreateNewEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CreateNewEmailPage createNewEmail(String textMessage, String textOfTheme) throws InterruptedException {

        WebElement receiverAddress = wait.until(ExpectedConditions.presenceOfElementLocated(receiverAddressLocator));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value='otabekreceiveremail@mail.ru'", receiverAddress);
        themeOfMessage.sendKeys(textOfTheme);
        textOfMessage.sendKeys(textMessage);
        sendButton.click();
        Thread.sleep(12000);
        logger.info("Send email with message: [" + textMessage +
                "[ and theme: [" + textOfTheme + "]");
        return this;
    }
    public String getValueOfMessage(){
        WebElement openSentMessage = wait.until(ExpectedConditions.presenceOfElementLocated(openSentMessageLocator));
        openSentMessage.click();


        wait.until(ExpectedConditions.visibilityOf(valueOfMessage));
        return valueOfMessage.getText();
    }


    @Override
    public CreateNewEmailPage openPageGmail() {
        driver.navigate().to(SENT_MESSAGE_URL);
        return this;
    }

    @Override
    public CreateNewEmailPage openPageMail() {
        return null;
    }
}
