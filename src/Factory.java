public class Factory {
    public static <K extends Comparable<K>, V> Tree<K, V> TreeGen(String treeType) {
        if (treeType != null) {
            //Se evalúa el tipo de mapeo escogido .toLowerCase
            switch (treeType.toLowerCase()) {
                case "avl":
                    return new AVLTree<>();
                case "rbt":
                    return new RedBlackTree<>();
                default:
                    //Si el ingreso es invalido se ejecuta una excepción
                    throw new IllegalArgumentException("Invalid tree type");
            }
        } else{
            throw new IllegalArgumentException("Invalid tree type");
        }
    }
}
