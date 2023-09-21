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
        driver.get(baseUrl + "/login");
        LogInPage logInPage = new LogInPage(driver);
        Header header = new Header(driver);
        logInPage.authorization(email, password);
        header.clickPersonalAccountAuthorizedUser().exitButtonClick();
        Assert.assertEquals("Вход", logInPage.getTitle());

    }
}
