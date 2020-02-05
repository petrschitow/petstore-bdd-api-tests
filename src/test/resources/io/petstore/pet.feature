Feature: Operations with pets in the store

  Scenario: Add a new pet to the store
    Given I have randomly generated petId and save it to testContext
    And I have a json to create a new pet in the store with petId from testContext
    When I send POST-request to endpoint /pet with body from testContext to create a new pet
    Then I check that the status code is 200
    And I send GET-request to find pet with petId from testContext
    And I check that the status code is 200
    And I check that the returned json is equivalent to the json from the testContext

  Scenario: Delete a pet from the store
    Given I have randomly generated petId and save it to testContext
    And I have a json to create a new pet in the store with petId from testContext
    And I send POST-request to endpoint /pet with body from testContext to create a new pet
    And I check that the status code is 200
    When I send DELETE-request to delete Pet from store with petId from testContext
    Then I check that the status code is 200
    And I send GET-request to find pet with petId from testContext
    And I check that the status code is 404

