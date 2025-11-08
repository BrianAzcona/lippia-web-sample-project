package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class LoginService extends ActionManager {
    public static void navWebs(){
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }
}
