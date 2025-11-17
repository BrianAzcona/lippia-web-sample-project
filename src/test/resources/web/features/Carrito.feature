@Carrito
Feature: Carrito
  
  Background:
    Given que el usuario se encuentra en la pagina de login de Saucedemo
    And el usuario completa el campo username standard_user
    And el usuario completa el campo password secret_sauce
    And el usuario hace clic en el boton Login
    And el usuario visualiza el titulo de la pagina de productos
  
  @AgregarCarrito
  Scenario: Agregar producto al carrito
    When el usuario agrega el producto Sauce Labs Backpack al carrito
    Then el contador del carrito muestra el numero 1
  
  @EliminarCarrito
  Scenario: Eliminar producto del carrito
    And el usuario agrega el producto Sauce Labs Backpack al carrito
    And el contador del carrito muestra el numero 1
    When el usuario elimina el producto Sauce Labs Backpack del carrito
    Then el carrito no posee productos