package com.grupo3.calculadora;

public class Conversiones {
    //BINARIO A DECIMAL

    /**
     * Solicita al usuario un número binario válido y lo valida.
     * <p>
     * Este mét0do pide un número binario al usuario, asegurándose de que contenga
     * solo caracteres '0' y '1'. Si el número no es binario, muestra un mensaje
     * de error y vuelve a solicitar la entrada.
     *
     * @param mensaje El mensaje que indica que tipo de conversión de base se realiza, ya que este mét0do es reutilizado.
     * @return El número binario que el usuario ingresa, validado.
     */
    public static String obtenerBinarioValido(String mensaje) {
        String binario;
        boolean validado;

        do {
            System.out.println(mensaje);
            binario = Escaner.lector.nextLine();
            binario = binario.trim(); // eliminar espacios al inicio/final
            validado = esBinario(binario); // Validar que sea binario
            if (!validado) {
                System.err.println("El número ingresado no es binario. Asegúrate de usar solo 0s y 1s");
            }
        } while (!validado);

        return binario; // Retorna el binario válido
    }


    /**
     * Verifica si una cadena es un número binario válido.
     * Un número binario válido solo contiene '0' y '1',
     * opcionalmente con un punto decimal seguido de más '0' y '1'.
     *
     * @param binario La cadena a verificar.
     * @return {@code true} si es un binario válido; {@code false} en caso contrario.
     */

    public static boolean esBinario(String binario) {
        return !binario.isEmpty() && binario.matches("[01]+(\\.[01]+)?");
    }


    /**
     * Divide un número binario en su parte entera y fraccionaria.
     * <p>
     * Este mét0do separa el número binario en dos partes, antes y después del punto decimal,
     * devolviendo un array con ambas partes. Si no hay punto decimal, el array tendrá
     * solo un elemento.
     *
     * @param binario El número binario a dividir.
     * @return Un array de Strings donde el primer elemento es la parte entera y el segundo
     * es la parte fraccionaria del binario.
     */
    public static String[] dividirBinario(String binario) {
        return binario.split("\\.");
    }


    /**
     * Convierte un número binario a decimal.
     * <p>
     * Este mét0do toma un número binario como String y lo convierte a su equivalente
     * en decimal. Si el número tiene una parte entera y una fraccionaria, ambas se procesan.
     *
     * @param binario El número binario a convertir.
     * @return El número decimal equivalente al binario proporcionado.
     */
    public static double conversionBinarioDecimal(String binario) {
        String parteFraccional;
        double decimal = 0;
        double fraccionaria = 0;
        int potencia = 0;

        // Recorremos la cadena de derecha a izquierda para la parte entera
        if (!binario.contains(".")) {
            // Si no hay punto decimal, solo calculamos la parte entera
            for (int i = binario.length() - 1; i >= 0; i--) {
                if (binario.charAt(i) == '1') {
                    decimal += Math.pow(2, potencia);  // Usamos Math.pow(2, potencia) para la parte entera
                }
                potencia++;
            }
        } else {
            // Si hay un punto, procesamos la parte entera y la fraccionaria
            String[] partes = dividirBinario(binario);  // Dividimos el binario en parte entera y fraccionaria

            // Parte entera
            String parteEntera = partes[0];
            for (int i = parteEntera.length() - 1; i >= 0; i--) {
                if (parteEntera.charAt(i) == '1') {
                    decimal += Math.pow(2, potencia);  // Usamos Math.pow(2, potencia) para la parte entera
                }
                potencia++;
            }

            // Parte fraccionaria
            parteFraccional = partes[1];
            for (int i = 0; i < parteFraccional.length(); i++) {
                if (parteFraccional.charAt(i) == '1') {
                    fraccionaria += Math.pow(2, -(i + 1));  // Parte fraccionaria usando 2^(-i-1)
                }
            }
        }

        return decimal + fraccionaria;
    }
    /**
     * Solicita un binario válido y convierte el número binario a decimal.
     * <p>
     * Este mét0do llama a `obtenerBinarioValido()` para recibir un número binario,
     * luego lo convierte a su equivalente decimal y lo muestra en la consola.
     */
    public static void convertirBinarioADecimal() {
        // Obtener un binario válido
        String binario = obtenerBinarioValido("Dime el binario a convertir en decimal:");

        // Convertir el binario a decimal
        double decimal = conversionBinarioDecimal(binario);

        // Mostrar el resultado
        System.out.println("El número binario " + binario + " en decimal es: " + decimal);
    }


    //*************************************************************************************************//
    //DECIMAL A BINARIO

