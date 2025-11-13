@Carrito
Feature: Carrito
  
  Background:
    Given que el usuario inicia sesion exitosamente con el usuario standard_user
  
  @AgregarCarrito
  Scenario: Agregar producto al carrito
    When el usuario agrega el producto Sauce Labs Backpack al carrito
    Then el contador del carrito muestra el numero 1
  
  @EliminarCarrito
  Scenario: Eliminar producto del carrito
    And el usuario tiene el producto Sauce Labs Backpack en el carrito con cantidad 1
    When el usuario elimina el producto Sauce Labs Backpack del carrito
    Then el carrito no posee productos