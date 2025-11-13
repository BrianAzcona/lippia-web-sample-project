@Compra
Feature: Compra completa y validación de datos
  
  Background:
    Given que el usuario inicia sesion exitosamente con el usuario standard_user
  
  @AgregarDosProductos
  Scenario: Agregar dos productos diferentes al carrito
    When el usuario agrega el producto Sauce Labs Backpack al carrito
    And el usuario agrega el producto Sauce Labs Bike Light al carrito
    Then el contador del carrito muestra el numero 2
  
  @VerificarProductosCarrito
  Scenario: Verificar productos en el carrito
    And el usuario tiene los productos Sauce Labs Backpack y Sauce Labs Bike Light en el carrito
    When el usuario hace clic en el carrito
    Then se muestra en el carrito el producto Sauce Labs Backpack
    And se muestra en el carrito el producto Sauce Labs Bike Light