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
        Node<T> n = findNode(e);
        if(n==null) return;

        Node<T> p = n.parent, succ;
        if(n.left==null){
            succ=n.right;
        }
        else if(n.right==null){
            succ=n.left;
        }else {
            succ=n.left;
            Node<T> mostRight = succ;
            while (mostRight.right!=null)
                mostRight=mostRight.right;
            mostRight.right=n.right;
            n.right.parent=mostRight;
        }

        succ.parent=p;
        if(p!=null){
            if(p.left==n)
                p.left=succ;
            else
                p.right=succ;
        }else{
            root=succ;
        }
        --size;
    }
}

