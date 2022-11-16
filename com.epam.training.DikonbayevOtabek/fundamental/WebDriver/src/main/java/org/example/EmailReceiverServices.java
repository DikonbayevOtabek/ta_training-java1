package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailReceiverServices {
    Login login = new Login();
    protected WebDriver driver = login.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    String URL_FOR_RECEIVED_MESSAGES_PAGE = "https://e.mail.ru/messages/inbox/";

    private By numberOfUnreadMessages = By.xpath("//span[@class='badge__text']");
    private By adressOfSender = By.xpath("//span[@class='ll-crpt']");
    private By valueOfMessage = By.xpath("//div[@dir='ltr']");

    public void login() {
        login.loginMail("otabekreceiveremail@mail.ru", "ReceiverEmail");
        driver = login.getDriver();
    }

    public boolean emailIsArrived() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(numberOfUnreadMessages));
            int numberOfReceivedMessage = Integer.parseInt(driver.findElement(numberOfUnreadMessages).getText());
            driver.quit();
            return numberOfReceivedMessage >= 1;
        } catch (Exception exception) {
            driver.quit();
            return false;
        }
    }

    public String getSenderName() {
        driver.get(URL_FOR_RECEIVED_MESSAGES_PAGE);

        wait.until(ExpectedConditions.presenceOfElementLocated(adressOfSender));
        String senderName = driver.findElement(adressOfSender).getText();
        driver.quit();
        return senderName;
    }

    public String getValueOfMessage() throws InterruptedException {
        driver.get(URL_FOR_RECEIVED_MESSAGES_PAGE);

        wait.until(ExpectedConditions.presenceOfElementLocated(adressOfSender));
        driver.findElement(adressOfSender).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(valueOfMessage));
        String sentMessage = driver.findElement(valueOfMessage).getText();
        driver.quit();
        return sentMessage;

    }
}
