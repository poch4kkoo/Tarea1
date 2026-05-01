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

Se compartio a gemini el diagrama para poder estrucutrarlo de mejor manera y hacerlo mas estetico, como resultado nos dio un codigo, generando el mismo diagrama pero digitalizado.
El diagrama digitalizado es :

```mermaid
classDiagram
    %% Relación de Existencia (Main es el dueño)
    class Main {
        +main(String[] args)
    }
    
    class Expendedor {
        -Deposito~Bebida~ coca
        -Deposito~Bebida~ sprite
        -Deposito~Bebida~ fanta
        -Deposito~Dulce~ dulces
        -Deposito~Moneda~ monVu
        +comprarProducto(Moneda m, int id) Producto
        +getVuelto() Moneda
    }
    
    class Comprador {
        -String sonido
        -int vuelto
        +Comprador(Moneda m, int id, Expendedor exp)
        +cuantoVuelto() int
        +queProducto() String
    }

    Main *-- Expendedor : compone
    Main *-- Comprador : compone
    Comprador --> Expendedor : interactúa

    %% Jerarquía de Productos
    class Producto {
        <<abstract>>
        -int serie
        +getSerie() int
    }
    class Bebida { <<abstract>> }
    class Dulce { <<abstract>> }
    
    Producto <|-- Bebida
    Producto <|-- Dulce
    Bebida <|-- CocaCola
    Bebida <|-- Sprite
    Bebida <|-- Fanta
    Dulce <|-- Snickers
    Dulce <|-- Super8

    %% Estructura de Depósitos
    class Deposito~T~ {
        -ArrayList~T~ al
        +add(T obj)
        +get() T
    }
    
    Expendedor *-- Deposito : tiene
    Deposito --> Producto : guarda
    Deposito --> Moneda : guarda

    %% Jerarquía de Monedas
    class Moneda {
        <<abstract>>
        +getSerie() String
        +getValor() int
    }
    Moneda <|-- Moneda100
    Moneda <|-- Moneda500
    Moneda <|-- Moneda1000
    Moneda <|-- Moneda1500

    %% Relaciones de Uso y Excepciones
    Expendedor ..> Moneda : usa
    Comprador ..> Moneda : usa
    Expendedor ..> PagoIncorrectoException : throws
    Expendedor ..> NoHayProductoException : throws
    Expendedor ..> PagoInsuficienteException : throws

    class Exception { <<Java Class>> }
    Exception <|-- PagoIncorrectoException
    Exception <|-- NoHayProductoException
    Exception <|-- PagoInsuficienteException
