package pages;

import com.microsoft.playwright.Page;

/**
 * @author Matvii Kuznietsov
 */
public class InventoryPage extends BasePage{
    public final String failInventoryImg = ".inventory_list .inventory_item:first-of-type [src=\"/static/media/sl-404.168b1cce.jpg\"]";
    public InventoryPage(Page page, String url) {
        super(page, url);
    }

    public boolean isFailInventoryImgExist(){
        return page.locator(failInventoryImg).isVisible();
    }



}
