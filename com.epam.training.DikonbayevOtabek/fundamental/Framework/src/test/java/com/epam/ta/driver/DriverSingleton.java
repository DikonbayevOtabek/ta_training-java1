package com.epam.ta.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")){
                case "firefox": {
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                }
                default: {
                    ChromeOptions chromeOptions= new ChromeOptions();
                    chromeOptions.setBinary("C:\\Users\\Otabek\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                }
            }

            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
