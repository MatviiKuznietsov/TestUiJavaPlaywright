package pages;

import com.microsoft.playwright.Page;

/**
 * @author Matvii Kuznietsov
 */
public class CheckoutCompletePage extends BasePage{

    public final String textSuccessOrder = "[data-test=\"complete-header\"]";
    public CheckoutCompletePage(Page page, String url) {
        super(page, url);
    }


}
