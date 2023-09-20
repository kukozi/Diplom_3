package org.praktikum.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;
    private final By nameField = By.xpath(".//fieldset[1]//input");
    private final By emailField = By.xpath(".//fieldset[2]//input");
    private final By passwordField = By.name("Пароль");
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By enterLink = By.xpath(".//a[text()='Войти']");
    private final By errorPassword = By.xpath(".//div[@id='root']//fieldset[3]/div/p");
    private final By eye = By.xpath("//*[@id='root']//fieldset[3]//path");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void nameFieldInput(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void emailFieldInput(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void passwordFieldInput(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void registrationButtonClick() {
        driver.findElement(registrationButton).click();
    }

    public LogInPage registration(String name, String email, String password) {
        nameFieldInput(name);
        emailFieldInput(email);
        passwordFieldInput(password);
        registrationButtonClick();
        return new LogInPage(driver);
    }

    public LogInPage enterLinkClick() {
        driver.findElement(enterLink).click();
        return new LogInPage(driver);
    }

    public String getErrorPassword() {
        WebElement textErrore = driver.findElement(errorPassword);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(textErrore));
        return textErrore.getText();
    }

}