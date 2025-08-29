package punto15;

public class Deportista {

    private String nombre;
    private String apellido;
    private int puntaje;

    public Deportista(String nombre, String apellido, int puntaje){

        this.nombre=nombre;
        this.apellido=apellido;
        this.puntaje=puntaje;
    }

    public String getNombre(){

        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public int getPuntaje(){
        return puntaje;
    }

    @Override
    public String toString(){

        return nombre+" "+apellido+"("+puntaje+")";
    }
}
