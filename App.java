import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Elige una opción:");
            System.out.println("1. Convertir de binario a decimal");
            System.out.println("2. Convertir de binario a hexadecimal");
            System.out.println("3. Convertir de decimal a binario");
            System.out.println("4. Convertir de decimal a hexadecimal");
            System.out.println("5. Convertir de hexadecimal a binario");
            System.out.println("6. Convertir de hexadecimal a decimal");
            System.out.println("7. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el número binario: ");
                    String binario = scanner.next();
                    int decimal = convertirBinarioADecimal(binario);
                    System.out.println("El número decimal es: " + decimal);
                    break;

                case 2:
                    System.out.print("Ingresa el número binario: ");
                    String binarioHex = scanner.next();
                    String hexadecimal = convertirBinarioAHexadecimal(binarioHex);
                    System.out.println("El número hexadecimal es: " + hexadecimal);
                    break;

                case 3:
                    System.out.print("Ingresa el número decimal: ");
                    int decimal2 = scanner.nextInt();
                    String binario2 = convertirDecimalABinario(decimal2);
                    System.out.println("El número binario es: " + binario2);
                    break;

                case 4:
                    System.out.print("Ingresa el número decimal: ");
                    int decimal3 = scanner.nextInt();
                    String hexadecimal2 = convertirDecimalAHexadecimal(decimal3);
                    System.out.println("El número hexadecimal es: " + hexadecimal2);
                    break;

                case 5:
                    System.out.print("Ingresa el número hexadecimal: ");
                    String hexadecimal3 = scanner.next();
                    String binarioHex2 = convertirHexadecimalABinario(hexadecimal3);
                    System.out.println("El número binario es: " + binarioHex2);
                    break;

                case 6:
                    System.out.print("Ingresa el número hexadecimal: ");
                    String hexadecimal4 = scanner.next();
                    int decimalHex = convertirHexadecimalADecimal(hexadecimal4);
                    System.out.println("El número decimal es: " + decimalHex);
                    break;

                case 7:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }

    public static int convertirBinarioADecimal(String binario) {
        return convertirBinarioADecimalRecursivo(binario, binario.length() - 1, 0);
    }

    private static int convertirBinarioADecimalRecursivo(String binario, int indice, int decimal) {
        if (indice < 0) {
            return decimal;
        }
        int bit = Character.getNumericValue(binario.charAt(indice));
        return convertirBinarioADecimalRecursivo(binario, indice - 1, decimal + bit * (int) Math.pow(2, binario.length() - 1 - indice));
    }

    public static int convertirHexadecimalADecimal(String hexadecimal) {
        return convertirHexadecimalADecimalRecursivo(hexadecimal, hexadecimal.length() - 1, 0);
    }

    private static int convertirHexadecimalADecimalRecursivo(String hexadecimal, int indice, int decimal) {
        if (indice < 0) {
            return decimal;
        }
        String digitosHex = "0123456789ABCDEF";
        char digito = hexadecimal.charAt(indice);
        int valor = digitosHex.indexOf(digito);
        return convertirHexadecimalADecimalRecursivo(hexadecimal, indice - 1, decimal + valor * (int) Math.pow(16, hexadecimal.length() - 1 - indice));
    }

    public static String convertirDecimalABinario(int decimal) {
        if (decimal == 0) {
            return "0";
        } else {
            return convertirDecimalABinarioRecursivo(decimal);
        }
    }

    private static String convertirDecimalABinarioRecursivo(int decimal) {
        if (decimal == 0) {
            return "";
        } else {
            int bit = decimal % 2;
            return convertirDecimalABinarioRecursivo(decimal / 2) + bit;
        }
    }

    public static String convertirDecimalAHexadecimal(int decimal) {
        if (decimal == 0) {
            return "0";
        } else {
            return convertirDecimalAHexadecimalRecursivo(decimal);
        }
    }

    private static String convertirDecimalAHexadecimalRecursivo(int decimal) {
        if (decimal == 0) {
            return "";
        } else {
            int residuo = decimal % 16;
            char digitoHex = "0123456789ABCDEF".charAt(residuo);
            return convertirDecimalAHexadecimalRecursivo(decimal / 16) + digitoHex;
        }
    }

    public static String convertirHexadecimalABinario(String hexadecimal) {
        return convertirHexadecimalABinarioRecursivo(hexadecimal, 0, "");
    }

    private static String convertirHexadecimalABinarioRecursivo(String hexadecimal, int indice, String binario) {
        if (indice < hexadecimal.length()) {
            char digitoHex = hexadecimal.charAt(indice);
            int valor = Integer.parseInt(String.valueOf(digitoHex), 16);
            String digitoBinario = String.format("%4s", Integer.toBinaryString(valor)).replace(' ', '0');
            return convertirHexadecimalABinarioRecursivo(hexadecimal, indice + 1, binario + digitoBinario);
        } else {
            return binario;
        }
    }

    public static String convertirBinarioAHexadecimal(String binario) {
        return convertirBinarioAHexadecimalRecursivo(binario, 0, "");
    }

    private static String convertirBinarioAHexadecimalRecursivo(String binario, int indice, String hexadecimal) {
        if (indice < binario.length()) {
            String digitoBinario = binario.substring(indice, indice + 4);
            int valorDecimal = Integer.parseInt(digitoBinario, 2);
            char digitoHex = "0123456789ABCDEF".charAt(valorDecimal);
            return convertirBinarioAHexadecimalRecursivo(binario, indice + 4, hexadecimal + digitoHex);
        } else {
            return hexadecimal;
        }
    }
}
