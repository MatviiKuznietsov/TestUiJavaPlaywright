package pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static datas.DataUrls.BASE_URL;

/**
 * @author Matvii Kuznietsov
 */
public class InventoryPage extends BasePage {
    public final String failInventoryImg = ".inventory_list .inventory_item:first-of-type [src=\"/static/media/sl-404.168b1cce.jpg\"]";
    public final String burgerMenuBtn = "#react-burger-menu-btn";
    public final String burgerMenu = ".bm-menu";
    public final String listBurgerMenu = ".bm-item.menu-item";
    public final String backpackAddCartBtn = "[data-test ='add-to-cart-sauce-labs-backpack']";
    public final String basketBtn = "[data-test=\"shopping-cart-link\"]";
    public final String inventoryItems = "[data-test=\"inventory-item\"]";
    public final String inventoryItemsLabels = "//*[@data-test=\"inventory-item\"]//*[@data-test=\"inventory-item-name\"]";

    public InventoryPage(Page page, String url) {
        super(page, url);
    }

    public boolean isFailInventoryImgExist() {
        return page.locator(failInventoryImg).isVisible();
    }

    public void clickBurgerMenuBtn() {
        page.locator(burgerMenuBtn).click();
    }

    public CartPage openCart() {
        page.locator(backpackAddCartBtn).click();
        assertThat(page.locator(basketBtn)).hasText("1");
        page.locator(basketBtn).click();
        return new CartPage(page, BASE_URL);
    }

    public Integer getQuantityElements() {
        return page.locator(inventoryItems).count();
    }


}
