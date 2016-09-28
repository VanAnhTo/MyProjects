Feature: Create a new document in normal page
  As a business
  I want to create a new normal material order

  Background: 
    Given I open browser and enter link website "http://125.212.133.235:8002/kinhdoanhduoc/Pages/login.zul"
    And I fill login form
      | username | password |
      | 01020304 |      123 |
    And I login

  @add
  Scenario Outline: Create normal material order successful with valid values
    Given I go to nomaral page
    When I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>"
    And I enter materials info
      | materialName      | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber     | quyCachDongGoi      |
      | Ten nguyen lieu 1 | Ham luong, dang bao che 1 |              3 | tan          | TCCS            | SDK cua thuoc duoc SX1 | quy cach dong goi 1 |
      | Ten nguyen lieu 2 | Ham luong, dang bao che 2 |             20 | tan          | ISO             | SDK cua thuoc duoc SX2 | quy cach dong goi 2 |
      | Ten nguyen lieu 3 | Ham luong, dang bao che 3 |             10 | tan          | TCNSX           | SDK cua thuoc duoc SX3 | quy cach dong goi 3 |
    And I save normal material order
    Then I see the success message
    And I upload attachment files for document
      | fileType    | filePath                                |
      | CERTIFICATE | C:\\Users\\Admin\\Downloads\\Spirit.jpg |
      | QUALITY     | C:\\Users\\Admin\\Downloads\\Spirit.jpg |
      | METHOD      | C:\\Users\\Admin\\Downloads\\Spirit.jpg |
      | OTHER       | C:\\Users\\Admin\\Downloads\\Spirit.jpg |

    Examples: List of valid value
      | fileNumber  | signWhere |
      | 01/2016/DVN | New York  |
