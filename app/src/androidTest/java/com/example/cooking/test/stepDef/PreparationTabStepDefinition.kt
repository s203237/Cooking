package com.example.cooking.test.stepDef

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then

class PreparationTabStepDefinition {
    @Given("I am on recipe page for miso and butternut soup")
    fun theAppIsOpen() {
        // Implementation for opening the app
    }

    @io.cucumber.java.en.When("I tap on the preparation tab")
    fun iPerformASampleAction() {
        // Implementation for performing the sample action
    }

    @Then("I should see the steps required to cook the miso and butternut soup")
    fun iShouldSeeTheResult() {
        // Implementation for verifying the result
    }

}