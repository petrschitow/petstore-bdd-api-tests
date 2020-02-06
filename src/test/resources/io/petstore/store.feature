@store
Feature: Operations with store

Scenario: Placing an order to buy a pet and verification of order status
  Given I have randomly generated 'petId' and save it to testContext
  And I have a json to create a new pet in the store with petId from testContext
  And I send POST-request to endpoint /pet with body from testContext to create a new pet
  And I check that the status code is 200
  And I have randomly generated 'orderId' and save it to testContext
  And I have a json to placing an order in the store with petId from testContext
  When I send a json to place a order to endpoint /store/order with body from testContext
  Then I check that the status code is 200
  And I send GET-request to find placed order with petId from testContext
  And I check that the status code is 200
  And I check response with information about placed order

