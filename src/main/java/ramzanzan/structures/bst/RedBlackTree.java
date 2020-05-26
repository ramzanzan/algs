package ramzanzan.structures.bst;


/***
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
    private RedBlackNode<T> nil = new RedBlackNode<>();
    private RedBlackNode<T> root = nil;

    public RedBlackTree(){}

    public RedBlackTree(int[] arr) {
    }

    private void rotateLeft(RedBlackNode<T> node) {
        var parent = node.parent;
        var rightChild = node.right;
        rightChild.left=node;
        if(root==node)
            root=(RedBlackNode<T>)rightChild;
        else if (parent.left == node)
            parent.left = rightChild;
        else
            parent.right = rightChild;
        rightChild.parent=parent;
        if(rightChild.left!=nil){
            rightChild.left.parent=node;
        }
        node.right=rightChild.left;
        node.parent=rightChild;
    }

    private void rotateRight(RedBlackNode<T> node){
        var parent = node.parent;
        var leftChild = node.left;
        if(root==node)
            root=(RedBlackNode<T>)leftChild;
        else if (parent.left == node)
            parent.left = leftChild;
        else
            parent.right = leftChild;
        leftChild.parent=parent;
        if(leftChild.right!=nil){
            leftChild.right.parent=node;
        }
        node.left=leftChild.right;
        node.parent=leftChild;
        leftChild.right=node;
    }

    @Override
    public void insert(T k) {
        var n = new RedBlackNode<T>(k);
        var y = nil;
        var x = root;
        while (x!=nil) {
            y = x;
            if (cpr.compare(k,x.value) < 0)
                x = (RedBlackNode<T>) x.left;
            else
                x = (RedBlackNode<T>) x.right;
        }
        if(y==nil)
            root=n;
        else if(cpr.compare(k,y.value)<0)
            y.left=n;
        else
            y.right=n;
        n.parent=y;
        n.left=nil;
        n.right=nil;
        n.blackNotRed=false;
        size++;
        fixUp(n);
    }

    private void fixUp(RedBlackNode<T> z) {
        while (!z.getParent().blackNotRed){
            if(z.parent==z.parent.parent.left){
                var y = z.getParent().getParent().getRight();
                if(!y.blackNotRed){
                    z.getParent().blackNotRed=true;
                    y.blackNotRed=true;
                    z.getParent().getParent().blackNotRed=false;
                    z=z.getParent().getParent();
                }
                else{
                    if(z==z.parent.right) {
                        z=z.getParent();
                        rotateLeft(z);
                    }
                    z.getParent().blackNotRed=true;
                    z.getParent().getParent().blackNotRed=false;
                    rotateRight(z.getParent().getParent());
                }
            }else {
                var y = z.getParent().getParent().getLeft();
                if(!y.blackNotRed){
                    z.getParent().blackNotRed=true;
                    y.blackNotRed=true;
                    z.getParent().getParent().blackNotRed=false;
                    z=z.getParent().getParent();
                }
                else{
                    if(z==z.parent.left) {
                        z=z.getParent();
                        rotateRight(z);
                    }
                    z.getParent().blackNotRed=true;
                    z.getParent().getParent().blackNotRed=false;
                    rotateLeft(z.getParent().getParent());
                }
            }
        }
        root.blackNotRed=true;
    }

    @Override
    public void remove(T k) {
        //todo
    }

}
