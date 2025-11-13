package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import junit.framework.Assert;
import lippia.web.constants.CarritoConstants;
import lippia.web.constants.CompraConstants;

public class CompraService extends ActionManager {

    private static String getRemoveFromCartLocator(String productName) {
        String productId = productName.toLowerCase().replace(" ", "-");
        return String.format(CompraConstants.BUTTON_REMOVE_CART_TEMPLATE, productId);
    }
    private static String getProductTitleInCartLocator(String productName) {
        return String.format(CompraConstants.PRODUCT_TITLE_CART_XPATH, productName);
    }

    public static void verificarProductoCarrito(String p_producto){
        Assert.assertTrue("El producto no esta en el carrito", isPresent(getProductTitleInCartLocator(p_producto)));
    }

    public static void verificarProductoComprado(String p_producto){
        Assert.assertTrue("El producto no esta comprado", isPresent(getRemoveFromCartLocator(p_producto)));
    }
    public static void clicCarrito(){
        click(CompraConstants.BUTTON_CART_XPATH);
    }



}
