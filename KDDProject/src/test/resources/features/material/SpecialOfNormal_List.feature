Feature: Search document in special of normal page
  As a business
  I want to add a new special of normal document
  So that I can import many drug packages

  Background: 
    Given I open website "http://203.190.173.37:8080/kinhdoanhduoc/Pages/login.zul"
    And I enter login form
      | username  | password |
      | 010203123 |      123 |
    And I logged in

  @list
  Scenario: Search document
    When I go to specical of list page
    Then I see total of documents per page
