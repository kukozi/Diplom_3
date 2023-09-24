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
    public void tabBunsNavigationTest() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickTabFilling();
        constructorPage.clickTabBuns();
        Assert.assertTrue("Current tab is not Buns", constructorPage.isCurrentTabBuns());
    }

    @Test
    @DisplayName("Check sauces icon click")
    public void tabSaucesNavigationTest() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickTabSauces();
        Assert.assertTrue("Current tab is not Sauces", constructorPage.isCurrentTabSauces());
    }

    @Test
    @DisplayName("Check filling icon click")
    public void tabFillingNavigationTest() {
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickTabFilling();
        Assert.assertTrue("Current tab is not Fillings", constructorPage.isCurrentTabFillings());
    }

}