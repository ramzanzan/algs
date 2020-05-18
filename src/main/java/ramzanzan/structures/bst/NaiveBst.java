package ramzanzan.structures.bst;

public class NaiveBst<T> extends BinarySearchTree<T> {

    public NaiveBst(T[] arr){
        for (T t : arr) insert(t);
    }

    @Override
    public void insert(T e) {
        var node = new Node<T>();
        node.value=e;
        size++;
        if(root==null){
            root=node;
            return;
        }
        var parent = this.root;
        boolean dir;
        for(;;){
            dir = cpr.compare(node.value, parent.value)>0;
            if(dir && parent.right!=null)
                parent=parent.right;
            else if(!dir && parent.left!=null)
                parent=parent.left;
            else
                break;
        }
        node.parent=parent;
        if(dir) parent.right = node;
        else parent.left = node;
    }

    @Override
    public void remove(T e) {
        //todo
//        Node n = search(k);
//        if(n==null) return;
//        Node p = n.parent;
//        if(p!=null) {
//            if (p.right == n)
//                p.right = n.left;
//            else
//                p.left = n.left;
//        }
//        else
//            root = n.left;
//        if(n.left!=null)
//            n.left.parent = n.parent;
//        if(n.right!=null) {
//            n.right.parent = null;
//            insert(n.right);
//            --size;
//        }
//        --size;
    }
}

