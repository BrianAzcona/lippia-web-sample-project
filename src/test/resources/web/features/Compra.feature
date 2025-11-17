@Compra
Feature: Compra completa y validación de datos
  
  Background:
    Given que el usuario inicia sesion exitosamente con el usuario standard_user y contraseña secret_sauce
  
  @AgregarDosProductos
  Scenario: Agregar dos productos diferentes al carrito
    When el usuario agrega el producto Sauce Labs Backpack al carrito
    And el usuario agrega el producto Sauce Labs Bike Light al carrito
    Then el contador del carrito muestra el numero 2
  
  @VerificarProductosCarrito
  Scenario: Verificar productos en el carrito
    And el usuario agrega el producto Sauce Labs Backpack al carrito
    And el usuario agrega el producto Sauce Labs Bike Light al carrito
    When el usuario hace clic en el carrito
    Then se muestra en el carrito el producto Sauce Labs Backpack
    And se muestra en el carrito el producto Sauce Labs Bike Light
  
  @CheckoutInformacion
  Scenario Outline: Completar información del checkout
    And el usuario agrega el producto Sauce Labs Backpack al carrito
    And el usuario agrega el producto Sauce Labs Bike Light al carrito
    And el usuario accede al checkout
    When el usuario completa el campo nombre <nombre>
    And el usuario completa el campo apellido <apellido>
    And el usuario completa el campo codigo postal <codigoPostal>
    And el usuario hace clic en Continue
    Then se muestra la pagina de Overview
    
    Examples:
      | nombre | apellido  | codigoPostal |
      | Brian  | Azcona    | 3400         |
      | Mica   | Fernandez | 3500         |
  
  @ValidarResumen
  Scenario Outline: Validar productos y precios en el resumen
    And el usuario agrega el producto Sauce Labs Backpack al carrito
    And el usuario agrega el producto Sauce Labs Bike Light al carrito
    And el usuario accede al checkout
    And el usuario completa el campo nombre <nombre>
    And el usuario completa el campo apellido <apellido>
    And el usuario completa el campo codigo postal <codigoPostal>
    And el usuario hace clic en Continue
    And se muestra la pagina de Overview
    Then el producto Sauce Labs Backpack se muestra en la pagina de Overview
    And el producto Sauce Labs Bike Light se muestra en la pagina de Overview
    And el precio de Sauce Labs Backpack es correcto
    And el precio de Sauce Labs Bike Light es correcto
    
    
    Examples:
      | nombre | apellido  | codigoPostal |
      | Brian  | Azcona    | 3400         |
      | Mica   | Fernandez | 3500         |
  
  @FinalizarCompra
  Scenario Outline: Finalizar la compra exitosamente
    And el usuario agrega el producto Sauce Labs Backpack al carrito
    And el usuario agrega el producto Sauce Labs Bike Light al carrito
    And el usuario accede al checkout
    And el usuario completa el campo nombre <nombre>
    And el usuario completa el campo apellido <apellido>
    And el usuario completa el campo codigo postal <codigoPostal>
    And el usuario hace clic en Continue
    And se muestra la pagina de Overview
    And el producto Sauce Labs Backpack se muestra en la pagina de Overview
    And el producto Sauce Labs Bike Light se muestra en la pagina de Overview
    And el precio de Sauce Labs Backpack es correcto
    And el precio de Sauce Labs Bike Light es correcto
    When el usuario hace clic en el boton Finish
    Then se muestra el mensaje Thank you for your order!
    
    Examples:
      | nombre | apellido  | codigoPostal |
      | Brian  | Azcona    | 3400         |
      | Mica   | Fernandez | 3500         |