Feature: Gestionar pedidos

  @crearPedido
  Scenario Outline: Crear pedidos
    When creo el pedido con id "<ID>", pedID "<petID>", quantity "<quantity>", shipDate"<shipDate>", status "<status>", complete, "<complete>"
    Then el código de respuesta de pedido es 200
    And el campo status es "placed"
    Examples:
      | ID | petID | quantity |        shipDate        | status | complete |
      |  10 |   1   |   1     |2024-08-25T22:18:40.704Z| placed |   true   |
      |  20 |   2   |   2     |2024-08-25T22:18:45.704Z| placed |   true   |
      |  30 |   3   |   3     |2024-08-25T22:18:50.704Z| placed |   true   |

  @consultarPedido
  Scenario Outline: Consultar los pedidos

    Given consulto el pedido con ID "<ID>"
    Then el código de respuesta de pedido es 200
    And el campo status es "placed"
    Examples:
      | ID |
      | 10 |
      | 20 |
      | 30 |


