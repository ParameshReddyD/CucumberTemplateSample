package hellocucumber.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test1234 {

    @Given("I have {int} cucumbers in my basket")
    public void i_have_cucumbers_in_my_basket(int cucumberCount) {
        // Step implementation
    }

    @When("I eat {int} cucumbers")
    public void i_eat_cucumbers(int cucumberCount) {
        // Step implementation
    }

    @Then("I should have {int} cucumbers left")
    public void i_should_have_cucumbers_left(int cucumberCount) {
        // Step implementation
    }
}
