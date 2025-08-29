package punto13;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<String, String> {
private final int capacidad;


    public LRUCache(int capacidad) {
        super(capacidad, 0.80f,true);
        this.capacidad = capacidad;
    }
    protected boolean entradaMasAntigua(Map.Entry entradaMasVieja){

        return size()>capacidad;

    }
}
