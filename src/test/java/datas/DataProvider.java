package datas;

/**
 * @author Matvii Kuznietsov
 */
public class DataProvider {
    public static final String PASSWORD = System.getenv("MY_APP_PASSWORD");
    public static final String PASSWORD2 = "secret_sauce";
    public static final String INVALID_PASSWORD = "#$##%";
    public static final String INVALID_NAME = "#$##%";
    public static final Integer DELAY_50 = 50;
    public static final String ERROR_MSG_USER_LOCK = "Epic sadface: Sorry, this user has been locked out.";
    public static final String ERROR_MSG_EMPTY_USER = "Epic sadface: Username is required";
    public static final String ERROR_MSG_EMPTY_PASSWORD = "Epic sadface: Password is required";
    public static final String ERROR_MSG_SERVICE_NOT_MATCH = "Epic sadface: Username and password do not match any user in this service";
    public static final String COLOR_RED = "rgb(226, 35, 26)";
    public static final String[] INVENTORY_LABELS = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"};
}
