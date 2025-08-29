package punto3;

import java.util.Stack;

public class EditorImagenes {

    public static void main(String[] args){

        Stack<Operacion> cambios= new Stack<>();

        cambios.push(new Operacion("Rotar a la izquierda"));
        cambios.push(new Operacion("Rotar a la derecha"));
        cambios.push(new Operacion("Bajar Brillo"));
        cambios.push(new Operacion("Ajustar Tamaño"));
        cambios.push(new Operacion("Recortar"));
        cambios.push(new Operacion("Colocar filtro"));


        System.out.println("Imagen Inicial"+cambios);


        for (int i=1;i<=3;i++) {
            if (!cambios.isEmpty()) {
                Operacion deshecha = cambios.pop();
                System.out.println("undo" + i + ":" + deshecha);
                System.out.println("Estado actual" + cambios);
                }
            }


        }


    }

