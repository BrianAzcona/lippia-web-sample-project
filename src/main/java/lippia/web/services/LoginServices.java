package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import junit.framework.Assert;
import lippia.web.constants.LoginConstants;


import static com.crowdar.core.actions.WebActionManager.navigateTo;



public class LoginServices extends ActionManager {
    public static void navWeb() {

        navigateTo(PropertyManager.getProperty("web.base.url"));

    }

    public static void ingresarUsuario(String p_user){

        setInput(LoginConstants.INPUT_USER_XPATH, p_user);
    }

    public static void ingresarPassword(String p_pass){
        setInput(LoginConstants.INPUT_PASS_XPATH, p_pass);
    }

    public static void clikLogin(){
        click(LoginConstants.BUTTON_XPATH);
    }

    public static void verificarTituloProductos(){
        Assert.assertTrue("El elemento no se a encontrado",isPresent(LoginConstants.TITLE_XPATH));
    }
    public static void verificarMensajeErrorLogin(String p_msj){
        Assert.assertEquals("El mensaje no coincide con el esperado", p_msj, getElement(LoginConstants.MESSAGE_ERROR_XPATH).getText());

    }

}