    /**
     * Pide al usuario un número decimal y lo valida.
     * <p>
     * Este mét0do le pregunta al usuario por un número decimal que sea positivo o cero.
     * Si el número no es válido, le pide al usuario que ingrese otro.
     *
     * @param mensaje El mensaje que indica que tipo de conversión de base se realiza, ya que este mét0do es reutilizado.
     * @return El número decimal que el usuario ingresa, asegurándose de que sea válido.
     */
    public static int obtenerDecimalValido(String mensaje) { //METODO REUTILIZABLE
        int decimal;

        do {
            System.out.println(mensaje);
            while (!Escaner.lector.hasNextInt()) { // Verifica si la entrada es un entero
                System.out.println("Entrada no válida. Por favor, introduce un número entero.");
                Escaner.lector.next(); // Limpia la entrada incorrecta
            }
            decimal = Escaner.lector.nextInt();
        } while (decimal < 0); // Asegura que el número sea no negativo


        return decimal; // Retorna el valor decimal válido
    }

    /**
     * Convierte un número decimal a binario.
     * <p>
     * Este mét0do toma un número decimal y lo convierte a binario, devolviendo
     * el resultado como una cadena de texto.
     *
     * @param numDecimal El número decimal que quieres convertir a binario.
     * @return El número binario correspondiente al decimal ingresado.
     */
    public static String conversionDecimalBinario(int numDecimal) {
        StringBuilder binario = new StringBuilder();
        if (numDecimal == 0) return "0";
        while (numDecimal > 0) {
            binario.append(numDecimal % 2);
            numDecimal /= 2;
        }
        return binario.reverse().toString();
    }

    /**
     * Solicita al usuario un número decimal válido, lo convierte a binario
     * * y muestra el resultado.
     */
    public static void convertirDecimalABinario() {
        // Obtener un número decimal válido del usuario
        int decimal = obtenerDecimalValido("Dime el decimal a convertir en binario (número no negativo):");

        // Convertir el número decimal a binario
        String binario = conversionDecimalBinario(decimal);

        if (decimal == 0) { //pequeño manejo del 0
            binario = "0";
        }

        // Mostrar el resultado
        System.out.println("El número decimal " + decimal + " en binario es: " + binario);
    }


//*************************************************************************************************//
//DECIMAL A HEXADECIMAL

    /**
     * @param decimal Recibe el numero decimal para convertirlo en hexadecimal
     * @return Devuelve el numero convertido a hexadecimal como String
     */
    public static String conversionDecimalAHexadecimal(int decimal) {
        final String HEXADECIMAL10_15 = "ABCDEF";
        StringBuilder hexadecimal = new StringBuilder();

        // Si el número es 0, devolver "0" inmediatamente
        if (decimal == 0) {
            return "0";
        }

        // Dividir el número por 16 hasta que sea 0
        for (int i = decimal; i > 0; i = i / 16) {
            int residuo = i % 16;  // Residuo de la división para obtener el valor hexadecimal

            if (residuo < 10) {
                hexadecimal.append(residuo);  // Si es menor que 10, se agrega como número
            } else {
                hexadecimal.append(HEXADECIMAL10_15.charAt(residuo - 10));  // Convertir 10-15 a A-F
            }
        }

        // Invertir la cadena porque los dígitos hexadecimales se calculan de atrás hacia adelante
        return hexadecimal.reverse().toString();
    }
    /**
     * Solicita al usuario un número decimal válido, lo convierte a hexadecimal
     * * y muestra el resultado.
     */
    public static void convertirDecimalAHexadecimal() {
        // Obtener un número decimal válido del usuario
        int decimal = obtenerDecimalValido("Dime el decimal a convertir en hexadecimal (número no negativo):");

        // Convertir el número decimal a hexadecimal
        String hexadecimal = conversionDecimalAHexadecimal(decimal);

        // Mostrar el resultado
        System.out.println("El número decimal " + decimal + " en hexadecimal es: " + hexadecimal);
    }

//*************************************************************************************************//
//HEXADECIMAL A DECIMAL

    /**
     * Solicita al usuario un número hexadecimal válido, lo convierte a decimal
     * * y muestra el resultado.
     */
    public static void convertirHexadecimalADecimal() {
        // Obtener un número hexadecimal válido del usuario
        String hexadecimal = obtenerHexadecimalValido("Dime el hexadecimal a convertir en decimal:");

        // Convertir el número hexadecimal a decimal
        int decimal = conversionHexadecimalADecimal(hexadecimal);

        // Mostrar el resultado
        System.out.println("El número hexadecimal " + hexadecimal + " en decimal es: " + decimal);
    }

