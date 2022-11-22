package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    protected WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract AbstractPage openPageGmail();

    protected abstract AbstractPage openPageMail();


}
