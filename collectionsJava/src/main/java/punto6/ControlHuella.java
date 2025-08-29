package punto6;

import java.util.HashSet;

public class ControlHuella {

    public static void main(String[] args){
        HashSet<String> huellas= new HashSet<>();


        registrarHuellas(huellas,"123");
        registrarHuellas(huellas,"456");
        registrarHuellas(huellas,"789");
        registrarHuellas(huellas,"987");
        registrarHuellas(huellas,"654");
        registrarHuellas(huellas,"123");
        registrarHuellas(huellas,"654");
        registrarHuellas(huellas,"123");


        System.out.println("\nHuellas registradas: " + huellas);

    }

    public static void registrarHuellas(HashSet<String> huellas, String id){

        if(huellas.add(id)){
            System.out.println("huella registrada"+id);
        }else{
            System.out.println("duplicado de huellas, no se registra");
        }
    }
}
