package lippia.web.steps;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.CarritoServices;
import lippia.web.services.LoginServices;

public class CarritoSteps extends PageSteps{

    @Given("que el usuario inicia sesion exitosamente con el usuario {string}")
    public void queElUsuarioIniciaSesionExitosamenteConElUsuario(String p_user) {
        LoginServices.navWeb();
        LoginServices.ingresarUsuario(p_user);
        LoginServices.ingresarPassword("secret_sauce");
        LoginServices.clikLogin();
        LoginServices.verificarTituloProductos();
    }

    @When("el usuario agrega el producto {string} al carrito")
    public void elUsuarioAgregaElProductoAlCarrito(String p_product) {
        CarritoServices.agregarProductoCarrito(p_product);
    }

    @Then("el contador del carrito muestra el numero {string}")
    public void elContadorDelCarritoMuestraElNumero(String p_cantidad) {
        CarritoServices.verificarCarritoProducto(p_cantidad);
    }

    @And("el usuario tiene el producto {string} en el carrito con cantidad {string}")
    public void elUsuarioTieneElProductoEnElCarrito(String p_product, String p_cantidad) {
        CarritoServices.agregarProductoCarrito(p_product);
        CarritoServices.verificarCarritoProducto(p_cantidad);
    }

    @When("el usuario elimina el producto del carrito")
    public void elUsuarioEliminaElProductoDelCarrito() {
        CarritoServices.eliminarProductoCarrito();
    }

    @Then("el carrito no posee productos")
    public void elCarritoNoPoseeProductos() {
        CarritoServices.verificarCarritoVacio();
    }
}
