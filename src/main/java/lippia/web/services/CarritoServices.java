package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import junit.framework.Assert;
import lippia.web.constants.CarritoConstants;
import lippia.web.constants.CompraConstants;


public class CarritoServices extends ActionManager {

    private static String getAddToCartLocator(String productName) {
        String productId = productName.toLowerCase().replace(" ", "-");
        return String.format(CarritoConstants.BUTTON_ADD_CART_TEMPLATE, productId);
    }
    private static String getRemoveFromCartLocator(String productName) {
        String productId = productName.toLowerCase().replace(" ", "-");
        return String.format(CarritoConstants.BUTTON_REMOVE_CART_TEMPLATE, productId);
    }

    private static String getProductPriceLocator(String productName) {
        return String.format(CarritoConstants.PRODUCT_PRICE_XPATH, productName);
    }



    public static void agregarProductoCarrito(String p_producto){
        Assert.assertTrue("No esta disponible para agregar",isPresent(getAddToCartLocator(p_producto)));
        String precio = getText(getProductPriceLocator(p_producto));
        MemoryService.save(p_producto + "_precio", precio);

        click(getAddToCartLocator(p_producto));
        Assert.assertTrue("El producto NO se agrego al carrito", isPresent(getRemoveFromCartLocator(p_producto)));

    }


    public static void verificarCarritoProducto(String p_cantidad){
        Assert.assertTrue("El contador del carrito no esta visible", isPresent(CarritoConstants.CART_BADGE_XPATH));
        Assert.assertEquals("El numero del carrito no es el esperado", p_cantidad, getElement(CarritoConstants.CART_BADGE_XPATH).getText());
    }
    public static void eliminarProductoCarrito(String p_producto){
        Assert.assertTrue("El producto no esta comprado", isPresent(getRemoveFromCartLocator(p_producto)));
        click(getRemoveFromCartLocator(p_producto));
    }

    public static void verificarCarritoVacio(){
        Assert.assertFalse("El carrito debería estar vacío, pero el contador sigue visible", isPresent(CarritoConstants.CART_BADGE_XPATH));
    }

}
