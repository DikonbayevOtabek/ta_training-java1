package com.epam.ta.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverSingleton {
    private static WebDriver driver;
    // Both of paths are defaults path
    private final static String chromeBinaryPath = "C:\\Users\\Otabek\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe";
    private final static String firefoxBinaryPath = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")){
                case "firefox": {
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setBinary(firefoxBinaryPath);
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                }
                default: {
                    ChromeOptions chromeOptions= new ChromeOptions();
                    chromeOptions.setBinary(chromeBinaryPath);
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    break;
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
