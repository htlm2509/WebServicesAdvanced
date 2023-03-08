@ApiTest
Feature: Api Add Product To Cart
  As a customer
  I want to be able to add product to cart
  So that I can proceed with placing the order

  Scenario: Add product to cart via API, review cart via UI
    Given I have created the cart via API
    But I have added the following products of corresponding quantity to the cart via API
      | Code    | Quantity |
      | 2876350 | 1        |
    When I authenticate to the web application by adding kvn-cart cookie with guid value
    But I navigate to Cart page via UI
    Then I should see the expected product of corresponding quantity in the Cart via UI
      | Name                                  | Quantity |
      | KRUIDVAT SENSITIVE HANDZEEP NAVULLING | 1        |