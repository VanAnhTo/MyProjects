Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: Print title, url
    Given I open pharmacy website to add
    And After I enter username: "010203123" and password: "123"
    And I login
    When I go to specical of nomarl page
    And I enter file number:"SDH20177" and Sign where: "Ha Noi"
    And I enter material name: "Ten nguyen lieu thuong" , ham luong:"Ham luong, dang bao che", so luong: "20", don vi tinh: "kg" TCCL: "TCCL"
    And I enter SDK cua thuoc: "SDK cua thuoc duoc SX" , ham luong cua thuoc: "Ham luong cua thuoc" , dang bao che cua thuoc: "dang bao che"
    Then I save infomation

  Scenario: Print title, url
    Given I open pharmacy website to add
    And After I enter username: "010203123" and password: "123"
    And I login
    When I go to specical of nomarl page
    And I enter file number:"SDH20177" and Sign where: "Ha Noi"
    And I enter material name: "Ten nguyen lieu thuong" , ham luong:"Ham luong, dang bao che", so luong: "20", don vi tinh: "kg" TCCL: "TCCL"
    And I enter SDK cua thuoc: "SDK cua thuoc duoc SX" , ham luong cua thuoc: "Ham luong cua thuoc" , dang bao che cua thuoc: "dang bao che"
    Then I save infomation
