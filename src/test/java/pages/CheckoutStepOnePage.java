package pages;

import com.microsoft.playwright.Page;
import entities.Customer;

import static datas.DataUrls.BASE_URL;

/**
 * @author Matvii Kuznietsov
 */
public class CheckoutStepOnePage extends BasePage{

    public final String firstNameInput = "[data-test=\"firstName\"]";
    public final String lastNameInput = "[data-test=\"lastName\"]";
    public final String zipInput = "[data-test=\"postalCode\"]";
    public final String continueBtn = "[data-test=\"continue\"]";
    public CheckoutStepOnePage(Page page, String url) {
        super(page, url);
    }

    public CheckoutStepTwoPage fillInformation (Customer customer){
        page.locator(firstNameInput).fill(customer.getFirstName());
        page.locator(lastNameInput).fill(customer.getLastName());
        page.locator(zipInput).fill(customer.getZipCode());
        page.locator(continueBtn).click();
        return new CheckoutStepTwoPage(page, BASE_URL);
    }
}
