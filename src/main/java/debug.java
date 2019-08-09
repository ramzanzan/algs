import labrat.ds.bst.NaiveBST;
import labrat.ds.bst.Node;

import java.util.Arrays;

public class debug{
    public static void main(String[] args) {

        int[] ref = {5,3,6,1,6,9,2,7,10,7};

        NaiveBST refNaiveBST;
        Node n0 = new Node(null,5);
        Node n1 = new Node(n0,3);
        Node n2 = new Node(n0,6);
        n0.setLeft(n1); n0.setRight(n2);
        Node n30 = new Node(n1,1);
        n1.setLeft(n30);
        Node n3 = new Node(n30,2);
        n30.setRight(n3);
        Node n4 = new Node(n2,6);
        Node n5 = new Node(n2,9);
        n2.setLeft(n4); n2.setRight(n5);
        Node n8 = new Node(n5,7);
        Node n9 = new Node(n5,10);
        n5.setLeft(n8); n5.setRight(n9);
        Node n10 = new Node(n8,7);
        n8.setLeft(n10);
        refNaiveBST = new NaiveBST(n0,10);

        int[] sorted = Arrays.copyOf(ref,ref.length);
        Arrays.sort(sorted);
        System.out.println(Arrays.toString(sorted));
        System.out.println(Arrays.toString(refNaiveBST.Sorted()));
        NaiveBST bst = new NaiveBST(ref);
        System.out.println(Arrays.toString(bst.Sorted()));

        bst.Remove(7);
        System.out.println(bst);
        System.out.println(bst.Max());
        bst.Remove(3);
        System.out.println(bst);
        bst.Remove(5);
        System.out.println(bst);


    }
}
