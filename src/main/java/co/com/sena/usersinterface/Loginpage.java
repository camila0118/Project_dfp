package co.com.sena.usersinterface;

import net.serenitybdd.screenplay.targets.Target;

public class Loginpage {
    public static final Target TXT_USER = Target.the("Usuario*")
            .locatedBy("//input[@id='usuario']");

    public static final Target TXT_PASSWORD = Target.the("Contraseña*")
            .locatedBy("//input[@id='password']");

    public static final Target BTN_BEGINNING = Target.the("Click on the button 'Iniciar sesion'")
            .locatedBy("//button[@class='btn my-4 btn-naranja-sena']");

}
