Feature: Operations with pets in the store

  Scenario: Adding a new pet to the store
    Given I have json for create a new pet with random data
    When I send request to add new pet to the store
    Then I check that status code is 200

  Scenario: Delete a pet from the store
   Given I have already created Pet in the store with random data
    When I delete pet with id = 5 from the store