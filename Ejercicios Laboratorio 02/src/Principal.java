import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        String nombre;
        char opc;
        double cantidad;
        Scanner sc = new Scanner(System.in);

        
        System.out.println("----------Cuenta-----------");
        System.out.println("Desea ingresar la cantidad? S/N")
        opc = sc.nextInt();

        if (opc == 'S' or opc == 's') {
            nombre = sc.next();
            cantidad = sc.nextDouble();
            CuentaBanco cuenta = new CuentaBanco(nombre, cantidad);
        }

        else {
            nombre = sc.next();
            CuentaBanco cuenta = new CuentaBanco(nombre);
        }

        cout 

}
