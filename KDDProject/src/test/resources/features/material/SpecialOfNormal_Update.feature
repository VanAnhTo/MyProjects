Feature: Update a new document in special of normal page 
	As a business
	I want to add a new special of normal document
 	So that I can import drug packages 

Background: 
	Given I open browser and enter link website "http://203.190.173.37:8080/kinhdoanhduoc/Pages/login.zul" 
	And I fill login form 
		| username  | password |
		| 010203123 |      123 |
	And I login 

@wip	
Scenario Outline: Update a new document
	When I go to specical of nomaral page 
	And I enter file number field with value "<fileNumber>" and sign where field with value "<signWhere>" 
	And I enter material info list 
		| materialName       | contentMaterial           | amountMaterial | unitMaterial | qualityMaterial | registrationNumber    | contentration       | contentImport      |
		| Ten nguyen lieu 1  | Ham luong, dang bao che 1 |              1 | tan          | 2015/11/11      | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
		| Ten nguyen lieu 2  | Ham luong, dang bao che 2 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
		| Ten nguyen lieu 3  | Ham luong, dang bao che 3 |             20 | tan          | ISO             | SDK cua thuoc duoc SX | Ham luong cua thuoc | dang bao che thuoc |
		
	And I save document info 
	And I upload attachment files for document with path of file "C:\Users\Administrator\Pictures\Background\tumblr_mwnjhfcLci1qbd81ro1_1280.jpg"
	
	Examples: List of valid value 
		| fileNumber | signWhere |
		| so3        | diachi3   |
		
