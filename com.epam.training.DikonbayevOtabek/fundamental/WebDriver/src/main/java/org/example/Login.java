package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    protected WebDriver driver = new ChromeDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private String pathToChromeDriver = "C:\\tools\\chromedrivers\\chromedriver.exe";
    private String URL_FOR_GMAIL = "https://gmail.com";
    private String URL_FOR_MAIL = "https://mail.ru/login";

    private By usernameGmail = By.xpath("//input[@name='identifier']");
    private By passwordGmail = By.xpath("//input[@name='Passwd']");
    private By sendButton = By.xpath("//span[@class='nU ']");

    private By iFrame = By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']");
    private By usernameMail = By.xpath("//input[@name='username']");
    private By passwordMail = By.xpath("//input[@name='password']");
    private By newMessageButton = By.xpath("//span[@class='compose-button__wrapper']");

    private void setDriver() {
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        driver.manage().window().maximize();
    }

    public boolean loginGmail(String username, String password) {
        setDriver();
        driver.get(URL_FOR_GMAIL);

        wait.until(ExpectedConditions.presenceOfElementLocated(usernameGmail));
        driver.findElement(usernameGmail).sendKeys(username, Keys.ENTER);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(passwordGmail));
            WebElement elementForPassword = driver.findElement(passwordGmail);
            elementForPassword.click();
            if (elementForPassword.isDisplayed()) {
                elementForPassword.sendKeys(password, Keys.ENTER);
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(sendButton));
                    WebElement elementForCheckTrue = driver.findElement(sendButton);
                    return elementForCheckTrue.isDisplayed();
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean loginMail(String username, String password) {
        setDriver();
        driver.get(URL_FOR_MAIL);

        wait.until(ExpectedConditions.presenceOfElementLocated(iFrame));
        driver.switchTo().frame(driver.findElement(iFrame));

        wait.until(ExpectedConditions.presenceOfElementLocated(usernameMail));
        driver.findElement(usernameMail).sendKeys(username, Keys.ENTER);

        try {
            WebElement elementForPassword = driver.findElement(passwordMail);
            elementForPassword.click();
            if (elementForPassword.isDisplayed()) {
                elementForPassword.sendKeys(password, Keys.ENTER);
                driver.switchTo().parentFrame();
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(newMessageButton));
                    WebElement elementForCorrectLogin = driver.findElement(newMessageButton);
                    return elementForCorrectLogin.isDisplayed();
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception exception) {
            return false;
        }

    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void quit() {
        this.driver.quit();
    }

}
