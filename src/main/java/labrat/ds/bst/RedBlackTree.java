package labrat.ds.bst;

public class RedBlackTree extends BinarySearchTree {
    NodeRB nil;

    public RedBlackTree(int[] arr) {
        nil = new NodeRB(null, 0);
        nil.blackNotRed = true;
        root = nil;
        for (int e : arr)
            Insert(e);
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
    public void Insert(int k) {
        NodeRB node = new NodeRB(null, k);
        Node y = nil;
        Node x = root;
        while (x != nil) {
            y = x;
            if (node.value <= x.value)
                x = x.left;
            else
                x = x.right;
        }
        node.parent = y;
        if (y == nil)
            root = node;
        else if (node.value <= y.value)
            y.left = node;
        else
            y.right = node;
        node.left = nil;
        node.right = nil;
        node.blackNotRed = false;
        FixTree(node);
        ++size;
    }

    void FixTree(NodeRB node) {
        while (!node.getParent().blackNotRed) {
//            if(node.parent==node.parent.parent.left){
            boolean dir = node.parent == node.parent.parent.left;
            NodeRB y = node.getParent().getParent().getRight();
            if (!y.blackNotRed) {
                node.getParent().blackNotRed = true;
                y.blackNotRed = true;
                node.getParent().getParent().blackNotRed = false;
                node = node.getParent().getParent();
            } else {
                if (node == node.parent.right) {
                    node = node.getParent();
                    Rotate(node, !dir);
                }
                node.getParent().blackNotRed = true;
                node.getParent().getParent().blackNotRed = false;
                Rotate(node.getParent().getParent(), dir);
            }
        }
        ((NodeRB) root).blackNotRed = true;
    }

    @Override
    public void Remove(int k) {
        //todo
    }

    @Override
    public int[] Sorted() {
        int[] res = new int[size];
        if (size == 0) return res;
        int cnt = 0;
        Node cur = root;
        Node prev = nil;
        for (; ; ) {
            if (prev == cur.parent) {
                prev = cur;
                if (cur.left != nil) {
                    cur = cur.left;
                } else if (cur.right != nil) {
                    res[cnt++] = cur.value;
                    if (cnt == size) return res;
                    cur = cur.right;
                } else {
                    res[cnt++] = cur.value;
                    if (cnt == size) return res;
                    cur = cur.parent;
                }
            } else if (prev == cur.left) {
                prev = cur;
                res[cnt++] = cur.value;
                if (cnt == size) return res;
                if (cur.right != nil)
                    cur = cur.right;
                else
                    cur = cur.parent;
            } else if (prev == cur.right) {
                prev = cur;
                cur = cur.parent;
            }
        }
    }
}
