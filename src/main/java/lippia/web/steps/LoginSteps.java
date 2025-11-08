package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.LoginServices;



public class LoginSteps extends PageSteps {


    @Given("que el usuario se encuentra en la pagina de login de saucedemo")
    public void queElUsuarioSeEncuentraEnLaPaginaDeLoginDeSaucedemo() {
        LoginServices.navWeb();
    }

    @When("el usuario completa el campo ussername {string}")
    public void elUsuarioCompletaElCampoUssername(String p_user) {
        LoginServices.ingresarUsuario(p_user);
    }


    @And("el usuario completa el campo password {string}")
    public void elUsuarioCompletaElCampoPassword(String p_pass) {
        LoginServices.ingresarPassword(p_pass);
    }

    @And("el usuario hace clic en el boton Login")
    public void elUsuarioHaceClicEnElBotonLogin() {
        LoginServices.clikLogin();
    }

    @Then("el usuario visualiza el titulo de la pagina de productos")
    public void elUsuarioVisualizaElTituloDeLaPaginaDeProductos() {
        LoginServices.verificarTituloProductos();
    }
}