    /**
     * Solicita al usuario un número hexadecimal válido y lo valida.
     * <p>
     * Este mét0do pide un número hexadecimal al usuario, asegurándose de que contenga
     * solo números y letras de la 'A' a la 'F'. Si el número no es hexadecimal, muestra un mensaje
     * de error y vuelve a solicitar la entrada
     *
     * @param mensaje El mensaje que indica que tipo de conversión de base se realiza, ya que este mét0do es reutilizado.
     * @return El número hexadecimal que el usuario ingresa, validado.
     */
    public static String obtenerHexadecimalValido(String mensaje) {
        String hexadecimal;
        boolean valido;
        do {
            System.out.println(mensaje);
            hexadecimal = Escaner.lector.nextLine();
            hexadecimal = hexadecimal.toUpperCase();
            valido = esHexadecimal(hexadecimal);
            if (!valido) {
                System.err.println("ERROR. Introduce un número hexadecimal válido.");
            }
        } while (!valido);

        return hexadecimal;
    }


    /**
     * Valida si un String es un número hexadecimal válido (solo contiene números y letras de la 'A' a la 'F').
     * <p>
     * Este mét0do recorre cada carácter del String para asegurarse de que todos sean
     * números o letras A-F.
     *
     * @param hexadecimal El String que se desea verificar como hexadecimal.
     * @return true si el String es un número hexadecimal válido, false de lo contrario.
     */
    public static boolean esHexadecimal(String hexadecimal) {
        if (hexadecimal.isEmpty()) {
            return false;
        }

        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        for (char simbolo : hexadecimal.toCharArray()) {
            boolean valido = false;
            for (char hexDigit : hexDigits) {
                if (simbolo == hexDigit) {
                    valido = true;
                    break;
                }
            }
            if (!valido) {
                return false;
            }
        }
        return true;
    }

    /**
     * Convierte un número hexadecimal en un decimal.
     *
     * @param hexadecimal El número hexadecimal que hay que convertir en decimal.
     * @return El número hexadecimal en base decimal.
     */
    public static int conversionHexadecimalADecimal(String hexadecimal) {
        int decimal = 0;
        int j = 0;
        int[] numeros = new int[hexadecimal.length()];
        char[] digito = new char[hexadecimal.length()];
        for (int i = hexadecimal.length() - 1; i >= 0; i--) {
            digito[j] = hexadecimal.charAt(i);
            j++;
        }
        for (int k = 0; k < digito.length; k++) {
            if (Character.isDigit(digito[k])) {
                numeros[k] = Character.getNumericValue(digito[k]);
                decimal += numeros[k] * Util.potencia(k);
            } else {
                switch (digito[k]) {
                    case 'A' -> decimal += 10 * Util.potencia(k);
                    case 'B' -> decimal += 11 * Util.potencia(k);
                    case 'C' -> decimal += 12 * Util.potencia(k);
                    case 'D' -> decimal += 13 * Util.potencia(k);
                    case 'E' -> decimal += 14 * Util.potencia(k);
                    case 'F' -> decimal += 15 * Util.potencia(k);
                }
            }
        }
        return decimal;
    }

//*************************************************************************************************//
//HEXADECIMAL A BINARIO

    /**
     * Convierte un hexadecimal a binario, como ya hay métodos que combinados llegan a la solución, los he reutilizado.
     */
    public static void convertirHexadecimalABinario() {
        // Obtener un número hexadecimal válido del usuario
        String hexadecimal = obtenerHexadecimalValido("Dime el hexadecimal a convertir en binario:");

        // Convertir el número hexadecimal a decimal
        int decimal = conversionHexadecimalADecimal(hexadecimal);

        //Convertir el número decimal a binario
        String binario = conversionDecimalBinario(decimal);

        // Mostrar el resultado
        System.out.println("El número hexadecimal " + hexadecimal + " en binario es: " + binario);
    }


//*************************************************************************************************//
//BINARIO A HEXADECIMAL

    /**
     * Convierte un binario a hexadecimal, como ya hay métodos que combinados llegan a la solución, los he reutilizado.
     */
    public static void convertirBinarioAHexadecimal() {
        //Obtener un número binario válido del usuario
        String binario = obtenerBinarioValido("Dime el binario a convertir en hexadecimal:");

        //Convertir el número binario a decimal
        int decimal = (int) conversionBinarioDecimal(binario);

        //Convertir el número decimal a hexadecimal
        String hexadecimal = conversionDecimalAHexadecimal(decimal);

        // Mostrar el resultado
        System.out.println("El número binario " + binario + " en hexadecimal es: " + hexadecimal);
    }
}
