package punto13;

public class MainLRU {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put("A", "Avion");
        cache.put("B", "Banano");
        cache.put("C", "Casa");

        System.out.println("Cache inicial: " + cache);

        cache.get("A");

        cache.put("D", "Dado");

        System.out.println("Cache final: " + cache);
    }
}

