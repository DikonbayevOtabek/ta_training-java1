package com.epam.ta.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewEmailPage extends AbstractPage{
    private final String SENT_MESSAGE_URL = "https://mail.google.com/mail/u/0/#sent";
    private WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement themeOfMessage;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
    private WebElement textOfMessage;
    @FindBy(xpath = "//div[@class='a3s aiL ']")
    private WebElement valueOfMessage;

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
        String keysPressed =  Keys.chord(Keys.CONTROL, Keys.ENTER);
        textOfMessage.sendKeys(keysPressed); // If you press Ctrl and Enter message will send automatically
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
