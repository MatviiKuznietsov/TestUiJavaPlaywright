package pages;

import com.microsoft.playwright.Page;

/**
 * @author Matvii Kuznietsov
 */
public class BasePage {


    public Page page;
    public String url;

    public BasePage(Page page, String url) {
        this.page = page;
        this.url = url;
    }

    public void navigate(){
        page.navigate(url);
    }

}
