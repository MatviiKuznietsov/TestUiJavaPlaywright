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
import static datas.DataUrls.INVENTORY_URL;

/**
 * @author Matvii Kuznietsov
 */
public class LogInDiffUsersTests extends BaseTest {

    private LogInPage logInPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void preparation() {
        logInPage = new LogInPage(page, BASE_URL);
        inventoryPage= new InventoryPage(page, BASE_URL);
        logInPage.navigate();
    }

    @Test(description = "Check successful log in standard_user")
    public void checkSuccessfulLogInStandardUser() {
        logInPage.login(Logins.STANDARD_USE.getUsername(), PASSWORD);
        assertThat(page).hasURL(INVENTORY_URL);
    }

    @Test(description = "Check successful log in locked_out_user")
    public void checkSuccessfulLogInLockedUser() {
        logInPage.login(Logins.LOCKED_OUT_USER.getUsername(), PASSWORD);
        Assert.assertTrue(logInPage.isErrorBtnExist(), "Msg button doesn't exist");
        Assert.assertTrue(logInPage.isErrorIconExist(), "Msg icon doesn't exist");
        Assert.assertTrue(page.getByText(ERROR_MSG_USER_LOCK).isVisible(), "Msg doesn't exist");
        assertThat(page.locator(logInPage.loginInput)).hasCSS("border-bottom-color", COLOR_RED);
    }

    @Test(description = "Check successful log in problem_user")
    public void checkSuccessfulLogInProblemUser() {
        logInPage.login(Logins.PROBLEM_USER.getUsername(), PASSWORD);
        assertThat(page).hasURL(INVENTORY_URL);
        Assert.assertTrue(inventoryPage.isFailInventoryImgExist(), "Fail img doesn't visible");
    }

    @Test(description = "Check successful log in performance_glitch_user")
    public void checkSuccessfulLogInGlitchUser() {
        logInPage.login(Logins.PERFORMANCE_GLITCH_USER.getUsername(), PASSWORD);
        assertThat(page).hasURL(INVENTORY_URL);
    }

    @Test(description = "Check successful log in error_user")
    public void checkSuccessfulLogInErrorUser() {
        logInPage.login(Logins.ERROR_USER.getUsername(), PASSWORD);
        assertThat(page).hasURL(INVENTORY_URL);
    }

    @Test(description = "Check successful log in visual_user")
    public void checkSuccessfulLogInVisualUser() {
        logInPage.login(Logins.VISUAL_USER.getUsername(), PASSWORD);
        assertThat(page).hasURL(INVENTORY_URL);
    }
}
