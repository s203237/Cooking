package com.example.cooking.test.stepDef

import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then

class RecipePageStepDefinitions {
    @Given("I am on the home page")
    fun theAppIsOpen() {
        // Implementation for opening the app
    }

    @io.cucumber.java.en.When("I see the recipe card for miso and butternut soup")
    fun iPerformASampleAction() {
        // Implementation for performing the sample action
    }
    @And("I tap on the image")
    fun iPerformAction() {
        // Implementation for performing the sample action
    }

    @Then("I should see the info page for miso and butternut soup")
    fun iShouldSeeTheResult() {
        // Implementation for verifying the result
    }


}