package com.example.cooking.test

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then

class NavigationBarStepDefinition {
    @Given("I am on the homepage")
    fun theAppIsOpen() {
        // Implementation for opening the app
    }

    @io.cucumber.java.en.When("I click search button on the navigation bar")
    fun iPerformASampleAction() {
        // Implementation for performing the sample action
    }

    @Then("I should see the search screen")
    fun iShouldSeeTheResult() {
        // Implementation for verifying the result
    }

}