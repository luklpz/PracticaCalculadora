package main.java.com.grupo3.calculadora;

public class Conversiones {
    //BINARIO A DECIMAL

    /**
     * Solicita al usuario un número binario válido y lo valida.
     * <p>
     * Este método pide un número binario al usuario, asegurándose de que contenga
     * solo caracteres '0' y '1'. Si el número no es binario, muestra un mensaje
     * de error y vuelve a solicitar la entrada.
     *
     * @return El número binario que el usuario ingresa, validado.
     */
    public static String obtenerBinarioValido() {
        String binario;
        boolean validado;

        do {
            System.out.println("Dime el binario a convertir en decimal:");
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
     * Solicita un binario válido y convierte el número binario a decimal.
     * <p>
     * Este método llama a `obtenerBinarioValido()` para recibir un número binario,
     * luego lo convierte a su equivalente decimal y lo muestra en la consola.
     */
    public static void convertirBinarioADecimal() {
        // Obtener un binario válido
        String binario = obtenerBinarioValido();

        // Convertir el binario a decimal
        double decimal = conversionBinarioDecimal(binario);

        // Mostrar el resultado
        System.out.println("El número binario " + binario + " en decimal es: " + decimal);
    }


    /**
     * Valida si un String es un número binario válido (solo contiene 0s y 1s).
     * <p>
     * Este método recorre cada carácter del String para asegurarse de que todos sean
     * '0', '1' o, en su caso, un único punto decimal. Si encuentra caracteres no válidos
     * o múltiples puntos, devuelve false.
     *
     * @param str El String que se desea verificar como binario.
     * @return true si el String es un número binario válido, false de lo contrario.
     */
    public static boolean esBinario(String str) {
        boolean puntoEncontrado = false;
        for (char c : str.toCharArray()) {
            if (c == '.') {
                if (puntoEncontrado) {
                    return false; // Más de un punto decimal no es válido
                }
                puntoEncontrado = true; //asigno la primera aparicion
            } else if (c != '0' && c != '1') {
                return false; // Si encuentra un carácter que no es '0', '1' o '.', devuelve false
            }
        }
        return true; // Si todos los caracteres son válidos, devuelve true
    }

    /**
     * Divide un número binario en su parte entera y fraccionaria.
     * <p>
     * Este método separa el número binario en dos partes, antes y después del punto decimal,
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
     * Este método toma un número binario como String y lo convierte a su equivalente
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

    //*************************************************************************************************//
    //DECIMAL A BINARIO

    /**
     * Solicita al usuario un número decimal válido, lo convierte a binario
     * * y muestra el resultado.
     */
    public static void convertirDecimalABinario() {
        // Obtener un número decimal válido del usuario
        int decimal = obtenerDecimalValido();

        // Convertir el número decimal a binario
        String binario = conversionDecimalBinario(decimal);

        if (decimal == 0) { //pequeño manejo del 0
            binario = "0";
        }

        // Mostrar el resultado
        System.out.println("El número decimal " + decimal + " en binario es: " + binario);
    }

    /**
     * Pide al usuario un número decimal y lo valida.
     * <p>
     * Este método le pregunta al usuario por un número decimal que sea positivo o cero.
     * Si el número no es válido, le pide al usuario que ingrese otro.
     *
     * @return El número decimal que el usuario ingresa, asegurándose de que sea válido.
     */
    public static int obtenerDecimalValido() { //METODO REUTILIZABLE
        int decimal;

        do {
            System.out.println("Dime el decimal a convertir en binario (número no negativo):");
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
     * Este método toma un número decimal y lo convierte a binario, devolviendo
     * el resultado como una cadena de texto.
     *
     * @param numdecimal El número decimal que quieres convertir a binario.
     * @return El número binario correspondiente al decimal ingresado.
     */
    public static String conversionDecimalBinario(int numdecimal) {
        if (numdecimal == 0) {
            return ""; // Caso base
        }
        return conversionDecimalBinario(numdecimal / 2) + (numdecimal % 2); //llamada recursiva


    }

//*************************************************************************************************//
//DECIMAL A HEXADECIMAL

    /**
     * Solicita al usuario un número decimal válido, lo convierte a hexadecimal
     * * y muestra el resultado.
     */
    public static void convertirDecimalAHexadecimal() {
        // Obtener un número decimal válido del usuario
        int decimal = obtenerDecimalValido();

        // Convertir el número decimal a hexadecimal
        String hexadecimal = conversionDecimalAHexadecimal(decimal);

        // Mostrar el resultado
        System.out.println("El número decimal " + decimal + " en hexadecimal es: " + hexadecimal);
    }

    /**
     *
     * @param decimal Recibe el numero decimal para convertirlo en hexadecimal
     * @return  Devuelve el numero convertido a hexadecimal como String
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

//*************************************************************************************************//
//HEXADECIMAL A DECIMAL

    /**
     * Solicita al usuario un número hexadecimal válido, lo convierte a decimal
     * * y muestra el resultado.
     */
    public static void convertirHexadecimalADecimal() {
        // Obtener un número hexadecimal válido del usuario
        String hexadecimal = obtenerHexadecimalValido();

        // Convertir el número decimal a hexadecimal
        int decimal = conversionHexadecimalADecimal(hexadecimal);

        // Mostrar el resultado
        System.out.println("El número hexadecimal " + hexadecimal + " en decimal es: " + decimal);
    }

    public static String obtenerHexadecimalValido() { //METODO REUTILIZABLE
        String hexadecimal;
        boolean valido;
        do {
            System.out.println("Dime el hexadecimal a convertir en decimal:");
            hexadecimal = Escaner.lector.nextLine();
            valido = isHexadecimal(hexadecimal);
        } while (!valido);

        return hexadecimal;
    }

    public static boolean isHexadecimal(String hexadecimal) {
        if(hexadecimal.length() < 1) {
            System.err.println("ERROR. Introduce un valor.");
        }

        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F' };

        for (char simbolo : hexadecimal.toCharArray()) {
            boolean valido = false;
            for (char hexDigit : hexDigits) {
                if (simbolo == hexDigit) {
                    valido = true;
                    break;
                }
            }
            if (!valido){
                return false;
            }
        }
        return true;
    }

    public static int conversionHexadecimalADecimal(String hexadecimal){
        int decimal;
        char[] digito = new char[hexadecimal.length()-1];
        for (int i = hexadecimal.length()-1; i >= 0; i--){
            int j = 0;
            digito[j] = hexadecimal.charAt(i);
            System.out.println(digito[j]);
            j++;
        }
        for (int i = 0; i < digito.length; i++){
            if (Character.isDigit(digito[i])){
                decimal += potencia(i) * digito[i];
            }else {
                System.out.print("No llegas");
            }
        }
        System.out.println(decimal);
    }
}
