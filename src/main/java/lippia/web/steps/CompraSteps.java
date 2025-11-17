package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import lippia.web.services.CarritoServices;
import lippia.web.services.CompraService;


public class CompraSteps extends PageSteps {

    @And("^el usuario tiene los productos (.*) y (.*) en el carrito$")
    public void elUsuarioTieneLosProductosYEnElCarrito(String p_producto1, String p_producto2) {
        CarritoServices.agregarProductoCarrito(p_producto1);
        CarritoServices.agregarProductoCarrito(p_producto2);

        CompraService.verificarProductoComprado(p_producto1);
        CompraService.verificarProductoComprado(p_producto2);
    }

    @When("el usuario hace clic en el carrito")
    public void elUsuarioHaceClicEnElCarrito() {
        CompraService.clickCarrito();
    }

    @Then("^se muestra en el carrito el producto (.*)$")
    public void seMuestraEnElCarritoElProducto(String p_nombreProducto) {
        CompraService.verificarProductoCarrito(p_nombreProducto);

    }

    @And("el usuario esta en la pagina de checkout")
    public void elUsuarioEstaEnLaPaginaDeCheckout() {
        CompraService.verificarTituloCheckout();
    }

    @And("el usuario hace clic en checkout")
    public void elUsuarioHaceClicEnCheckout() {
        CompraService.clickCheckout();
    }

    @And("el usuario accede al checkout")
    public void elUsuarioAccedeAlCheckout() {
        CompraService.clickCarrito();
        CompraService.clickCheckout();
        CompraService.verificarTituloCheckout();
    }

    @When("^el usuario completa el campo nombre (.*)$")
    public void elUsuarioCompletaElCampoNombre(String p_nombre) {
        CompraService.completarCampoNombre(p_nombre);
    }

    @And("^el usuario completa el campo apellido (.*)$")
    public void elUsuarioCompletaElCampoApellido(String p_apellido) {
        CompraService.completarCampoApellido(p_apellido);
    }

    @And("^el usuario completa el campo codigo postal (.*)$")
    public void elUsuarioCompletaElCampoCodigoPostal(String p_codPostal) {
        CompraService.completarCampoCodigoPostal(p_codPostal);
    }

    @And("el usuario hace clic en Continue")
    public void elUsuarioHaceClicEnContinue() {
        CompraService.clickContinue();
    }

    @Then("se muestra la pagina de Overview")
    public void seMuestraLaPaginaDeOverview() {
        CompraService.verificarTituloOverview();
    }

    @And("^el precio de (.*) es correcto$")
    public void elPrecioDeEsCorrecto(String p_producto) {
        CompraService.verificarPrecioProducto(p_producto);
    }

    @Then("^el producto (.*) se muestra en la pagina de Overview$")
    public void elProductoSeMuestraEnLaPaginaDeOverview(String p_producto) {
        CompraService.verificarProductoOverview(p_producto);
    }

    @When("el usuario hace clic en el boton Finish")
    public void elUsuarioHaceClicEnElBotonFinish() {
        CompraService.clickFinish();
    }

    @Then("^se muestra el mensaje (.*)$")
    public void seMuestraElMensaje(String p_msj) {
        CompraService.verificarCompra(p_msj);

    }
}
