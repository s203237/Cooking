Feature: app feature

  Scenario: Search page
    Given I am on the search page
    When I fill search box with tofu
    And I click enter
    Then I should see a list of tofu recipes

  Scenario: navigation bar
    Given I am on the homepage
    When I click search button on the navigation bar
    Then I should see the search screen

  Scenario: get recipe details
    Given I am on the home page
    When I see the recipe card for miso and butternut soup
    And I tap on the image
    Then I should see the info page for miso and butternut soup

  Scenario: get cooking instructions
    Given I am on recipe page for miso and butternut soup
    When I tap on the preparation tab
    Then I should see the steps required to cook the miso and butternut soup