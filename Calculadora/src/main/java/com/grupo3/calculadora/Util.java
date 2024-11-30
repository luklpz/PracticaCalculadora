package com.grupo3.calculadora;

import java.text.DecimalFormat;

public class Util {

    /**
     * Solicitar y validar un "int" dentro de un rango definido.
     *
     * @param mensajeSolicitud "String" que se imprime para solicitar el número.
     * @param minimo Valor mínimo válido.
     * @param maximo Valor máximo válido.
     * @param mensajeError "String" que se imprime al recibir un valor no válido. Tras este mensaje se repite la validación sin imprimir de nuevo el mensajeSolicitud.
     * @return Devuelve el "int" validado dentro del rango definido.
     */
    public static int solicitarInt(String mensajeSolicitud,int minimo , int maximo, String mensajeError) {
        int numero;
        do {
            //Solicitamos el entero
            System.out.println(mensajeSolicitud);
            numero = Integer.parseInt(Escaner.lector.nextLine().replaceAll("\\D",""));

            //Validamos el número
            if (numero < minimo || numero > maximo) {
                System.err.printf(mensajeError);
            }
        } while (numero < minimo || numero > maximo);
        return numero;
    }

    /**
     * Solicita un 'double' sin condiciones.
     * @param solicitud Mensaje que se imprime para solicitar el 'double'.
     * @param cadenaVacia Si 'true', acepta cadenas vacías y devuelve Double.MIN_VALUE
     * @param mensajeError Mensaje de error que se muestra al introducir un valor inválido.
     * @return Devuelve el 'double' una vez validado.
     */
    public static double solicitarDouble(String solicitud, boolean cadenaVacia, String mensajeError) {
        return solicitarDouble(solicitud, Double.MIN_VALUE, Double.MAX_VALUE,cadenaVacia, mensajeError);
    }

    /**
     * Solicita un 'double' y valida que se encuentre en el rango comprendido entre un mínimo y un máximo.
     *
     * @param solicitud Mensaje que se le muestra al usuario.
     * @param minimo Número mínimo válido que puede valer el 'double'.
     * @param maximo Número máximo válido que puede valer el 'double'.
     * @param mensajeError Mensaje de error que se muestra al introducir un valor inválido.
     * @return Devuelve un 'Double' validado en un rango.
     */
    public static double solicitarDouble(String solicitud, double minimo, double maximo, boolean cadenaVacia, String mensajeError) {
        double respuesta = 0;
        boolean validado=false;
        String entrada;

        //Solicitamos el 'double'
        System.out.print(solicitud);

        do {
            entrada = Escaner.lector.nextLine().trim().replaceAll("\\s+", "");

            if (cadenaVacia&&entrada.isEmpty()){
                    return Double.NaN;
            } else if (!cadenaVacia&&entrada.isEmpty()) {
                System.err.println("ERROR: No se han insertado números.");
            } else {
                respuesta = Double.parseDouble(entrada);
                //Validamos la respuesta
                if (respuesta<minimo||respuesta>maximo) {
                    System.err.println(mensajeError);
                } else {
                    validado=true;
                }
            }
            if (!validado) {
                System.out.println(solicitud);
            }
        } while (!validado);
        return respuesta;
    }

    /**
     * Formatea un 'double' para imprimirlo con los decimales exactos que tenga.
     *
     * @param numero 'double' para formatear.
     * @return Devuelve un 'String' que contiene el número formateado.
     */
    public static String formatDouble(double numero) {
        // Usa DecimalFormat con un patrón que no incluye ceros innecesarios
        DecimalFormat formato = new DecimalFormat("0.###############");
        return formato.format(numero);
    }

    /**
     * Realiza la potencia deseada con base 16.
     *
     * @param exp Exponente de la potencia
     * @return Devuelve la solucion de la potencia.
     */
    public static int potencia(int exp) {
        int sol;
        int base = 16;
        if (exp == 0){
            sol = 1;
        }else if (exp == 1) {
            sol = base;
        } else {
            sol = base * potencia(exp - 1);
        }
        return sol;
    }

}