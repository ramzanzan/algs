package ramzanzan.structures.bst;

public class Node<T> {
    protected Node<T> parent;
    protected Node<T> left;
    protected Node<T> right;
    protected T value;

    protected Node(){};
    public Node(T val){
        value=val;
    }

    public Node getParent(){ return parent; }
    public Node getLeft(){ return left; }
    public Node getRight(){ return right; }
    public T getValue(){ return value; }

    @Override
    public String toString() {
        return "val: "+value;
    }
}
