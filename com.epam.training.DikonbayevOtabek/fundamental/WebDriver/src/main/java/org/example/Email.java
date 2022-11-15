package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Email {

    public boolean loginGmail(String username, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://gmail.com");

        WebElement elementForUsername = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='identifier']"))));
        elementForUsername.sendKeys(username, Keys.ENTER);

        try {
            Thread.sleep(3000);
            WebElement elementForPassword = driver.findElement(By.xpath("//input[@name='Passwd']"));
            elementForPassword.click();
            if (elementForPassword.isDisplayed()) {
                driver.findElement(By.xpath("//input[@name='Passwd']"))
                        .sendKeys(password, Keys.ENTER);
                Thread.sleep(3000);
                WebElement elementForCheckTrue = driver.findElement(By.xpath("//input[@name='q']"));
                if (elementForCheckTrue.isDisplayed()) {
                    Thread.sleep(3000);
                    driver.quit();
                    return true;
                } else {
                    Thread.sleep(3000);
                    driver.quit();
                    return false;
                }
            } else {
                Thread.sleep(3000);
                driver.quit();
                return false;
            }
        } catch (Exception exception) {
            Thread.sleep(3000);
            driver.quit();
            return false;
        }
    }

    public boolean loginMail(String username, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://mail.ru/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']")));
        driver.switchTo().frame(
                driver.findElement(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']")));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));
        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(username, Keys.ENTER);

        try {
            Thread.sleep(3000);
            WebElement elementForPassword = driver.findElement(By.xpath("//input[@name='password']"));
            elementForPassword.click();
            if (elementForPassword.isDisplayed()) {
                driver.findElement(By.xpath("//input[@name='password']"))
                        .sendKeys(password, Keys.ENTER);
                driver.switchTo().parentFrame();
                Thread.sleep(3000);
                WebElement elementForCorrectLogin = driver.findElement(By.xpath(
                        "//div[@class='count svelte-5zskdg']"));
                if (elementForCorrectLogin.isDisplayed()) {
                    Thread.sleep(3000);
                    driver.quit();
                    return true;
                } else {
                    Thread.sleep(3000);
                    driver.quit();
                    return false;
                }
            } else {
                Thread.sleep(3000);
                driver.quit();
                return false;
            }

        } catch (Exception exception) {
            Thread.sleep(3000);
            driver.quit();
            return false;
        }

    }

}
