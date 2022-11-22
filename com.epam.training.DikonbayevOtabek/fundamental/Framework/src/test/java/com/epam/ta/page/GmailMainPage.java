package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailMainPage extends AbstractPage {
    private final String BASE_URL = "https://gmail.com";

    private final By createNewMessageButtonLocator = By.xpath("//div[@style='user-select: none']");
    private final By newMessageButtonGmailLocator = By.xpath("//span[@class='nU ']");

    public GmailMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CreateNewEmailPage invokeNewEmailCreation(){
        WebElement createNewMessageButton = wait.until(ExpectedConditions.elementToBeClickable(createNewMessageButtonLocator));
        createNewMessageButton.click();
        return new CreateNewEmailPage(driver);
    }
    public boolean isButtonVisible(){
        try {
            WebElement newMessageButtonGmail = wait.until(ExpectedConditions.visibilityOfElementLocated(newMessageButtonGmailLocator));
            return newMessageButtonGmail.isDisplayed();
        }catch (Exception exception) {
            return false;
        }
    }

    @Override
    public GmailMainPage openPageGmail() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    @Override
    public GmailMainPage openPageMail() {
        return null;
    }
}
