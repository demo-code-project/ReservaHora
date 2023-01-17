@tag
Feature: Test Add agenda

  @tag1
  Scenario Outline: Check login is successful with valid credentials
    Given browser is open1
    And user is on login page1
    Then user enters <username> y <password>
    And user clicks on login1
    Then user is navigated to the home page1
    And user navega al formulario registro agenda
    Then user es redirigido al formulario de registro de agenda
    When user ingresa <idMascota> y <fecha>
    And user pulsa en Registrar
    
    Examples: 
      | username | password	| idMascota | fecha							 	|
      | admin    | admin		| 1			    | 2023-01-16 07:00		|
    
