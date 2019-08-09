package labrat.ds.bst;

import java.util.Arrays;

public abstract class BinarySearchTree {
    protected Node root;
    protected int size;

    abstract void Insert(int k);
    abstract void Remove(int k);

    public Node Search(int k) {
        Node parent = root;
        for(;;){
            if(parent==null) return null;
            if(parent.value==k) return parent;
            if(parent.value<k)
                parent = parent.right;
            else
                parent = parent.left;
        }
    }

    public int Max() {
        Node p = root;
        while (p.right!=null)
            p=p.right;
        return p.value;
    }

    public int Min() {
        Node p = root;
        while (p.left!=null)
            p=p.left;
        return p.value;
    }

    public int getSize() {
        return size;
    }

    public int[] Sorted(){
        int[] res = new int[size];
        if(size==0) return res;
        int cnt = 0;
        Node cur = root;
        Node prev = null;
        for(;;){
            if(prev==cur.parent) {
                prev=cur;
                if (cur.left != null) {
                    cur = cur.left;
                } else if (cur.right != null) {
                    res[cnt++] = cur.value;
                    if (cnt == size) return res;
                    cur = cur.right;
                } else {
                    res[cnt++] = cur.value;
                    if (cnt == size) return res;
                    cur=cur.parent;
                }
            } else if(prev==cur.left){
                prev=cur;
                res[cnt++] = cur.value;
                if (cnt == size) return res;
                if(cur.right!=null)
                    cur = cur.right;
                else
                    cur = cur.parent;
            } else if(prev==cur.right){
                prev=cur;
                cur=cur.parent;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Sorted());
    }

}
