package labrat.ds.bst;

public class Node {
    Node parent;
    Node left;
    Node right;
    int value;

    public Node(){};
    public Node(Node parent){ this.parent = parent; }
    public Node(Node parent, int val){
        this.parent=parent;
        value=val;
    }

    public Node getParent(){ return parent; }
    public void setParent(Node parent){ this.parent=parent; }
    public Node getLeft(){ return left; }
    public void setLeft(Node left){ this.left=left; }
    public Node getRight(){ return right; }
    public void setRight(Node right){ this.right=right; }
    public int getValue(){ return value; }
    public void setValue(){ this.value=value; }

    @Override
    public String toString() {
        return "val: "+value;
    }
}
