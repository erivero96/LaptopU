public class CuentaBanco {

    private String titular;
    private double cantidad;

    public CuentaBanco(String titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }

    public CuentaBanco(String titular) {
        this.titular = titular;
        this.cantidad = 0.0;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getTitular() {
        return titular;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void ingresar(double cantidad) {
        if (cantidad < 0) {
            return;
        }

        else 
            this.cantidad += cantidad;
    }

    public void retirar(double cantidad) {
        if (this.cantidad - cantidad < 0) 
            return;
        
        else
            this.cantidad -= cantidad;
    }
}
