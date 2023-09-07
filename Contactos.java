import java.util.ArrayList;

public class Contacto {
    private String nombre;
    private String telefono;
    private String direccion;


    Contacto(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    Contacto() {
        this.nombre = " ";
        this.telefono = "0000000";
        this.direccion = " ";
    }

    public ArrayList<Contacto> contactos;

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
