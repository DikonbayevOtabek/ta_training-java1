package org.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailSenderServices {
    Login login = new Login();
    protected WebDriver driver = login.getDriver();

    private By createNewMessageButton = By.xpath("//div[@style='user-select: none']");
    private By receiverAdress = By.xpath("//input[@class='agP aFw']");
    private By themeOfMessage = By.xpath("//input[@name='subjectbox']");
    private By textOfMessage = By.xpath("//div[@class='Am Al editable LW-avf tS-tW']");
    private By sendButton = By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']");

    public void login() {
        login.loginGmail("otabeksenderemail@gmail.com", "SenderEmail");
        this.driver = login.getDriver();
    }

    public boolean sendEmail(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(createNewMessageButton));
        driver.findElement(createNewMessageButton).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(receiverAdress));

        WebElement usernameAdress = driver.findElement(receiverAdress);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value='otabekreceiveremail@mail.ru'", usernameAdress);
        try {
            driver.findElement(themeOfMessage).sendKeys("Test");
            driver.findElement(textOfMessage).sendKeys(message);
            driver.findElement(sendButton).click();
            Thread.sleep(20000); // This sleep helps to wait some time in order to send message correctly
            driver.quit();
            return true;
        } catch (Exception exception) {
            driver.quit();
            return false;
        }
    }

}
