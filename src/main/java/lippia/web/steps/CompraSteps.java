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
        CompraService.clicCarrito();
    }

    @Then("^se muestra en el carrito el producto (.*)$")
    public void seMuestraEnElCarritoElProducto(String p_nombreProducto) {
        CompraService.verificarProductoCarrito(p_nombreProducto);

    }
}
