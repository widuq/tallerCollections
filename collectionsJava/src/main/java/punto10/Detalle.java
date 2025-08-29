package punto10;

public class Detalle {

    String nombre;
    double precio;
    int cantidad;


    public Detalle(String nombre, double precio, int cantidad){

        this.nombre=nombre;
        this.precio=precio;
        this.cantidad=cantidad;

    }

    public void sumarCantidad(int adicional){
        this.cantidad+=adicional;
    }

    public double getSubtotal(){
        return precio*cantidad;
    }


    @Override
    public String toString(){

        return nombre+"x"+cantidad+"$"+precio+"=" + getSubtotal();
    }
}
