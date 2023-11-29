Feature: Searching
  Scenario Outline: Searching for recipe
    Given I am on the search page
    When I fill search box with <keywords>
    And I click enter
    Then I should see a list of tofu recipes
    Examples:
      | keywords |  |
      | tofu     |/
