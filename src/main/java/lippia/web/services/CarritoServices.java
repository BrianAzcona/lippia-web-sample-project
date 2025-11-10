package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import junit.framework.Assert;
import lippia.web.constants.CarritoConstants;


public class CarritoServices extends ActionManager {

    public static void agregarProductoCarrito(String p_producto){
        Assert.assertTrue("No se encontro el Producto" + p_producto, isPresent(CarritoConstants.TITLE_BACKPACK_XPATH));
        click(CarritoConstants.BUTTON_ADD_CART_BACKPACK_XPATH);
    }

    public static void verificarCarritoProducto(String p_cantidad){
        Assert.assertTrue("El contador del carrito no esta visible", isPresent(CarritoConstants.CART_BADGE_XPATH));
        Assert.assertEquals("El numero del carrito no es el esperado", p_cantidad, getElement(CarritoConstants.CART_BADGE_XPATH).getText());
    }
    public static void eliminarProductoCarrito(){
        Assert.assertTrue("El producto no esta comprado", isPresent(CarritoConstants.BUTTON_REMOVE_CART_BACKPACK_XPATH));
        click(CarritoConstants.BUTTON_REMOVE_CART_BACKPACK_XPATH);
    }

    public static void verificarCarritoVacio(){
        Assert.assertFalse(
                "El carrito debería estar vacío, pero el contador sigue visible", isPresent(CarritoConstants.CART_BADGE_XPATH));
    }

}
