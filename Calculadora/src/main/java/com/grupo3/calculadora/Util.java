package main.java.com.grupo3.calculadora;

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

    public static int potencia(int exp) {
        int sol = 0;
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