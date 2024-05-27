package tests;

import datas.Logins;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LogInPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static datas.DataProvider.*;
import static datas.DataUrls.BASE_URL;

/**
 * @author Matvii Kuznietsov
 */


public class ValidationDataTests extends BaseTest {
    private LogInPage logInPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void preparation() {
        logInPage = new LogInPage(page, BASE_URL);
        inventoryPage = new InventoryPage(page, BASE_URL);
        logInPage.navigate();
    }

    @Test(description = "Check message on empty username ")
    public void checkEmptyUserName() {
        logInPage
                .enterPassword(PASSWORD)
                .clickBtnLogIn();
        Assert.assertTrue(logInPage.isErrorBtnExist(), "Msg button doesn't exist");
        Assert.assertTrue(logInPage.isErrorIconExist(), "Msg icon doesn't exist");
        Assert.assertTrue(page.getByText(ERROR_MSG_EMPTY_USER).isVisible(), "Msg doesn't exist");
        assertThat(page.locator(logInPage.loginInput)).hasCSS("border-bottom-color", COLOR_RED);
    }

    @Test(description = "Check message on empty password ")
    public void checkEmptyPassword() {
        logInPage
                .enterUsername(Logins.STANDARD_USE.getUsername())
                .clickBtnLogIn();
        Assert.assertTrue(logInPage.isErrorBtnExist(), "Msg button doesn't exist");
        Assert.assertTrue(logInPage.isErrorIconExist(), "Msg icon doesn't exist");
        Assert.assertTrue(page.getByText(ERROR_MSG_EMPTY_PASSWORD).isVisible(), "Msg doesn't exist");
        assertThat(page.locator(logInPage.loginInput)).hasCSS("border-bottom-color", COLOR_RED);
    }

    @Test(description = "Check message on invalid username ")
    public void checkInvalidUserName() {
        logInPage
                .enterUsername(INVALID_NAME)
                .enterPassword(PASSWORD)
                .clickBtnLogIn();
        Assert.assertTrue(logInPage.isErrorBtnExist(), "Msg button doesn't exist");
        Assert.assertTrue(logInPage.isErrorIconExist(), "Msg icon doesn't exist");
        Assert.assertTrue(page.getByText(ERROR_MSG_SERVICE_NOT_MATCH).isVisible(), "Msg doesn't exist");
        assertThat(page.locator(logInPage.loginInput)).hasCSS("border-bottom-color", COLOR_RED);
    }

    @Test(description = "Check message on invalid password ")
    public void checkInvalidPassword() {
        logInPage
                .enterUsername(Logins.STANDARD_USE.getUsername())
                .enterPassword(INVALID_PASSWORD)
                .clickBtnLogIn();
        Assert.assertTrue(logInPage.isErrorBtnExist(), "Msg button doesn't exist");
        Assert.assertTrue(logInPage.isErrorIconExist(), "Msg icon doesn't exist");
        Assert.assertTrue(page.getByText(ERROR_MSG_SERVICE_NOT_MATCH).isVisible(), "Msg doesn't exist");
        assertThat(page.locator(logInPage.loginInput)).hasCSS("border-bottom-color", COLOR_RED);
    }
}
