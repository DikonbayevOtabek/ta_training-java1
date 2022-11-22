package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailReceivePage extends AbstractPage{

    private final String BASE_URL = "https://e.mail.ru/messages/inbox/";
    private final By addressOfSenderLocator = By.xpath("//span[@class='ll-crpt']");
    private final By valueOfMessageLocator = By.xpath("//div[@dir='ltr']");


    public EmailReceivePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getSenderName(){
        WebElement addressOfSender = wait.until(ExpectedConditions.presenceOfElementLocated(addressOfSenderLocator));
        return addressOfSender.getText();
    }
    public  String getValueOfMessage(){
        WebElement addressOfSender = wait.until(ExpectedConditions.presenceOfElementLocated(addressOfSenderLocator));
        addressOfSender.click();
        WebElement valueOfMessage = wait.until(ExpectedConditions.presenceOfElementLocated(valueOfMessageLocator));
        return valueOfMessage.getText();

    }

    @Override
    protected EmailReceivePage openPageGmail() {
        return null;
    }

    @Override
    protected EmailReceivePage openPageMail() {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
