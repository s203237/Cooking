package com.example.cooking

import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then


class StepDefinitions1 {
    @Given("I am on the search page")
    fun theAppIsOpen() {
        // Implementation for opening the app
    }

    @io.cucumber.java.en.When("I fill search box with tofu")
    fun iPerformASampleAction() {
        // Implementation for performing the sample action
    }

    @And("I click enter")
    fun iPerformAction() {
        // Implementation for performing the sample action
    }

    @Then("I should see a list of tofu recipes")
    fun iShouldSeeTheResult() {
        // Implementation for verifying the result
    }

}

