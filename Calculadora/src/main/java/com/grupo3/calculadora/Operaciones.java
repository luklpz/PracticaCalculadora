package com.grupo3.calculadora;

public class Operaciones {
    public enum Operacion{
        SUMA,RESTA,DIVISION,MULTIPLICACION, RESTODIVISION
    }

    /**
     * Validar si la memoria ha sido inicializada para detectar si es o no usable
     *
     * @param valorMemoria Valor actual de la memoria.
     * @return Devuelve true si la memoria ha sido inicializada y false en caso de que su valor sea NaN.
     */
    private static boolean existeMemoria(double valorMemoria){
        if (Double.isNaN(valorMemoria)){
            return false;
        } else {
            System.out.printf("\n\u001B[33m*No introducir nada hará uso del número en la memoria*\u001B[0m Memoria: %f\n",valorMemoria);
            return true;
        }
    }

    public static double ejecutarOperacion(double valorMemoria, Operacion operacion){
        //Definimos las variables
        StringBuilder sb = new StringBuilder();
        boolean memoriaUsable;
        double resultado;
        String solicitudPrimerNumero="";
        String solicitudSegundoNumero="";

        //Modificamos los mensajes que se imprimen según la operación
        switch (operacion) {
            case SUMA -> {
                System.out.println("\n*** SUMA ***");
                solicitudPrimerNumero="Primer sumando = ";
                solicitudSegundoNumero="Segundo sumando = ";
            }
            case RESTA -> {
                System.out.println("\n*** RESTA ***");
                solicitudPrimerNumero="Minuendo = ";
                solicitudSegundoNumero="Sustraendo = ";
            }
            case MULTIPLICACION -> {
                System.out.println("\n*** MULTIPLICACION ***");
                solicitudPrimerNumero="Multiplicando = ";
                solicitudSegundoNumero="Multiplicador = ";
            }
            case DIVISION -> {
                System.out.println("\n*** DIVISION ***");
                solicitudPrimerNumero="Dividendo = ";
                solicitudSegundoNumero="Divisor = ";
            }
            case RESTODIVISION -> {
                System.out.println("\n*** RESTO DE UNA DIVISION ***");
                solicitudPrimerNumero="Dividendo = ";
                solicitudSegundoNumero="Divisor = ";
            }
        }

        //Validamos si hay memoria
        memoriaUsable=existeMemoria(valorMemoria);

        //Solicitamos los números
        double numero1 = Util.solicitarDouble(solicitudPrimerNumero,memoriaUsable,"Has introducido una entrada invalida, prueba de nuevo.");
        if (Double.isNaN(numero1)){
            numero1=valorMemoria;
        }

        double numero2 = Util.solicitarDouble(solicitudSegundoNumero,memoriaUsable,"Has introducido una entrada invalida, prueba de nuevo.");
        if (Double.isNaN(numero2)){
            numero2=valorMemoria;
        }


        //Imprimimos y devolvemos el resultado
        switch (operacion){
            case SUMA -> {
                resultado=numero1+numero2;
                sb.append(Util.formatDouble(numero1)).append(" + ").append(Util.formatDouble(numero2)).append(" = ").append(Util.formatDouble(resultado));
                System.out.println(sb);
            }
            case RESTA -> {
                resultado=numero1-numero2;
                sb.append(Util.formatDouble(numero1)).append(" - ").append(Util.formatDouble(numero2)).append(" = ").append(Util.formatDouble(resultado));
                System.out.println(sb);
            }
            case DIVISION -> {
                resultado=numero1/numero2;
                sb.append(Util.formatDouble(numero1)).append(" / ").append(Util.formatDouble(numero2)).append(" = ").append(Util.formatDouble(resultado));
                System.out.println(sb);
            }
            case MULTIPLICACION -> {
                resultado=numero1*numero2;
                sb.append(Util.formatDouble(numero1)).append(" x ").append(Util.formatDouble(numero2)).append(" = ").append(Util.formatDouble(resultado));
                System.out.println(sb);
            }
            case RESTODIVISION -> {
                resultado=numero1 % numero2;
                sb.append(Util.formatDouble(numero1)).append(" % ").append(Util.formatDouble(numero2)).append(" = ").append(Util.formatDouble(resultado));
                System.out.println(sb);
            }
            default-> {
                System.err.println("ERROR: Entrada inesperada.");
                resultado=Double.NaN;
            }
        }
        return resultado;
    }
}
