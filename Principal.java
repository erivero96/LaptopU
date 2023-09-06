import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int matriz[][] = new int[4][4];
        boolean salir = false;
        int opcion, fila, columna;
        boolean rellenado = false;
        do {
            System.out.println("Menu");
            System.out.println("1. Rellenar Matriz");
            System.out.println("2. Sumar fila");
            System.out.println("3. Sumar columna");
            System.out.println("4. Sumar la diagonal principal");
            System.out.println("5. Sumar la diagonal inversa"); 
            System.out.println("6. Salir");
            System.out.println("Elije una opcion");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    rellenarMatriz(sn, matriz);
                    rellenado = true;
                    break;
                case 2:
                    if (rellenado) {
                        do {
                            System.out.println("Elige una fila");
                            fila = sn.nextInt();
                        } while (!(fila >= 0 && fila < matriz.length));
                        System.out.println("La suma de los valores de la fila " + fila
                                + " es: " + sumaFila(matriz, fila));
                    } else {
                        System.out.println("Debes rellenar la matriz primero");
                    }
                    break;
                case 3:
                    if (rellenado) {
                        do {
                            System.out.print("Elige una columna: ");
                            columna = sn.nextInt();
                        } while((columna <= 0 && columna > matriz[0].length));
                        System.out.println("La suma de los valores de la columna " + columna
                                + " es: " + sumaColumna(matriz, columna));
                    }
                    break;
                case 4:
                    if (rellenado) {
                        System.out.println(sumaPrincipal(matriz));
                    }
                    break;
                case 5:
                    if (rellenado) {
                        System.out.println(sumaInversa(matriz));
                    }
                    break;

                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Tienes que meter un valor entre 1 y 6");
            }
        } while (!salir);

        System.out.println("FIN");
    }

    public static void rellenarMatriz(Scanner sn, int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("Escribe un numero en la posicion " + i + " " + j);
                matriz[i][j] = sn.nextInt();
            }
        }
    }

    public static int sumaFila(int[][] matriz, int fila) {
        int suma = 0;
        for (int j = 0; j < matriz.length; j++) {
            suma += matriz[fila][j];
        }
        return suma;
    }

    public static int sumaColumna(int[][] x, int columna) {
        int suma = 0;
        for (int i = 0; i < x[0].length; i++) {
            suma += x[i][columna];
        }
        return suma;
    }

    public static int sumaPrincipal(int[][] x) {
        int suma = 0;
        for (int i = 0; i < x.length; i++) {
            suma += x[i][i];
        }
        return suma;
    }

    public static int sumaInversa(int[][] x) {
        int suma = 0;
        for (int i = x.length-1; i >= 0; i--) {
            suma += x[i][i];
        }
        return suma;
    }


}

/*public static int sumaColumna(int[][] x, int columna) {
    int suma = 0;
    for (int i = 0; i < x.length; i++) {
        if (columna >= 0 && columna < x[i].length) {
            suma += x[i][columna];
        }
    }
    return suma;
}

public static int sumaPrincipal(int[][] x) {
    int suma = 0;
    int minSize = Math.min(x.length, x[0].length); // Toma el tamaño mínimo entre filas y columnas
    for (int i = 0; i < minSize; i++) {
        suma += x[i][i];
    }
    return suma;
}

public static int sumaInversa(int[][] x) {
    int suma = 0;
    int minSize = Math.min(x.length, x[0].length); // Toma el tamaño mínimo entre filas y columnas
    for (int i = minSize - 1; i >= 0; i--) {
        suma += x[i][minSize - 1 - i];
    }
    return suma;
}
 */

/* 
 public static void rellenarMatriz(Scanner sn, int[][] matriz) {
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[0].length; j++) {
            System.out.println("Escribe un numero en la posicion " + i + " " + j);
            matriz[i][j] = sn.nextInt();
        }
    }
}

public static int sumaFila(int[][] matriz, int fila) {
    if (fila < 0 || fila >= matriz.length) {
        throw new IllegalArgumentException("La fila especificada está fuera de los límites");
    }
    int suma = 0;
    for (int j = 0; j < matriz[0].length; j++) {
        suma += matriz[fila][j];
    }
    return suma;
}

 */
