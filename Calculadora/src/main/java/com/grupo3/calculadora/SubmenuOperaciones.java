package main.java.com.grupo3.calculadora;

public class SubmenuOperaciones {
    public static int menuOperaciones(){
        String submenuOperaciones = "*****************************\n** OPERACIONES ARITMÉTICAS **\n*****************************\n1. Sumar\n2. Restar\n3. Multiplicar\n4. Dividir\n5. Resto de la división\n-----------------------------\n0. Volver al menú principal";
        return Util.solicitarInt(submenuOperaciones,0,5,"ERROR. El número introducido no corresponde con ninunga de las opciones. Intentelo de nuevo:");
    }

    public static void switchOperaciones(){
        int opcionSeleccionada;
        boolean cerrar=false;
        double valorMemoria= Double.MIN_VALUE;

        //Iniciamos la calculadora
        do {
            opcionSeleccionada=menuOperaciones();
            switch (opcionSeleccionada) {
                case 0 -> cerrar=true;
                case 1 -> valorMemoria = Operaciones.sumaResta(valorMemoria,true);
                case 2 -> valorMemoria = Operaciones.sumaResta(valorMemoria,false);
                case 3 -> cerrar=true; //Cambiar por operación multiplicar.
                case 4 -> cerrar=true; //Cambiar por operación dividir.
                case 5 -> cerrar=true; //Cambiar por operación resto de división
                default -> System.err.println("ERROR: Entrada inesperada invalida.");
            }
        } while (!cerrar);
    }

    public static void main(String[] args) {
        switchOperaciones();
    }
}
