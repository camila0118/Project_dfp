package co.com.sena.tasks;


import co.com.sena.usersinterface.Closepage;
import co.com.sena.usersinterface.Initialpage;
import co.com.sena.usersinterface.Loginpage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(Initialpage.BTN_LOGIN));
        actor.attemptsTo(Enter.theValue("1061694589").into(Loginpage.TXT_USER));
        actor.attemptsTo(Enter.theValue("camidorado0118").into(Loginpage.TXT_PASSWORD));
        actor.attemptsTo(Click.on(Loginpage.BTN_BEGINNING));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actor.attemptsTo(Click.on(Closepage.BTN_CLOSE));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actor.attemptsTo(Click.on(Initialpage.BTN_LOGIN));
        actor.attemptsTo(Enter.theValue("camila123").into(Loginpage.TXT_USER));
        actor.attemptsTo(Enter.theValue("ckjnc").into(Loginpage.TXT_PASSWORD));
        actor.attemptsTo(Click.on(Loginpage.BTN_BEGINNING));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    public static Login enter() {
        return Tasks.instrumented(Login.class);
    }
}
