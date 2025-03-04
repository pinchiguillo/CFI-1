# Comunicador Interplanetario

El módulo **Comunicador Interplanetario** es fundamental en el proyecto **Misión Espacial Cronos**. Se encarga de analizar y traducir mensajes entre la Tierra y la base, asegurando la integridad y claridad de la comunicación. Entre sus principales funcionalidades se incluyen:

- **Contar Vocales:**  
  Analiza un mensaje para contar cuántas vocales (a, e, i, o, u) contiene, sin distinguir entre mayúsculas y minúsculas.

- **Invertir Mensaje:**  
  Invierte el orden de los caracteres de un mensaje. Esta funcionalidad puede ayudar a descifrar códigos o verificar la simetría del mensaje.

- **Verificar Palíndromo:**  
  Determina si un mensaje es un palíndromo, es decir, si se lee igual de izquierda a derecha que de derecha a izquierda. Se ignoran los espacios y las diferencias entre mayúsculas y minúsculas.

## Funcionalidades Detalladas

### `contarVocales(String mensaje)`

- **Propósito:**  
  Contar la cantidad de vocales en el mensaje proporcionado.
- **Parámetros:**
    - `mensaje`: Cadena de texto a analizar.
- **Retorno:**
    - Un entero con la cantidad de vocales encontradas.
- **Excepción:**
    - Lanza `IllegalArgumentException` si el mensaje es `null`.

### `invertirMensaje(String mensaje)`

- **Propósito:**  
  Invertir el orden de los caracteres en el mensaje.
- **Parámetros:**
    - `mensaje`: Cadena de texto a invertir.
- **Retorno:**
    - Una nueva cadena con el mensaje invertido.
- **Excepción:**
    - Lanza `IllegalArgumentException` si el mensaje es `null`.

### `esPalindromo(String mensaje)`

- **Propósito:**  
  Verificar si el mensaje es un palíndromo, ignorando espacios y diferencias de mayúsculas/minúsculas.
- **Parámetros:**
    - `mensaje`: Cadena de texto a evaluar.
- **Retorno:**
    - `true` si el mensaje es un palíndromo; `false` en caso contrario.
- **Excepción:**
    - Lanza `IllegalArgumentException` si el mensaje es `null`.

## Ejemplo de Uso

```java
ComunicadorInterplanetario comunicador = new ComunicadorInterplanetario();

String mensaje = "Anita lava la tina";

// Contar vocales
int cantidadVocales = comunicador.contarVocales(mensaje);
System.out.println("Cantidad de vocales: " + cantidadVocales);

// Invertir el mensaje
String mensajeInvertido = comunicador.invertirMensaje(mensaje);
System.out.println("Mensaje invertido: " + mensajeInvertido);

// Verificar si el mensaje es palíndromo
boolean esPalindromo = comunicador.esPalindromo(mensaje);
System.out.println("¿Es palíndromo? " + esPalindromo);
