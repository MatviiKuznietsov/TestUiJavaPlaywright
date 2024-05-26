package pages;

import com.microsoft.playwright.Page;

/**
 * @author Matvii Kuznietsov
 */
public class CheckoutStepTwoPage extends BasePage{
    public final String finishBtn = "[data-test=\"finish\"]";
    public CheckoutStepTwoPage(Page page, String url) {
        super(page, url);
    }

    public void clickFinishBtn (){
        page.locator(finishBtn).click();
    }
}
