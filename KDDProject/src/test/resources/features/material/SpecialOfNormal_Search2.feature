Feature: Search orders special of normal are created
  As a business
  I want to search order special of normal
  So that I see the results of searching

  Background: 
    Given I open browser and enter link website "http://203.190.173.37:8080/kinhdoanhduoc/Pages/login.zul"
    And I fill login form
      | username  | password |
      | 010203123 |      123 |
    And I login

  Scenario: Searching with default data
    Given I navigate to search form
    When I fill created date from: "<createdDateFrom>", created date to: "<createdDateTo>"
    And I click the search button
    Then I verify range date warning