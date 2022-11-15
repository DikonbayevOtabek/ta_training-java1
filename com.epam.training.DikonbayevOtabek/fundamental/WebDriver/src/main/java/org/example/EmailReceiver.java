package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailReceiver {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void login() {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedrivers\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://mail.ru/login");

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']")));
        driver.switchTo().frame(
                driver.findElement(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));
        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys("otabekreceiveremail@mail.ru", Keys.ENTER);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
        driver.findElement(By.xpath("//input[@name='password']"))
                .sendKeys("ReceiverEmail", Keys.ENTER);

        driver.switchTo().parentFrame();

    }

    public boolean emailIsArrived() {
        try {
            Thread.sleep(3000);
            int numberOfReceivedMessage = Integer.parseInt(
                    driver.findElement(By.xpath("//span[@class='badge__text']")).getText());
            System.out.println("number: " + numberOfReceivedMessage);
            Thread.sleep(3000);
            if (numberOfReceivedMessage >= 1) {
                driver.quit();
                return true;
            } else {
                driver.quit();
                return false;
            }
        } catch (Exception exception) {
            return false;
        }
    }

    public String getSenderName() {
        driver.get("https://e.mail.ru/messages/inbox/");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ll-crpt']")));
        String senderName = driver.findElement(By.xpath("//span[@class='ll-crpt']")).getText();
        driver.quit();
        return senderName;
    }

    public String getValueOfMessage() throws InterruptedException {
        driver.get("https://e.mail.ru/messages/inbox/");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ll-crpt']")));
        driver.findElement(By.xpath("//span[@class='ll-crpt']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@dir='ltr']")));
        String sentMessage = driver.findElement(By.xpath("//div[@dir='ltr']")).getText();
        Thread.sleep(4000);
        driver.quit();
        return sentMessage;

    }
}
