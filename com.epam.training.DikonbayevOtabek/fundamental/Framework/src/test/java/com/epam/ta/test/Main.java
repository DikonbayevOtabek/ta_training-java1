package com.epam.ta.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Main extends CommonConditions{
    @Test
    public  void main() {
        driver.get("http://alica.com/");
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='p_ si34 '][2]")));
        System.out.println("elemeent value : " + element.getText());
    }

}
