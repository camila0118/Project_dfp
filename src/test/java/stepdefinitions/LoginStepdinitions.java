package stepdefinitions;

import co.com.sena.tasks.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class LoginStepdinitions {

    @Managed
    WebDriver hisBrowser;

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("User");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    }

        @Given("El usuario esta en la pagina")
        public void elUsuarioEstaEnLaPagina () {
            OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://develdfp.cloudsenactpi.net/#/home"));
        }
        @When("El usuario ingresa las credenciales")
        public void elUsuarioIngresaLasCredenciales () {
            OnStage.theActorInTheSpotlight().attemptsTo(Login.enter());
        }
        @Then("puede ver los datos")
        public void puedeVerLosDatos () {

        }

}
