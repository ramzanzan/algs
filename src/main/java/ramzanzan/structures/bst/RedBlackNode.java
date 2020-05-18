package ramzanzan.structures.bst;

public class RedBlackNode<T> extends Node<T> {
    protected boolean blackNotRed;

    protected RedBlackNode(){}

    public RedBlackNode(T e){
        value=e;
    }

    public boolean getColor(){ return blackNotRed; }
}
