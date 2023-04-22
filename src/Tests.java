import static org.junit.Assert.assertEquals;

public class Tests {
    @org.junit.jupiter.api.Test
    void RBT() {
        Tree<Integer, String> tprueba = new RedBlackTree();
        //El nodo root debe estar null al crear el arbol
        assertEquals(null, ((RedBlackTree<Integer, String>) tprueba).root);

        tprueba.insert(5,"5");
        // al agregar un nodo nuevo, este debe ser BLACK, que se confirma con root.color == false
        assertEquals(false, ((RedBlackTree<Integer, String>) tprueba).root.color);
        assertEquals("5", tprueba.search(5));

        tprueba.insert(8,"8");
        //Al insertar un nodo nuevo, este debería de ser rojo
        assertEquals(true, ((RedBlackTree<Integer, String>) tprueba).root.right.color);
        assertEquals("8", tprueba.search(8));

        tprueba.insert(9,"9");
        assertEquals("9", tprueba.search(9));
        // al ingresar otro nodo a la derecha, el arbol experimenta una rotación
        // y ahora 8 esta en root en lugar de 5
        assertEquals("8", ((RedBlackTree<Integer, String>) tprueba).root.value);
    }

    @org.junit.jupiter.api.Test
    void AVL() {
        Tree<Integer, String> tprueba = new AVLTree();
        //El nodo root debe estar null al crear el arbol
        assertEquals(null, ((AVLTree<Integer, String>) tprueba).root);

        tprueba.insert(5,"5");
        //Al insertar un nodo nuevo, su altura debe ser 1
        assertEquals("5", tprueba.search(5));
        assertEquals(1, ((AVLTree<Integer, String>) tprueba).root.height);

        tprueba.insert(8,"8");
        //Al insertar otro nodo a la derecha, la altura de root debe ser 2
        assertEquals("8", tprueba.search(8));
        assertEquals(2, ((AVLTree<Integer, String>) tprueba).root.height);

        tprueba.insert(9,"9");
        //Al insertar otro nodo a la derecha, la altura de root sobrepasa 2, por lo que en
        //teoría se corre hacia la izquierda, regresando la altura de root a 2.
        //Esto se comprueba revisando que ahora el nodo a la izquierda es 5 y root es 8
        assertEquals("9", tprueba.search(9));
        assertEquals(2, ((AVLTree<Integer, String>) tprueba).root.height);
        assertEquals("5", ((AVLTree<Integer, String>) tprueba).root.left.value);
        assertEquals("8", ((AVLTree<Integer, String>) tprueba).root.value);
    }
}