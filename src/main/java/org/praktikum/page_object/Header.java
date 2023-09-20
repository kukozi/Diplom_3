package org.praktikum.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Header {
    private final WebDriver driver;
    private final By designerLink = By.xpath(".//*[@id='root']/div/header/nav/ul/li[1]/a");
    private final By orderFeedLink = By.xpath(".//*[@id='root']/div/header/nav/ul/li[2]/a");
    private final By logoLink = By.xpath(".//*[@id='root']/div/header/nav/div/a");
    private final By personalAccountLink = By.xpath(".//p[text() = 'Личный Кабинет']");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public DesignerPage clickDesigner() {
        driver.findElement(designerLink).click();
        return new DesignerPage(driver);
    }

    public void clickOrderFeed() {
        driver.findElement(orderFeedLink).click();
    }

    public DesignerPage clickLogo() {
        driver.findElement(logoLink).click();
        return new DesignerPage(driver);
    }

    public LogInPage clickPersonalAccountByAnUnauthorizedUser() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalAccountLink));
        driver.findElement(personalAccountLink).click();
        return new LogInPage(driver);
    }

    public AccountPage clickPersonalAccountAuthorizedUser() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalAccountLink));
        driver.findElement(personalAccountLink).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return new AccountPage(driver);
    }

}