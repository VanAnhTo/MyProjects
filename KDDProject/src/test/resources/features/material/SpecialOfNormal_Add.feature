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
    When I go to specical of nomaral page
    And I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    And I enter material info list
      | materialName      | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 1 | Ham luong, dang bao che 1 |              3 | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 2 | Ham luong, dang bao che 2 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 3 | Ham luong, dang bao che 3 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    And I save document info
    And I upload attachment files for document
      | fileType    | filePath                                |
      | CERTIFICATE | C:\\Users\\Admin\\Downloads\\Spirit.jpg |
      | QUALITY     | C:\\Users\\Admin\\Downloads\\Spirit.jpg |
      | METHOD      | C:\\Users\\Admin\\Downloads\\Spirit.jpg |
      | OTHER       | C:\\Users\\Admin\\Downloads\\Spirit.jpg |

    Examples: List of valid value
      | fileNumber  | signWhere |
      | SDH/2016/01 | Ha Noi    |

  Scenario Outline: Create order not successfully with empty order number
    When I go to specical of nomaral page
    And I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    And I enter material info list
      | materialName      | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 1 | Ham luong, dang bao che 1 |              3 | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 2 | Ham luong, dang bao che 2 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 3 | Ham luong, dang bao che 3 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    And I save document info
    Then I see the message invalid value

    Examples: List of valid value
      | fileNumber | signWhere |
      |            | Ha Noi    |

  Scenario Outline: Create order not successfully with empty sign place
    When I go to specical of nomaral page
    And I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    And I enter material info list
      | materialName      | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 1 | Ham luong, dang bao che 1 |              3 | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 2 | Ham luong, dang bao che 2 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 3 | Ham luong, dang bao che 3 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    And I save document info
    Then I see the message invalid value

    Examples: List of valid value
      | fileNumber  | signWhere |
      | SDH/2016/02 |           |


  Scenario Outline: Create order not successfully with empty materia on grid
    When I go to specical of nomaral page
    And I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    And I save document info
    Then I see the message invalid value

    Examples: List of valid value
      | fileNumber | signWhere |
      |            | Ha Noi    |


  Scenario Outline: Add material to grid not successfully with empty material name
    When I go to specical of nomaral page
    And I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    And I enter material info list
      | materialName      | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 1 | Ham luong, dang bao che 1 |              3 | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      |                   | Ham luong, dang bao che 2 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 3 | Ham luong, dang bao che 3 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    Then I see an error message

    Examples: List of valid value
      | fileNumber  | signWhere |
      | SDH/2016/02 | Ha Noi    |


  Scenario Outline: Add material to grid successfully with empty contenmaterial
    When I go to specical of nomaral page
    And I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    And I enter material info list
      | materialName      | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 1 | Ham luong, dang bao che 1 |              3 | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 2 |                           |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 3 | Ham luong, dang bao che 3 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    And I add material to grid
    And I save order 
    Then I see an success message

    Examples: List of valid value
      | fileNumber  | signWhere |
      | SDH/2016/02 | Ha Noi    |

 @hoangnl
  Scenario Outline: Add material to grid not successfully with empty amout of material
    When I go to specical of nomaral page
    And I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    And I enter material info list
      | materialName      | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 1 | Ham luong, dang bao che 1 |              3 | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 2 | Ham luong, dang bao che 2 |                | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 3 | Ham luong, dang bao che 3 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    And I add material to grid
    Then I see an error message

    Examples: List of valid value
      | fileNumber  | signWhere |
      | SDH/2016/02 | Ha Noi    |

Scenario Outline: Add material to grid not successfully with invalid value amout of material
    When I go to specical of nomaral page
    And I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    And I enter material info list
      | materialName      | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 1 | Ham luong, dang bao che 1 |              3 | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 2 | Ham luong, dang bao che 2 |            abc | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 3 | Ham luong, dang bao che 3 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    #And I add material to grid
    Then I see an error message

    Examples: List of valid value
      | fileNumber  | signWhere |
      | SDH/2016/02 | Ha Noi    |