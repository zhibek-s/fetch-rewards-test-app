Feature: Fetch Rewards

  Background: Setup
    Given setup for device "android"

    @like
    Scenario: Like Fetch Rewards App on Facebook
      Given user logins to facebook app with credentials "bobadams090909@gmail.com", "boba090909"
      When user searches and opens page "fetch rewards"
      Then user clicks on like button