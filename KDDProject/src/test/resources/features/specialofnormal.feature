Feature: Add new special of normal file

  Background: 
    Given I open pharmacy website to add
    And After I fill login form
      | username  | password |
      | 010203123 |      123 |
    And I login

  Scenario: Add new fail with invalid amout material
    When I go to specical of nomarl page
    And I enter file number:"123" and Sign where: "123"
    And I fill material info
      | materialName       | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 11 | Ham luong, dang bao che 1 | qqq            | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 2  | Ham luong, dang bao che 2 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 3  | Ham luong, dang bao che 3 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    Then I save infomation

  Scenario Outline: Add new successfull with valid values
    When I go to specical of nomarl page
    And I enter file number:"<fileNumber>" and Sign where: "<signWhere>"
    And I fill material info
      | materialName       | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
      | Ten nguyen lieu 11 | Ham luong, dang bao che 1 |              1 | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 2  | Ham luong, dang bao che 2 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
      | Ten nguyen lieu 3  | Ham luong, dang bao che 3 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
    Then I save infomation

    Examples: 
      | fileNumber | signWhere |
      | so1        | diachi1   |
      | so2        | diachi2   |
