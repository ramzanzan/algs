package labrat.ds.bst;

public class NodeRB extends Node {
    boolean blackNotRed;

    public NodeRB(){}

    public NodeRB(NodeRB p,int k){
        parent=p;
        value=k;
    }

    @Override
    public NodeRB getParent() {
        return (NodeRB)super.getParent();
    }

    @Override
    public NodeRB getLeft() {
        return (NodeRB)super.getLeft();
    }

    @Override
    public NodeRB getRight() {
        return (NodeRB)super.getRight();
    }

    boolean getColor(){ return blackNotRed; }
    void setColor(boolean blackNotRed){ this.blackNotRed=blackNotRed; }
}
