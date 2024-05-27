package tests;

import datas.DataProvider;
import datas.Logins;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LogInPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static datas.DataUrls.BASE_URL;

/**
 * @author Matvii Kuznietsov
 */
public class BurgerMenuTests extends BaseTest {
    private LogInPage logInPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void preparation() {
        logInPage = new LogInPage(page, BASE_URL);
        inventoryPage = new InventoryPage(page, BASE_URL);
        logInPage.navigate();
        logInPage.login(Logins.STANDARD_USE.getUsername(), DataProvider.PASSWORD);

    }

    @Test
    @Description("Check is burger menu open")
    public void checkOpenBurgerMenu() {
        inventoryPage.clickBurgerMenuBtn();
        assertThat(page.locator(inventoryPage.burgerMenu)).isEnabled();
        assertThat(page.locator(inventoryPage.listBurgerMenu)).hasText(new String[]{"All Items", "About", "Logout", "Reset App State"});
    }
}
