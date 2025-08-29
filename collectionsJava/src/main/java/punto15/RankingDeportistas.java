package punto15;

import java.util.Comparator;
import java.util.TreeSet;

public class RankingDeportistas {

    public static void main(String[] args) {

        Comparator<Deportista> comp = new Comparator<Deportista>() {
            public int compare(Deportista d1, Deportista d2) {
                if (d1.getPuntaje() != d2.getPuntaje()) {

                    return d2.getPuntaje() - d1.getPuntaje();
                }

                return d1.getApellido().compareTo(d2.getApellido());
            }
        };

        TreeSet<Deportista> ranking = new TreeSet<>(comp);

        ranking.add(new Deportista("Carlos", "Lopez", 90));
        ranking.add(new Deportista("Ana", "Gomez", 95));
        ranking.add(new Deportista("Pedro", "Martinez", 95));
        ranking.add(new Deportista("Luis", "Alvarez", 80));
        ranking.add(new Deportista("Marta", "Zapata", 90));
        ranking.add(new Deportista("Jorge", "Lopez", 90));
        ranking.add(new Deportista("Laura", "Bravo", 85));
        ranking.add(new Deportista("Sofia", "Castro", 95));
        ranking.add(new Deportista("Raul", "Gonzalez", 70));
        ranking.add(new Deportista("Elena", "Diaz", 85));
        ranking.add(new Deportista("Mario", "Perez", 60));
        ranking.add(new Deportista("Julian", "Torres", 65));
        ranking.add(new Deportista("Felipe", "Hernandez", 50));

        System.out.println("Top 10 deportistas:");
        int i = 0;
        for (Deportista d : ranking) {
            if (i++ == 10) break;
            System.out.println(d);
        }
    }
}


