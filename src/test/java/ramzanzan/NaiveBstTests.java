package ramzanzan;

import ramzanzan.structures.bst.NaiveBst;
import ramzanzan.structures.bst.Node;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NaiveBstTests {

    int[] ref = {5,3,6,1,6,9,2,7,10,7};
    int[] refSorted;
    int[] refIR1;
    int[] refIR2;
    NaiveBst refNaiveBST;

//    @BeforeAll
////    void Init(){
////        refSorted = Arrays.copyOf(ref,ref.length);
////        Arrays.sort(refSorted);
////
////        Node n0 = new Node(null,5);
////        Node n1 = new Node(n0,3);
////        Node n2 = new Node(n0,6);
////        n0.setLeft(n1); n0.setRight(n2);
////        Node n30 = new Node(n1,1);
////        n1.setLeft(n30);
////        Node n3 = new Node(n30,2);
////        n30.setRight(n3);
////        Node n4 = new Node(n2,6);
////        Node n5 = new Node(n2,9);
////        n2.setLeft(n4); n2.setRight(n5);
////        Node n8 = new Node(n5,7);
////        Node n9 = new Node(n5,10);
////        n5.setLeft(n8); n5.setRight(n9);
////        Node n10 = new Node(n8,7);
////        n8.setLeft(n10);
////
////        refNaiveBST = new NaiveBst(n0,10);
////    }
////
////    @Test
////    void RefSorted(){
////        Assertions.assertArrayEquals(refSorted,refNaiveBST.toArray());
////    }
////
////    @Test
////    void FromArrSorted(){
////        NaiveBst bst = new NaiveBst(ref);
////        Assertions.assertArrayEquals(refSorted,bst.toArray());
////    }
////
////    @Test
////    void RemoveRoot(){
////        NaiveBst bst = new NaiveBst(ref);
////        bst.remove(5);
////        int[] ref = {3,6,1,6,9,2,7,10,7};
////        Arrays.sort(ref);
////        Assertions.assertArrayEquals(ref,bst.toArray());
////    }
////
////    @Test
////    void MaxTest(){
////        NaiveBst bst = new NaiveBst(ref);
////        Assertions.assertEquals(10,bst.Max());
////        bst.remove(10);
////        Assertions.assertEquals(9,bst.Max());
////    }
////
////    @Test
////    void MinTest(){
////        NaiveBst bst = new NaiveBst(ref);
////        Assertions.assertEquals(1,bst.min());
//        bst.remove(1);
//        Assertions.assertEquals(2,bst.min());
//    }
}
