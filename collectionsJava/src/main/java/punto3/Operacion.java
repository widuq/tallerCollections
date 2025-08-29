package punto3;

public class Operacion {

    private String nombreOp;

    public Operacion(String nombreOp){

        this.nombreOp=nombreOp;
    }

    @Override
    public String toString(){
        return nombreOp;
    }
}
