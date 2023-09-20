import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.praktikum.page_object.LogInPage;
import org.praktikum.page_object.Header;
import org.praktikum.page_object.RegistrationPage;

public class LogOutTest extends BaseTest {
    @Test
    @DisplayName("Account logout")
    public void logOutOfAccount() {
        driver.get(baseUrl + "/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Header header = new Header(driver);
        registrationPage.registration(name, email, password)
                .authorization(email, password);
        LogInPage logInPage = header.clickPersonalAccountAuthorizedUser().exitButtonClick();
        Assert.assertEquals("Вход", logInPage.getTitle());

    }
}
