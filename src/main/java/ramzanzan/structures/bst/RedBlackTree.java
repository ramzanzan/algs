package ramzanzan.structures.bst;


/***
 * Simple path is a number of black nodes from node X to Y (inclusive X and Y)
 *
 * RBTree h <= 2log(n+1)
 *
 * Props:
 * 1) nodes are red or black
 * 2) root is black
 * 3) leaves (NILs) are black
 * 4) descendants of red node are black
 * 5) all paths from node to leaves have equivalent number of black nodes
 */
public class RedBlackTree<T> extends BinarySearchTree<T> {
    RedBlackNode nil;

    public RedBlackTree(int[] arr) {
//        nil = new RedBlackNode(null, 0);
//        nil.blackNotRed = true;
//        root = nil;
//        for (int e : arr)
//            insert(e);
    }

    void Rotate(Node node, boolean rightNotLeft) {
        Node rising = rightNotLeft ? node.left : node.right;
        if (rising == nil) throw new IllegalArgumentException("Rising node is NIL");
        if (node.parent.left == node)
            node.parent.left = rising;
        else
            node.parent.right = rising;
        rising.parent = node.parent;
        node.parent = rising;

        Node central;
        if (rightNotLeft) {
            central = rising.right;
            node.left = central;
            rising.right = node;
        } else {
            central = rising.left;
            node.right = central;
            rising.left = node;
        }
        if (central != nil) central.parent = node;
    }

    @Override
    public void insert(T k) {
//        RedBlackNode node = new RedBlackNode(null, k);
//        Node y = nil;
//        Node x = root;
//        while (x != nil) {
//            y = x;
//            if (node.value <= x.value)
//                x = x.left;
//            else
//                x = x.right;
//        }
//        node.parent = y;
//        if (y == nil)
//            root = node;
//        else if (node.value <= y.value)
//            y.left = node;
//        else
//            y.right = node;
//        node.left = nil;
//        node.right = nil;
//        node.blackNotRed = false;
//        FixTree(node);
//        ++size;
    }

    void FixTree(RedBlackNode node) {
//        while (!node.getParent().blackNotRed) {
////            if(node.parent==node.parent.parent.left){
//            boolean dir = node.parent == node.parent.parent.left;
//            RedBlackNode y = node.getParent().getParent().getRight();
//            if (!y.blackNotRed) {
//                node.getParent().blackNotRed = true;
//                y.blackNotRed = true;
//                node.getParent().getParent().blackNotRed = false;
//                node = node.getParent().getParent();
//            } else {
//                if (node == node.parent.right) {
//                    node = node.getParent();
//                    Rotate(node, !dir);
//                }
//                node.getParent().blackNotRed = true;
//                node.getParent().getParent().blackNotRed = false;
//                Rotate(node.getParent().getParent(), dir);
//            }
//        }
//        ((RedBlackNode) root).blackNotRed = true;
    }

    @Override
    public void remove(T k) {
        //todo
    }

}