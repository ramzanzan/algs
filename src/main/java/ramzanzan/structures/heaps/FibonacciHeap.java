package ramzanzan.structures.heaps;
//todo redo
public class FibonacciHeap<T> {

    protected Node min;
    protected int size;

    public FibonacciHeap(){
        min = null;
        size = 0;
    }

    public void insert(int key, T val){
        Node n = new Node(val,key);
        if(min==null){
            min=n;
            n.left=n;
            n.right=n;
        }else {
            Node tmp = min.right;
            min.right=n;
            n.left=min;
            n.right=tmp;
            tmp.left=n;
            if(n.key<min.key)
                min=n;
        }
        ++size;
    }

    public T getMin(){
        return min.value;
    }

    public void union(FibonacciHeap<T> heap){
        if(heap==null) return;
        if(heap.size==0) return;
        if(size==0){
            min=heap.min;
            size=heap.size;
            return;
        }
        Node leftThis = min.left;
        Node leftThat = heap.min.left;
        leftThis.right = heap.min;
        heap.min.left=leftThis;
        leftThat.right=min;
        min.left=leftThat;
        if(heap.min.key<min.key)
            min=heap.min;
        size+=heap.size;
    }

    public T removeMin(){
        if(min==null) return null;
        Node removed = min;
        if(removed.left==removed && removed.child==null) {   //нет соседей, нет детей
            --size;
            min=null;
            return removed.value;
        }
        if(removed.left!=removed && removed.child==null){   //есть соседи, нет детей
            removed.left.right=removed.right;
            removed.right.left=removed.left;
            min=removed.left;
        } else {    //  есть дети и ...
            Node sibling = removed.child;
            do{
                sibling.parent = null;
                sibling = sibling.right;
            } while (sibling!=removed.child);
            min = removed.child;
            if(removed.left!=removed){ // ... есть соседи
                removed.left.right = removed.child;
                removed.right.left = removed.child.left;
                removed.child.left.right = removed.right;
                removed.child.left = removed.left;
            }
        }
        consolidate();
        --size;
        return removed.value;
    }

    void consolidate(){
        Object[] byDegree = new Object[maxDegree(size)+1];
        int rootsCount = 0;
        Node fromRoots = min;
        do{
            rootsCount++;
            fromRoots = fromRoots.right;
        } while (fromRoots!=min);

        do {
            int d = fromRoots.degree;
            Node next = fromRoots.right;
            while (byDegree[d]!=null){
                Node other = (Node)byDegree[d];
                if(other.key<fromRoots.key){
                    Node tmp = other;
                    other=fromRoots;
                    fromRoots=tmp;
                }
                other.left.right=other.right;
                other.right.left=other.left;
                if(fromRoots.child==null) {
                    fromRoots.child = other;
                    other.left=other;
                    other.right=other;
                }
                else {
                    other.left = fromRoots.child;
                    other.right = fromRoots.child.right;
                    other.left.right = other;
                    other.right.left = other;
                }
                other.parent=fromRoots;
                byDegree[d]=null;
                ++fromRoots.degree;
                ++d;
            }
            byDegree[d]=fromRoots;
            fromRoots=next;
        }while (--rootsCount!=0);

        min=null;
        for(Object n : byDegree){
            if(n==null) continue;
            Node node = (Node)n;
            if(min==null || node.key<min.key)
                min=node;
        }
    }

    int maxDegree(int n){
        return n;
    }

    public T Remove(int k){
        return null;
    }

    public T Remove(T e){
       return null;
    }

    public void DecreaseKey(T e){

    }

    public int getSize() {
        return size;
    }

    protected class Node {
        public T value;
        public Node left, right, parent, child;
        public int key;
        public int degree;      // кол-во детей
        public boolean mark;    // были ли удаления детей с момента последней смены родителя
        Node(T val, int key){
            value=val;
            this.key=key;
            degree=0;
            mark=false;
        }

    }

    @Override
    public String toString() {
        if(min==null) return "empty";
        StringBuilder sb = new StringBuilder();
        printLevel(sb,min,0);
        return sb.toString();
    }

    private void printLevel(StringBuilder sb, Node level, int depth){
        if(level==null) return;
        Integer pkey = level.parent!=null ? level.parent.key : null;
        sb.append("depth: ").append(depth).append(" pkey: ")
                .append(pkey).append("\t\t");
        Node n = level;
        do {
            sb.append(n.key).append(" ");
            n=n.right;
        }while (n!=level);
        sb.append("\n");
        do{
            printLevel(sb,n.child,depth+1);
            n=n.right;
        }while (n!=level);
    }
}
