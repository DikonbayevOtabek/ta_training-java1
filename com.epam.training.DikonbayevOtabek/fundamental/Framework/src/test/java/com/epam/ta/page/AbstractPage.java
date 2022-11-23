package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final Logger logger = LogManager.getRootLogger();
    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract AbstractPage openPageGmail();

    protected abstract AbstractPage openPageMail();


}
