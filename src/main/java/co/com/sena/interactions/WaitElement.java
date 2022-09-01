package co.com.sena.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitElement implements Interaction {
    private Target target;
    private  String state;

    public WaitElement(Target target, String state) {
        this.target = target;
        this.state = state;
    }

    @Override
    @Step("{0} waits the #target until be #state")
    public <T extends Actor> void performAs(T actor) {
        switch (state){
            case "Visible":
                waitAs(actor).until(ExpectedConditions.visibilityOf(target.resolveFor(actor)));
                break;
            case "Invisible":
                waitAs(actor).until(ExpectedConditions.invisibilityOf(target.resolveFor(actor)));
                break;
            case "Enabled":
                waitAs(actor).until(ExpectedConditions.elementToBeClickable(target.resolveFor(actor)));

        }

    }


    private WebDriverWait waitAs(Actor actor)
    { return new WebDriverWait(BrowseTheWeb.as(actor).getDriver(),180);}


    public static WaitElement untilAppears(Target target){
        return Tasks.instrumented(WaitElement.class,target,"Visible");

    }

    public static WaitElement untilDisappears(Target target){
        return Tasks.instrumented(WaitElement.class,target,"Invisible");
    }

    public static WaitElement untilBeEnable(Target target){
        return Tasks.instrumented(WaitElement.class,target,"Enabled");
    }



}
