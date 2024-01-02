Feature: app feature

  Scenario: user login app
    Given the app is open
    When user enter name and email
    Then user goes into homepage scream

  Scenario: navigation bar
    Given user is staying at homepage scream
    When user click on the navigation bar
    Then user should see cream change