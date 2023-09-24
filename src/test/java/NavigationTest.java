import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.page_object.*;

public class NavigationTest extends BaseTest {

    @Before
    public void getUrl() {
        driver.get(baseUrl + "/register");
    }

    @Test
    @DisplayName("Go to account page")
    public void moveToAccountPageTest() {
        Header header = new Header(driver);
        LogInPage logInPage = new LogInPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.logInClick();
        logInPage.authorization(email, password);
        header.clickPersonalAccountAuthorizedUser();
        Assert.assertEquals("Профиль", accountPage.getProfileLinkText());
    }

    @Test
    @DisplayName("Go to constructor via button")
    public void moveToConstructorFromLinkTest() {
        Header header = new Header(driver);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        header.clickPersonalAccountAuthorizedUser();
        header.clickConstructor();
        Assert.assertEquals("Соберите бургер", constructorPage.getConstructorLabelName());
    }

    @Test
    @DisplayName("Go to constructor via logo")
    public void moveToConstructorFromLogoTest() {
        Header header = new Header(driver);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        header.clickPersonalAccountAuthorizedUser();
        header.clickLogo();
        Assert.assertEquals("Соберите бургер", constructorPage.getConstructorLabelName());
    }
}