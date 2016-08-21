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

  Scenario Outline: Create order successfully with valid values
    Given I go to specical of nomaral page
    When I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    And I enter material info list
      | materialName      | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 1 | Ham luong, dang bao che 1 |              3 | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 2 | Ham luong, dang bao che 2 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 3 | Ham luong, dang bao che 3 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
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
  Scenario: Create order not successfully with empty order number
    Given I go to specical of nomaral page
    When I fill sign where field with value "<signWhere>"
    And I save without order number
    Then I see the invalid message

  #
  Scenario: Create order not successfully with empty sign place
    Given I go to specical of nomaral page
    When I fill file number field with value "<fileNumber>"
    And I save without sign place
    Then I see the invalid message

  #
  Scenario: Create order not successfully with empty materia on grid
    Given I go to specical of nomaral page
    When I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    And I save without material details
    Then I see the warning message

  #
  Scenario: Add material to grid not successfully with empty material name
    Given I go to specical of nomaral page
    When I enter material detail
      | materialName | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      |              | Ham luong, dang bao che 1 |              3 | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    And I add without material name
    Then I see an error message

  #
  Scenario: Add material to grid successfully with empty content material
    Given I go to specical of nomaral page
    When I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    When I enter material detail
      | materialName      | contentMaterial | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 2 |                 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    And I save without content material
    And I save order
    Then I see the success message

  #--
  Scenario: Add material to grid not successfully with empty amout of material
    Given I go to specical of nomaral page
    When I enter material detail
      | materialName      | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 2 | Ham luong, dang bao che 2 |                | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    And I save without amount of material
    Then I see an error message

  #--
  Scenario: Add material to grid not successfully with empty quality of material
    Given I go to specical of nomaral page
    When I enter material detail
      | materialName      | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 2 | Ham luong, dang bao che 2 |              1 | tan          |                 | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    And I save without quality of material
    Then I see an error message

  @add
  Scenario: Add material to grid successfully with empty content material
    Given I go to specical of nomaral page
    When I enter material detail
      | materialName      | contentMaterial         | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 2 | Ham luong, dang bao che |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    And I save without content material
    Then I see a material on grid
