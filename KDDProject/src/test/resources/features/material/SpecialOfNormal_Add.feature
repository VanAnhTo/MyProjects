Feature: Create a new document in special of normal material page
  As a business
  I want to add a new special of normal material order
  So that I can import many drug packages

  Background: 
    Given I open browser and enter link website "http://203.190.173.37:8080/kinhdoanhduoc/Pages/login.zul"
    And I fill login form
      | username  | password |
      | 010203123 |      123 |
    And I login

  Scenario Outline: Create order successful with valid values
    Given I go to specical of nomaral page
    When I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    And I enter material info list
      | materialName      | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration     | contentImport   |
      | Ten nguyen lieu 1 | Ham luong, dang bao che 1 |              3 | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Nong do cua thuoc | Ham luong thuoc |
      | Ten nguyen lieu 2 | Ham luong, dang bao che 2 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Nong do cua thuoc | Ham luong thuoc |
      | Ten nguyen lieu 3 | Ham luong, dang bao che 3 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Nong do cua thuoc | Ham luong thuoc |
    And I save document info
    Then I see the success message
    And I upload attachment files for document
      | fileType    | filePath                                |
      | CERTIFICATE | C:\\Users\\Admin\\Downloads\\Spirit.jpg |
      | QUALITY     | C:\\Users\\Admin\\Downloads\\Spirit.jpg |
      | METHOD      | C:\\Users\\Admin\\Downloads\\Spirit.jpg |
      | OTHER       | C:\\Users\\Admin\\Downloads\\Spirit.jpg |

    Examples: List of valid value
      | fileNumber  | signWhere |
      | SDH/2016/01 | Ha Noi    |

  #
  Scenario: Create order fail with empty order number
    Given I go to specical of nomaral page
    When I fill sign where field with value "<signWhere>"
    And I save without order number
    Then I see the invalid message

  #
  Scenario: Create order fail with empty sign place
    Given I go to specical of nomaral page
    When I fill file number field with value "<fileNumber>"
    And I save without sign place
    Then I see the invalid message

  #
  Scenario: Create order fail with empty materia on grid
    Given I go to specical of nomaral page
    When I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    And I save without material details
    Then I see the warning message

  #
  Scenario: Add material to grid fail with empty material name
    Given I go to specical of nomaral page
    When I enter material detail
      | materialName | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration     | contentImport   |
      |              | Ham luong, dang bao che 1 |              3 | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Nong do cua thuoc | Ham luong thuoc |
    And I add without material name
    Then I see an error message

  #
  Scenario: Add material to grid successful with empty content material
    Given I go to specical of nomaral page
    When I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    When I enter material detail
      | materialName      | contentMaterial | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration     | contentImport   |
      | Ten nguyen lieu 2 |                 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Nong do cua thuoc | Ham luong thuoc |
    And I save without content material
    And I save order
    Then I see the success message

  #--
  Scenario: Add material to grid fail with empty amout of material
    Given I go to specical of nomaral page
    When I enter material detail
      | materialName      | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration     | contentImport   |
      | Ten nguyen lieu 2 | Ham luong, dang bao che 2 |                | tan          | ISO             | SDK cua thuoc duoc SX | Nong do cua thuoc | Ham luong thuoc |
    And I save without amount of material
    Then I see an error message

  #--
  Scenario: Add material to grid fail with empty quality of material
    Given I go to specical of nomaral page
    When I enter material detail
      | materialName      | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration     | contentImport   |
      | Ten nguyen lieu 2 | Ham luong, dang bao che 2 |              1 | tan          |                 | SDK cua thuoc duoc SX | Nong do cua thuoc | Ham luong thuoc |
    And I save without quality of material
    Then I see an error message

  #
 
  Scenario: Add and verify material successful on grid
    Given I go to specical of nomaral page
    When I enter file number field with value "SDH/2016/01" and sign where field with value "Ha Noi"
    And I enter material info list
      | materialName      | contentMaterial         | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 2 | Ham luong, dang bao che |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    And I add to grid
    Then I see a material on grid

  #
  Scenario: Add order fail to grid without check checkbox commited
    Given I go to specical of nomaral page
    When I enter file number field with value "SDH/2016/01" and sign where field with value "Ha Noi"
    And I enter material info list
      | materialName      | contentMaterial         | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration     | contentImport   |
      | Ten nguyen lieu 2 | Ham luong, dang bao che |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Nong do cua thuoc | Ham luong thuoc |
    And I add order to grid without checkbox commited
    Then I see a warning message require check checkbox

  #
  Scenario Outline: Save material successful with multi case values of order number, place sign, material name
    Given I go to specical of nomaral page
    When I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    And I enter material info list
      | materialName   | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration     | contentImport   |
      | <materialName> | Ham luong, dang bao che 1 |              3 | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Nong do cua thuoc | Ham luong thuoc |
    And I save document info
    Then I see the success message

    Examples: List of valid value
      | fileNumber                                              | signWhere                                               | materialName                                                                                           |
      | (()(><#@#!^&(*#$%#!)_#$?SJH%^                           | ><#@#!^&(*#$%#!)_#$@!                                   | ''><#@#!^&(*#$%#!)_#$@!                                                                                |
      | SDH SDH SDH SDH SDH SDH SDH SDH SDH SDH SDH SDH SDH SDH | Ha Noi Ha Noi Ha Noi Ha Noi Ha Noi Ha Noi Ha Noi Ha Noi | Ten nguyen lieu 3 Ten nguyen lieu 3 Ten nguyen lieu 3 Ten nguyen lieu 3 Ten nguyen lieu 3 Ten nguyen l |
      | <a>linktex</a>                                          | <em>Without</em>                                        | <b>Bold</b>                                                                                            |

@add
  Scenario: Edit and verify material on textbox
    Given I go to specical of nomaral page
    When I enter file number field with value "SDH/2016/01" and sign where field with value "Ha Noi"
    And I enter material info list
      | materialName      | contentMaterial         | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 2 | Ham luong, dang bao che |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    And I add to grid
    And I click edit button
    #Then I see a material on grid

      
      