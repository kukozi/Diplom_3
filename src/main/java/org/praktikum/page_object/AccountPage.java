package org.praktikum.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AccountPage {
    private final WebDriver driver;
    private final By profileLink = By.xpath(".//a[text()='Профиль']");
    private final By orderHistoryLink = By.xpath(".//a[text()='История заказов']");
    private final By exitButton = By.xpath(".//button[text()='Выход']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void profileLinkClick() {
        driver.findElement(profileLink).click();
    }

    public void orderHistoryLinkClick() {
        driver.findElement(orderHistoryLink).click();
    }

    public LogInPage exitButtonClick() {
        driver.findElement(exitButton).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return new LogInPage(driver);
    }

    public String getProfileLinkText() {
        return driver.findElement(profileLink).getText();
    }
}