import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.praktikum.page_object.ConstructorPage;
import org.praktikum.page_object.Header;
import org.praktikum.page_object.RecoveryPage;
import org.praktikum.page_object.RegistrationPage;

public class LogInTest extends BaseTest {

    @Test
    @DisplayName("Move to authorization via the header button")
    public void authorizationUserInHeaderTest() {
        driver.get(baseUrl);
        Header header = new Header(driver);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        header.clickPersonalAccountByAnUnauthorizedUser()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", constructorPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Move to authorization via button on the construction page header")
    public void authorizationFromTheConstructorPageHeaderTest() {
        driver.get(baseUrl);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickAccountButton()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", constructorPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Move to authorization via button on the construction page")
    public void authorizationFromTheConstructorPageListTest() {
        driver.get(baseUrl);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickLogInButton()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", constructorPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Move to authorization via link on registration page")
    public void authorizationFromTheRegistrationPage() {
        driver.get(baseUrl + "/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        registrationPage.logInClick()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", constructorPage.getButtonCreatedOrder().getText());
    }

    @Test
    @DisplayName("Move to authorization via recovery page")
    public void authorizationFromThePasswordRecoveryPage() {
        driver.get(baseUrl + "/forgot-password");
        RecoveryPage recoveryPage = new RecoveryPage(driver);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        recoveryPage.enterLinkClick()
                .authorization(email, password);
        Assert.assertEquals("Оформить заказ", constructorPage.getButtonCreatedOrder().getText());
    }

}
