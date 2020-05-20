package ramzanzan.structures.bst;

import java.util.Arrays;
import java.util.Comparator;

public abstract class BinarySearchTree<T> {
    protected Node<T> root;
    protected int size;
    protected Comparator<T> cpr;

    abstract void insert(T e);
    abstract void remove(T e);

    protected Node<T> findNode(T e){
        Node<T> parent = root;
        for(;;){
            if(parent==null) return null;
            if(parent.value.equals(e)) return parent;
            if(cpr.compare(parent.value,e)<0)
                parent = parent.right;
            else
                parent = parent.left;
        }
    }

    public T find(T e) {
        var n = findNode(e);
        return n!=null ? n.value : null;
    }

    public T max() {
        Node<T> p = root;
        while (p.right!=null)
            p=p.right;
        return p.value;
    }

    public T min() {
        Node<T> p = root;
        while (p.left!=null)
            p=p.left;
        return p.value;
    }

    public int getSize() {
        return size;
    }

    public Comparator<T> getComparator(){
        return cpr;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(){
        T[] res = (T[]) new Object[size];
        if(size==0) return res;
        int cnt = 0;
        Node<T> curr = root;
        Node<T> prev = null;
        for(;;){
            if(prev==curr.parent) {
                prev=curr;
                if (curr.left != null) {
                    curr = curr.left;
                } else if (curr.right != null) {
                    res[cnt++] = curr.value;
                    if (cnt == size) return res;
                    curr = curr.right;
                } else {
                    res[cnt++] = curr.value;
                    if (cnt == size) return res;
                    curr=curr.parent;
                }
            } else if(prev==curr.left){
                prev=curr;
                res[cnt++] = curr.value;
                if (cnt == size) return res;
                if(curr.right!=null)
                    curr = curr.right;
                else
                    curr = curr.parent;
            } else if(prev==curr.right){
                prev=curr;
                curr=curr.parent;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

}
