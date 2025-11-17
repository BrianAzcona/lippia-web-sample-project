package lippia.web.constants;

public class CarritoConstants {


    public static final String BUTTON_ADD_CART_TEMPLATE = "xpath://*[@id='add-to-cart-%s']";
    public static final String BUTTON_REMOVE_CART_TEMPLATE = "xpath://*[@id='remove-%s']";

    public static final String PRODUCT_PRICE_XPATH = "xpath://div[text()='%s']/ancestor::div[1]/following-sibling::div[@class='pricebar']//div[@class='inventory_item_price']";



    public static final String CART_BADGE_XPATH = "xpath://*[@id=\"shopping_cart_container\"]/a/span";

}
