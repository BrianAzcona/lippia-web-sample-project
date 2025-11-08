@Login
  Feature: Login
  
  @LoginExitoso
  Scenario: Login Exitoso
    Given que el usuario se encuentra en la pagina de login de saucedemo
    When el usuario completa el campo ussername "standard_user"
    And el usuario completa el campo password "secret_sauce"
    And el usuario hace clic en el boton Login
    Then el usuario visualiza el titulo de la pagina de productos
    
    
    
    