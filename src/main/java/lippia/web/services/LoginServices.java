package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import junit.framework.Assert;
import lippia.web.constants.LoginConstants;


import static com.crowdar.core.actions.WebActionManager.navigateTo;
import static lippia.web.constants.LoginConstants.*;


public class LoginServices extends ActionManager {
    public static void navWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void ingresarUsuario(String p_user){
        setInput(INPUT_USER_XPATH, p_user);
    }

    public static void ingresarPassword(String p_pass){
        setInput(INPUT_PASS_XPATH, p_pass);
    }

    public static void clikLogin(){
        click(BUTTON_XPATH);
    }

    public static void verificarTituloProductos(){
        Assert.assertTrue("El elemento no se a encontrado",isPresent(LoginConstants.TITLE_XPATH));
    }

}
