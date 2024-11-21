package main.java.com.grupo3.calculadora;

public class subMenuConversiones {
    /**
     * Este metodo es el submenú de Conversiones de Bases. Imprime el menú con las opciones, lee el número introducido y según la operación eleguida llama a los metodos correspondientes
     */
    public static void subMenuConv(){
        int subMenu;
        do {
            System.out.println("**************************\n** CONVERSIONES DE BASE **\n**************************\n1. De decimal a binario\n2. De decimal a hexadecimal\n3. De binario a decimal\n4. De binario a hexadecimal\n5. De hexadecimal a binario\n6. De hexadecimal a decimal\n---------------------------\n0. Volver al menú principal");
            subMenu = Util.solicitarInt("Elija una opción:\n", 0, 6, "ERROR. El número no coincide con ninguna de las opciones, PRUEBE OTRA VEZ\n");
            switch (subMenu) {
                case 0 -> System.out.println("Volviendo al menú principal...");//Volver al menú principal
                case 1 -> Conversiones.convertirDecimalABinario();//Decimal a binario
                case 2 -> Conversiones.convertirDecimalAHexadecimal();//Decimal a hexadecimal
                case 3 -> Conversiones.convertirBinarioADecimal();//Binario a decimal
                case 4 -> ;//Binario a hexadecimal
                case 5 -> ;//Hexadecimal a binario
                case 6 -> ;//Hexadecimal a decimal
            }
        }while (subMenu != 0);
    }
}
