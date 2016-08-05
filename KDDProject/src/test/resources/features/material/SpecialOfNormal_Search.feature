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

  Scenario: Searching with defaut data
    Given I go to specical of list page
    And I click the button Search
    Then I see the results of searching on the list
    Then I see total of documents per page
    And I see page number on grid

  @search
  Scenario Outline: Searching with order number
    Given I go to specical of list page
    When I want to search with order number: "<orderNumber>", created date from: "<createdDateFrom>", created date to: "<createdDateTo>"
    And I click the button Search
    Then I see the results of searching on the list
    Then I see total of documents per page
    And I see page number on grid

    Examples: 
      | orderNumber | createdDateFrom | createdDateTo |
      | vvv         | 1/1/2016            | 1/1/2016      |

  Scenario Outline: Searching with order number
    Given I go to specical of list page
    When I search with invalid issued date: "<createdDateFrom>"
    And I click the button Search
    And I see the error tooltip

    Examples: 
      | createdDateFrom |
      | aaaaaa          |
