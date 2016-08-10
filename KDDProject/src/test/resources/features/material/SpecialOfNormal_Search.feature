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

  Scenario Outline: Searching with order number
    Given I go to specical of list page
    When I want to search with order number: "<orderNumber>", created date from: "<createdDateFrom>", created date to: "<createdDateTo>"
    And I click the button Search
    Then I see the results of searching on the list
    Then I see total of documents per page
    And I see page number on grid

    Examples: 
      | orderNumber | createdDateFrom | createdDateTo |
      |             | 1/1/2016        | 1/1/2015      |

  Scenario Outline: Searching with order number
    Given I go to specical of list page
    When I search with invalid issued date: "<createdDateFrom>"
    And I click the button Search
    And I see the error tooltip

    Examples: 
      | createdDateFrom |
      | aaaaaa          |

  Scenario: Searching empty result
    Given I go to specical of list page
    When I search with a order number not in database : "vvvvv"
    And I click the button Search
    Then I see empty message
    And Empty order on the grid

  @search
  Scenario Outline: Searching with order number
    Given I go to specical of list page
    When I want to search with order number: "<orderNumber>", created date from: "<createdDateFrom>", created date to: "<createdDateTo>"
    And I click the button Search
    Then I see a warning message

    Examples: 
      | orderNumber | createdDateFrom | createdDateTo |
      |             | 1/1/2015        | 1/1/2015      |

  Scenario: Searching with over maxlength order number
    Given I go to specical of list page
    When I search with a order number not in database : "Lorem ipsum dolor sit amet, consectetur adipisicing elit, seddddddddddddd"
    And I click the button Search
    Then I see the over maxlength messsage
