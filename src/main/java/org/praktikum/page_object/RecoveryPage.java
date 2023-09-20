package org.praktikum.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPage {
    private final WebDriver driver;

    private final By emailField = By.xpath(".//form/fieldset/div/div/input");
    private final By recoveryButton = By.xpath("//button[text()='Восстановить']");
    private final By enterLink = By.xpath(".//a[text()='Войти']");

    public RecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    public LogInPage enterLinkClick() {
        driver.findElement(enterLink).click();
        return new LogInPage(driver);
    }
}