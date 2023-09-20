import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.page_object.DesignerPage;
import org.praktikum.page_object.Header;
import org.praktikum.page_object.AccountPage;
import org.praktikum.page_object.RegistrationPage;

public class NavigationTest extends BaseTest {
    @Before
    public void getUrl() {
        driver.get(baseUrl + "/register");
    }

    @Test
    @DisplayName("Go to account page")
    public void transferToYourPersonalAccountTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Header header = new Header(driver);
        AccountPage accountPage = new AccountPage(driver);
        registrationPage.registration(name, email, password)
                .authorization(email, password);
        header.clickPersonalAccountAuthorizedUser();
        Assert.assertEquals("Профиль", accountPage.getProfileLinkText());
    }

    @Test
    @DisplayName("Go to constructor via button")
    public void transferToDesignerFromLinkTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Header header = new Header(driver);
        DesignerPage designerPage = new DesignerPage(driver);
        registrationPage.registration(name, email, password)
                .authorization(email, password);
        header.clickPersonalAccountAuthorizedUser();
        header.clickDesigner();
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Go to constructor via logo")
    public void transferToDesignerFromLogoTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Header header = new Header(driver);
        DesignerPage designerPage = new DesignerPage(driver);
        registrationPage.registration(name, email, password)
                .authorization(email, password);
        header.clickPersonalAccountAuthorizedUser();
        header.clickLogo();
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }
}