package com.epam.ta.page;

import com.epam.ta.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    private final String PAGE_URL_GMAIL =  "https://gmail.com";
    private final String PAGE_URL_MAIL = "https://mail.ru/login";

    @FindBy(xpath = "//input[@name='identifier']")
    private WebElement usernameGmail;
    private final By passwordGmailLocator = By.xpath("//input[@name='Passwd']");

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameMail;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordMail;
    @FindBy(xpath = "//iframe[@class='ag-popup__frame__layout__iframe']")
    private WebElement iFrame;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    @Override
    public LoginPage openPageGmail() {
        driver.navigate().to(PAGE_URL_GMAIL);
        logger.info("Gmail login page opened.");
        return this;
    }

    @Override
    public LoginPage openPageMail() {
        driver.navigate().to(PAGE_URL_MAIL);
        logger.info("Mail login page opened.");
        return this;
    }

    public GmailMainPage gmailLogin(User user){
        usernameGmail.sendKeys(user.getUsername(), Keys.ENTER);
        try{
            WebElement passwordGmail = wait.until(ExpectedConditions.presenceOfElementLocated(passwordGmailLocator));
            passwordGmail.sendKeys(user.getPassword(), Keys.ENTER);
            return new GmailMainPage(driver);
        }catch (Exception exception){
            return new GmailMainPage(driver);
        }
    }
    public MailMainPage mailLogin(User user){
        driver.switchTo().frame(iFrame);
        try{
            usernameMail.sendKeys(user.getUsername(), Keys.ENTER);
            passwordMail.sendKeys(user.getPassword(), Keys.ENTER);
            driver.switchTo().parentFrame();
            return new MailMainPage(driver);
        }catch (Exception exception){
            driver.switchTo().parentFrame();
            return new MailMainPage(driver);
        }
    }

}
