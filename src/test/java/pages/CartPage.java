package pages;

import com.microsoft.playwright.Page;

import static datas.DataUrls.BASE_URL;

/**
 * @author Matvii Kuznietsov
 */
public class CartPage extends BasePage{
    public final String checkoutBtn = "[data-test=\"checkout\"]";
    public CartPage(Page page, String url) {
        super(page, url);
    }

    public CheckoutStepOnePage clickCheckout(){
        page.locator(checkoutBtn).click();
        return new CheckoutStepOnePage(page, BASE_URL);
    }
}

