import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.page_object.ConstructorPage;

public class TabNavigationTest extends BaseTest {
    @Before
    public void getUrl() {
        driver.get(baseUrl);
    }

    @Test
    @DisplayName("Check bun icon click")
    public void tabRollsNavigationTest() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickTabFilling();
        constructorPage.clickTabRolls();
        Assert.assertEquals("Краторная булка N-200i", constructorPage.getRollsName());
    }

    @Test
    @DisplayName("Check sauces icon click")
    public void tabSaucesNavigationTest() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickTabSauces();
        Assert.assertEquals("Соус Spicy-X", constructorPage.getSaucesName());
    }

    @Test
    @DisplayName("Check filling icon click")
    public void tabFillingNavigationTest() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickTabFilling();
        Assert.assertEquals("Биокотлета из марсианской Магнолии", constructorPage.getFillingName());
    }

}