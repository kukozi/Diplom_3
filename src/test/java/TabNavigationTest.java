import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.praktikum.page_object.DesignerPage;

public class TabNavigationTest extends BaseTest {
    @Before
    public void getUrl() {
        driver.get(baseUrl);
    }

    @Test
    @DisplayName("Check bun icon click")
    public void tabRollsNavigationTest() {
        DesignerPage designerPage = new DesignerPage(driver);
        designerPage.clickTabFilling();
        designerPage.clickTabRolls();
        Assert.assertEquals("Краторная булка N-200i", designerPage.getRollsName());
    }

    @Test
    @DisplayName("Check sauces icon click")
    public void tabSaucesNavigationTest() {
        DesignerPage designerPage = new DesignerPage(driver);
        designerPage.clickTabSauces();
        Assert.assertEquals("Соус Spicy-X", designerPage.getSaucesName());
    }

    @Test
    @DisplayName("Check filling icon click")
    public void tabFillingNavigationTest() {
        DesignerPage designerPage = new DesignerPage(driver);
        designerPage.clickTabFilling();
        Assert.assertEquals("Биокотлета из марсианской Магнолии", designerPage.getFillingName());
    }

}