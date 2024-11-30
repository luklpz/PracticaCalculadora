package com.grupo3.calculadora;

public class SubmenuOperaciones {

    /**
     * Imprime el menú de operaciones y espera a que sea ingresada una opción.
     *
     * @return Devuelve un 'int' como opción seleccionada por el usuario.
     */
    private static int solicitarOperacion(){
        String submenuOperaciones = "\n\n*****************************\n** OPERACIONES ARITMÉTICAS **\n*****************************\n1. Sumar\n2. Restar\n3. Multiplicar\n4. Dividir\n5. Resto de la división\n-----------------------------\n0. Volver al menú principal";
        return Util.solicitarInt(submenuOperaciones,0,5,"ERROR. El número introducido no corresponde con ninunga de las opciones. Intentelo de nuevo:");
    }

    /**
     * Imprime el menú de operaciones y ejecuta la seleccionada por el usuario.
     */
    public static void switchOperaciones(){
        int opcionSeleccionada;
        boolean cerrar=false;
        double valorMemoria=Double.NaN;

        //Iniciamos la calculadora
        do {
            opcionSeleccionada=solicitarOperacion();
            switch (opcionSeleccionada) {
                case 0 -> cerrar=true;
                case 1 -> valorMemoria = Operaciones.ejecutarOperacion(valorMemoria, Operaciones.Operacion.SUMA);
                case 2 -> valorMemoria = Operaciones.ejecutarOperacion(valorMemoria, Operaciones.Operacion.RESTA);
                case 3 -> valorMemoria = Operaciones.ejecutarOperacion(valorMemoria, Operaciones.Operacion.MULTIPLICACION);
                case 4 -> valorMemoria = Operaciones.ejecutarOperacion(valorMemoria, Operaciones.Operacion.DIVISION);
                case 5 -> valorMemoria = Operaciones.ejecutarOperacion(valorMemoria, Operaciones.Operacion.RESTODIVISION);
                default -> System.err.println("ERROR: Entrada inesperada invalida.");
            }
        } while (!cerrar);
    }
}
