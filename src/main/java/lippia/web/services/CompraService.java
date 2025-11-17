package lippia.web.services;


import com.crowdar.core.actions.WebActionManager;
import junit.framework.Assert;
import lippia.web.constants.CarritoConstants;
import lippia.web.constants.CompraConstants;



public class CompraService extends WebActionManager {

    private static String getProductOverviewPriceLocator(String productName) {
        return String.format(CompraConstants.PRODUCT_OVERVIEW_PRICE_XPATH, productName);
    }

    private static String getProductOverviewLocator(String productName) {
        return String.format(CompraConstants.PRODUCT_NAME_OVERVIEW_XPATH, productName);
    }

    private static String getRemoveFromCartLocator(String productName) {
        String productId = productName.toLowerCase().replace(" ", "-");
        return String.format(CompraConstants.BUTTON_REMOVE_CART_TEMPLATE, productId);
    }


    private static String getProductTitleInCartLocator(String productName) {
        return String.format(CompraConstants.PRODUCT_TITLE_CART_XPATH, productName);
    }

    public static void verificarProductoCarrito(String p_producto){
        Assert.assertTrue("El producto no esta en el carrito", waitPresence(getProductTitleInCartLocator(p_producto)).isDisplayed());
    }

    public static void verificarProductoComprado(String p_producto){
        Assert.assertTrue("El producto no esta comprado", waitPresence(getRemoveFromCartLocator(p_producto)).isDisplayed());
    }
    public static void clickCarrito(){
        click(CompraConstants.BUTTON_CART_XPATH);
    }
    public static void clickCheckout(){
        click(CompraConstants.BUTTON_CHECKOUT_XPATH, true);

    }
    public static void verificarTituloCheckout(){
        Assert.assertTrue("El título de checkout no es visible", waitPresence(CompraConstants.TITLE_CHECKOUT_XPATH).isDisplayed());
    }

    public static void completarCampoNombre(String p_nombre){
        setInput(CompraConstants.INPUT_FIRST_NAME_XPATH, p_nombre);
    }

    public static void completarCampoApellido(String p_apellido){
        setInput(CompraConstants.INPUT_LAST_NAME_XPATH, p_apellido);
    }

    public static void completarCampoCodigoPostal(String p_CodPostal){
        setInput(CompraConstants.INPUT_CODE_POSTAL_XPATH, p_CodPostal);
    }

    public static void clickContinue(){
        click(CompraConstants.BUTTON_CONTINUE_XPATH);
    }

    public static void verificarTituloOverview(){
        Assert.assertTrue("El título de Overview no es visible", waitPresence(CompraConstants.TITLE_OVERVIEW_XPATH).isDisplayed());
    }

    public static void verificarProductoOverview(String p_producto){
        Assert.assertTrue("El título de checkout no es visible", waitPresence(getProductOverviewLocator(p_producto)).isDisplayed());
    }

    public static void verificarPrecioProducto(String p_producto){
        String precioEsperado = MemoryService.get(p_producto + "_precio");
        String precioActual = getText(getProductOverviewPriceLocator(p_producto));
        Assert.assertEquals("El precio es incorrecto", precioEsperado, precioActual );
    }

    public static void clickFinish(){
        click(CompraConstants.BUTTON_FINISH_XPATH, true);
    }

    public static void verificarCompra(String p_msj){
        Assert.assertTrue("No se muestra el mensaje al finalizar la compra", waitPresence(CompraConstants.MESSAGE_FINISH_XPATH).isDisplayed());
        Assert.assertEquals("El mensaje al finalizar la compra no es el esperado", p_msj, getElement(CompraConstants.MESSAGE_FINISH_XPATH).getText());
    }

    public static void verificarPrecioTotal(){
        double totalEsperado = MemoryService.getTotalPrice();
        double totalActual = Double.parseDouble(getText(CompraConstants.TOTAL_PRICE_OVERVIEW_XPATH).replace("Item total: $", "").trim());
        Assert.assertEquals("El total del carrito no coincide con el total esperado", totalEsperado, totalActual);


    }






}




