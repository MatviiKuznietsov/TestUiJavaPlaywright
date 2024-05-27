package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static datas.DataProvider.DELAY_50;

/**
 * @author Matvii Kuznietsov
 */
public class LogInPage extends BasePage {
    public final String loginInput = "[data-test='username']";
    private final String passwordInput = "[data-test='password']";
    private final String loginBtn = "[data-test='login-button']";
    private final String errorBtn = "[data-test='error']";
    private final String errorIcon = "form .form_group:first-child svg";

    public LogInPage(Page page, String url) {
        super(page, url);

    }

    public LogInPage enterUsername(String username) {
        page.locator(loginInput).pressSequentially(username, new Locator.PressSequentiallyOptions().setDelay(DELAY_50));
        return this;
    }

    public LogInPage enterPassword(String password) {
        page.locator(passwordInput).pressSequentially(password, new Locator.PressSequentiallyOptions().setDelay(DELAY_50));
        return this;
    }

    public void clickBtnLogIn() {
        page.locator(loginBtn).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        page.click(loginBtn);
    }

    public boolean isErrorBtnExist() {
        return page.locator(errorBtn).isVisible();
    }

    public boolean isErrorIconExist() {
        return page.locator(errorIcon).isVisible();
    }
}
