package punto17;

public class Lote {

    private  String id;
    private  String descripcion;

    public Lote(String id, String descripcion){
        this.id=id;
        this.descripcion=descripcion;
    }

    @Override
    public String toString(){
        return "["+id+"]"+descripcion;
    }
}
