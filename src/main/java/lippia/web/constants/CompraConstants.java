package lippia.web.constants;

public class CompraConstants {

    public static final String PRODUCT_TITLE_CART_XPATH = "xpath://*[@class='inventory_item_name'][contains(text(),'%s')]";
    public static final String BUTTON_REMOVE_CART_TEMPLATE = "xpath://*[@id='remove-%s']";
    public static final String PRODUCT_OVERVIEW_PRICE_XPATH = "xpath://div[@class='cart_item']//div[@class='inventory_item_name' and text()='%s']//following::div[@class='inventory_item_price'][1]";
    public static final String PRODUCT_NAME_OVERVIEW_XPATH = "xpath://div[@class='inventory_item_name' and text()='%s']";


    public static final String BUTTON_CART_XPATH = "xpath://*[@id=\"shopping_cart_container\"]/a";
    public static final String BUTTON_CHECKOUT_XPATH = "xpath://*[@id=\"checkout\"]";
    public static final String TITLE_CHECKOUT_XPATH = "xpath://*[@id=\"header_container\"]/div[2]/span";
    public static final String INPUT_FIRST_NAME_XPATH = "xpath://*[@id=\"first-name\"]";
    public static final String INPUT_LAST_NAME_XPATH = "xpath://*[@id=\"last-name\"]";
    public static final String INPUT_CODE_POSTAL_XPATH = "xpath://*[@id=\"postal-code\"]";
    public static final String BUTTON_CONTINUE_XPATH = "xpath://*[@id=\"continue\"]";
    public static final String TITLE_OVERVIEW_XPATH = "xpath://span[@class='title' and contains(text(), 'Checkout: Overview')]";
    public static final String BUTTON_FINISH_XPATH = "xpath://*[@id=\"finish\"]";
    public static final String MESSAGE_FINISH_XPATH = "xpath://*[@id=\"checkout_complete_container\"]/h2";
    public static final String TOTAL_PRICE_OVERVIEW_XPATH = "xpath://*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]";


}

