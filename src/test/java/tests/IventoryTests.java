package tests;

import datas.DataProvider;
import datas.Logins;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LogInPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static datas.DataProvider.INVENTORY_LABELS;
import static datas.DataUrls.BASE_URL;

/**
 * @author Matvii Kuznietsov
 */
public class IventoryTests extends BaseTest {
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
    @Description("Check quantity cards on inventory page")
    public void checkOrderProduct() {
        Assert.assertEquals(inventoryPage.getQuantityElements(), 6);
        assertThat(page.locator(inventoryPage.inventoryItemsLabels)).hasText(INVENTORY_LABELS);
    }
}
