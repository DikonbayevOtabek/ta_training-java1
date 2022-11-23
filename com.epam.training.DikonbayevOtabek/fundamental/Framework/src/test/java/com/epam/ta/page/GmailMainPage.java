package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailMainPage extends AbstractPage {
    private final String BASE_URL = "https://gmail.com";
    private WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    @FindBy(xpath = "//div[@style='user-select: none']")
    private WebElement createNewMessageButton;
    @FindBy(xpath = "//span[@class='nU ']")
    private WebElement newMessageButtonGmail;

    public GmailMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CreateNewEmailPage invokeNewEmailCreation(){
        wait.until(ExpectedConditions.elementToBeClickable(createNewMessageButton));
        createNewMessageButton.click();
        return new CreateNewEmailPage(driver);
    }
    public boolean isButtonVisible(){
        try {
            wait.until(ExpectedConditions.visibilityOf(newMessageButtonGmail));
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
