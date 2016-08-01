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

@wip
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
