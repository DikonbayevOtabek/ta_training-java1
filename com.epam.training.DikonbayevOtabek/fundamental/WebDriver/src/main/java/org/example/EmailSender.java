package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailSender {
    WebDriver driver = new ChromeDriver();

    public void login() {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedrivers\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://gmail.com");

        WebElement elementForUsername = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//input[@name='identifier']"))));
        elementForUsername.sendKeys("otabeksenderemail@gmail.com", Keys.ENTER);

        WebElement elementForPassword = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//input[@name='Passwd']"))));
        elementForPassword.sendKeys("SenderEmail", Keys.ENTER);
    }

    public boolean sendEmail(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='T-I T-I-KE L3']")));
        driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='agP aFw']")));

        WebElement userNameTxt = driver.findElement(By.xpath("//input[@class='agP aFw']"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("arguments[0].value='otabekreceiveremail@mail.ru'", userNameTxt);
        try {
            driver.findElement(By.xpath("//input[@name='subjectbox']"))
                    .sendKeys("test");

            driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']"))
                    .sendKeys(message);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']"))
                    .click();
            Thread.sleep(20000);
            driver.quit();
            return true;
        } catch (Exception exception) {
            driver.quit();
            return false;
        }
    }
}
