package ramzanzan.structures.bst;

public class RedBlackNode<T> extends Node<T> {
    protected boolean blackNotRed = true;

    protected RedBlackNode(){}

    public RedBlackNode(T e){
        value=e;
    }

    @Override
    public RedBlackNode<T> getParent() {
        return (RedBlackNode<T>) parent;
    }
    @Override
    public RedBlackNode<T> getLeft() {
        return (RedBlackNode<T>) left;
    }
    @Override
    public RedBlackNode<T> getRight(){
        return (RedBlackNode<T>) right;
    }

    public boolean getColor(){ return blackNotRed; }
}
