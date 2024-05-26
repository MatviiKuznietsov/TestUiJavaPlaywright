package tests;

import datas.DataProvider;
import datas.Logins;
import entities.Customer;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static datas.DataUrls.BASE_URL;

/**
 * @author Matvii Kuznietsov
 */
public class OrderProductsTest extends BaseTest {
    private LogInPage logInPage;
    private InventoryPage inventoryPage;

    Customer customer = new Customer("Rober", "Poulson", "68231");

    @BeforeMethod
    public void preparation() {
        logInPage = new LogInPage(page, BASE_URL);
        inventoryPage = new InventoryPage(page, BASE_URL);
        logInPage.navigate();
        logInPage.login(Logins.STANDARD_USE.getUsername(), DataProvider.PASSWORD);
    }

    @Test
    @Description("Check add product to to basket and order")
    public void checkOrderProduct() {
        inventoryPage
                .openCart()
                .clickCheckout()
                .fillInformation(customer)
                .clickFinishBtn();
        assertThat(page.locator(new CheckoutCompletePage(page, BASE_URL).textSuccessOrder)).isEnabled();
    }
}
