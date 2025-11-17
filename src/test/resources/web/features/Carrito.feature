@Carrito
Feature: Carrito
  
  Background:
    Given que el usuario inicia sesion exitosamente con el usuario standard_user y contraseña secret_sauce
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