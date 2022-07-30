Feature: Customer

  Scenario: Add a new customer
    Given User launch chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters username as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User can view Dashboard
    When User click on customer menu
    And Click on customers menu item
    And Click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And Click on save button
    Then user can view configuration message "The new customer has been added successfully."
    And Close browser

  Scenario: Search customer by email ID
    Given User launch chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters username as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User can view Dashboard
    When User click on customer menu
    And Click on customers menu item
    And Enter customer Email
    When Click on search button
    Then User should find email in search table
    And Close browser
