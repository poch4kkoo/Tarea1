# Tarea1
Integrantes:
Javiera Antonia Diaz Grandon 
Tomas Ignacio Pizarro Abarca
Pablo Sebastian Bascuñan Espina

Este proyecto consiste en la simulacion de una maquina expendedora de productos (bebidas y dulces) desarrollada en java, 
el  sistema permite gestionar el stock de productos, el pago mediante distintos tipos de monedas y el manejo de errores 
mediante excepciones personalizadas para asegurar el funcionamniento correcto.

El codigo se organiza bajo el paquete "tarea1" e incluye las siguientes funcionalidades:
sistema de prdocutos: implementacion de clases abstractas para "Bebida y "Dulce" con sus respectivos productos especificicos.
gestion de pagos: uso de una jerarquia de monedas con distintos valores.
logica de negocio: existe una clase "Expendedor" que controla los depositos y entrega productos o vuelto.

Se implementaron las siguientes excepciones para manejar los errores:
PagoIncorrectoException: se lanza cuando se intenta realizar una compra con una moneda nula.
NoHayProductoException: se lanza cuando el deposito del producto solicitado esta vacio o el indice no existe.
PagoInsuficienteExceptcion: se lanza cuando el valor de la moneda ingresada es menor al precio del producto.

Para ejecutar el proyecto:
1. Clonar el repositorio.
2. Abrir el proyecto en un IDE (intelliJ IDEA recomendado).
3. Configurar el SDK (java 17 o superior).
4. Ejecutar la clase "Main" ubicada en "src/main/java/Tarea1/Main.java".

Diagrama UML: 
![Diagrama UML](./imagen_2026-05-01_162943234.png)

El diagrama digitalizado es :

classDiagram
    %% Jerarquía de Excepciones
    class Exception {
        <<Java Class>>
    }
    class NoHayProductoException
    class PagoInsuficienteException
    class PagoIncorrectoException
    
    NoHayProductoException --|> Exception
    PagoInsuficienteException --|> Exception
    PagoIncorrectoException --|> Exception

    %% Jerarquía de Productos
    class Producto {
        <<abstract>>
    }
    class Bebida {
        <<abstract>>
    }
    class Dulce {
        <<abstract>>
    }
    Bebida --|> Producto
    Dulce --|> Producto
    
    class CocaCola
    class Sprite
    class Snickers
    class Super8
    
    CocaCola --|> Bebida
    Sprite --|> Bebida
    Snickers --|> Dulce
    Super8 --|> Dulce

    %% Sistema de Máquina Expendedora
    class Expendedor {
        -Deposito~Bebida~ coca
        -Deposito~Bebida~ sprite
        -Deposito~Dulce~ dulces
        -Deposito~Moneda~ monVu
        +Expendedor(int Productos)
        +comprarProducto(Moneda, intID)
        +getVuelto()
    }
    
    class Deposito~T~ {
        -ArrayList~T~ lista
        +ArrayList~T~ lista()
        +getElemento()
    }
    
    class DepositoBebida["Deposito~Bebida~"]
    class DepositoDulce["Deposito~Dulce~"]
    class DepositoMoneda["Deposito~Moneda~"]
    
    DepositoBebida --|> Deposito~T~
    DepositoDulce --|> Deposito~T~
    DepositoMoneda --|> Deposito~T~

    Expendedor *-- DepositoBebida : contiene
    Expendedor *-- DepositoDulce : contiene
    Expendedor *-- DepositoMoneda : contiene

    class EnumProducto
    Expendedor ..> EnumProducto : usa
    
    class Comprador {
        -String sonido
        -int vuelto
        +Comprador(Moneda, intID, Expendedor)
        +cuantoVuelto()
        +queProducto()
    }
    Comprador ..> EnumProducto : usa
    Comprador --> Expendedor : Comprar()
    
    class Main
    Main --> Comprador : instancia

    class Moneda {
        +int valor
        +getSerie()
    }
    class Moneda100
    class Moneda500
    class Moneda1000
    
    Moneda100 --|> Moneda
    Moneda500 --|> Moneda
    Moneda1000 --|> Moneda

    Comprador --> Moneda : usa
    Expendedor --> Moneda : usa/guarda

    %% Throws (Corregido a dependencia en lugar de composición)
    Expendedor ..> NoHayProductoException : throws
    Expendedor ..> PagoInsuficienteException : throws
    Expendedor ..> PagoIncorrectoException : throws
