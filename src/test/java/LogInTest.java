import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.page_object.DesignerPage;
import org.praktikum.page_object.Header;
import org.praktikum.page_object.RecoveryPage;
import org.praktikum.page_object.RegistrationPage;

public class LogInTest extends BaseTest {

    @Before
    public void createConditionsTest() {
        driver.get(baseUrl + "/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(name, email, password);
    }

    @Test
    @DisplayName("Move to authorization via the header button")
    public void authorizationUserInHeaderTest() {
        driver.get(baseUrl);
        Header header = new Header(driver);
        DesignerPage designerPage = new DesignerPage(driver);
        header.clickPersonalAccountByAnUnauthorizedUser()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Move to authorization via button on the construction page")
    public void authorizationFromTheConstructorPageTest() {
        driver.get(baseUrl);
        DesignerPage designerPage = new DesignerPage(driver);
        designerPage.clickAccountEnterButton()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Move to authorization via link on registration page")
    public void authorizationFromTheRegistrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        DesignerPage designerPage = new DesignerPage(driver);
        registrationPage.enterLinkClick()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Move to authorization via recovery page")
    public void authorizationFromThePasswordRecoveryPage() {
        driver.get(baseUrl + "/forgot-password");
        RecoveryPage recoveryPage = new RecoveryPage(driver);
        DesignerPage designerPage = new DesignerPage(driver);
        recoveryPage.enterLinkClick()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", designerPage.getButtonCreatedOrder().getText());
    }

}
