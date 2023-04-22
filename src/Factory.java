public class Factory {
    public static <K extends Comparable<K>, V> Tree<K, V> TreeGen(String treeType) {
        if (treeType != null) {
            switch (treeType.toLowerCase()) {
                case "avl":
                    return new AVLTree<>();
                case "rbt":
                    return new RedBlackTree<>();
                default:
                    throw new IllegalArgumentException("Invalid tree type");
            }
        } else{
            throw new IllegalArgumentException("Invalid tree type");
        }
    }
}
