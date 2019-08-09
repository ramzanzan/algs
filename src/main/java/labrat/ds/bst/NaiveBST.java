package labrat.ds.bst;

public class NaiveBST extends BinarySearchTree {

    public NaiveBST(Node root, int size){
        Insert(root);
        this.size=size;
    }

    public NaiveBST(int[] arr){
        for(int e:arr)
            Insert(e);
    }

    void Insert(Node node){
        ++size;
        if(root==null){
            root=node;
            return;
        }
        Node parent = this.root;
        boolean dir;
        for(;;){
            dir = node.value > parent.value;
            if(dir && parent.right!=null)
                parent=parent.right;
            else if(!dir && parent.left!=null)
                parent=parent.left;
            else
                break;
        }
        if(dir) {
            node.parent=parent;
            parent.right = node;
        }
        else {
            node.parent=parent;
            parent.left = node;
        }
    }

    @Override
    public void Insert(int k) {
        Node node = new Node();
        node.value=k;
        Insert(node);

    }

    @Override
    public void Remove(int k) {
        Node n = Search(k);
        if(n==null) return;
        Node p = n.parent;
        if(p!=null) {
            if (p.right == n)
                p.right = n.left;
            else
                p.left = n.left;
        }
        else
            root = n.left;
        if(n.left!=null)
            n.left.parent = n.parent;
        if(n.right!=null) {
            n.right.parent = null;
            Insert(n.right);
            --size;
        }
        --size;
    }
}

