import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        int opc;
        Scanner sc = new Scanner(System.in);
        Contacto contacto = new Contacto("Juan", "938483009", "Avenida 123");
        Contacto contacto1;
        do {
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Modificar contacto");
            System.out.println("4. Borrar contacto");
            System.out.println("5. Eliminar contactos");
            System.out.println("6. Mostrar Contactos");
            System.out.println("Ingrese una opcion 1-7");
            opc = sc.nextInt();

            switch(opc) {
                case 1:
                    String nombre, telefono, direccion;
                    nombre = sc.next();
                    telefono = sc.next();
                    direccion = sc.nextLine();

                    contacto1 = new Contacto(nombre, telefono, direccion);
                    contacto.contactos.add(contacto1);

                    System.out.println("Se añadio a "+nombre+ " a tu lista de contactos");
                break;

                case 2:
                    String nombreBuscar = sc.next();
                    
                    for(Contacto pivote : contacto.contactos) {
                        if (pivote.getNombre() == nombreBuscar) {
                            System.out.println("Se encontro el contacto");
                            break;
                        }
                    }
                    System.out.println("No se encontro el contacto");
                break;

                case 3:

                    
                break;

                case 4:
                    String borrar;
                    System.out.println("Ingresa el nombre del contacto");
                    borrar = sc.next();
                    for(Contacto pivote : contacto.contactos) {
                        if (pivote.getNombre() == borrar) {
                           contacto.contactos.remove(pivote);
                            break;
                        }
                    }
                    System.out.println("No se encontro el contacto");
                    
                    

                break;

                case 5:
                    for(Contacto pivote : contacto.contactos) {
                        contacto.contactos.remove(pivote);
                    }
                    System.out.println("Se eliminaron todos los contactos");
                    break;

                
                break;

                case 6:

                break;

                case 7:

                break;
                    



            }
            


        } while (opc != 7);
    }
}
