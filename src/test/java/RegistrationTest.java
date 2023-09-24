import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.RandomStringUtils;
import org.praktikum.page_object.LogInPage;
import org.praktikum.page_object.RegistrationPage;

import java.time.Duration;

public class RegistrationTest extends BaseTest {

    @Before
    public void getUrl() {
        driver.get(baseUrl + "/register");
    }

    @Test
    @DisplayName("User registration w/ valid data")
    public void registrationTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String fakeEmail = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        LogInPage title = registrationPage.registration(name, fakeEmail, password);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains("login"));
        Assert.assertEquals("Вход", title.getTitle());
    }

    @Test
    @DisplayName("User registration w/ invalid password")
    public void registrationWithInvalidPassword() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(name, email, "12345");
        Assert.assertEquals("Некорректный пароль", registrationPage.getErrorPassword());
    }
}