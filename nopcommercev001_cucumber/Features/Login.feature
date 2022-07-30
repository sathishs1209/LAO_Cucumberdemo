Feature: Login

  Scenario: Succesful login with valid credentials
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters username as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When user click on Logout link
    Then Page title should be "Your store. Login"
    And Close browser
