public interface Tree<K extends Comparable<K>, V> {
    /**
     * INTERFAZ CON GENERICOS OBTENIDA DE CHAT GPT
     */

    /**
     * @param key
     * @param value
     */
    void insert(K key, V value);

    /**
     * @param key
     * @return
     */
    V search(K key);
}
