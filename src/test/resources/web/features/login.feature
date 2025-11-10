@Login
  Feature: Login
  
  Background:
    Given que el usuario se encuentra en la pagina de login de saucedemo
  @LoginExitoso
  Scenario: Login Exitoso
    When el usuario completa el campo username standard_user
    And el usuario completa el campo password secret_sauce
    And el usuario hace clic en el boton Login
    Then el usuario visualiza el titulo de la pagina de productos
    
  @LoginUsuarioBloqueado
  Scenario: Login con usuario Bloqueado
    When el usuario completa el campo username locked_out_user
    And el usuario completa el campo password secret_sauce
    And el usuario hace clic en el boton Login
    Then el usuario visualiza el mensaje de error "Epic sadface: Sorry, this user has been locked out."
  