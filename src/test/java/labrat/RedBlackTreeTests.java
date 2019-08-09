package labrat;

import labrat.ds.bst.NaiveBST;
import labrat.ds.bst.Node;
import labrat.ds.bst.RedBlackTree;
import org.junit.jupiter.api.*;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RedBlackTreeTests {

    int[] ref = {5,3,6,1,6,9,2,7,10,7,3,52,562,5212,73,35,8,543,67,98,14,67,8,124,848,5,-1,0,124,-1214,124};
    int[] refSorted;
    int[] refIR1;
    int[] refIR2;

    @BeforeAll
    void Init(){
        refSorted = Arrays.copyOf(ref,ref.length);
        Arrays.sort(refSorted);
    }

    @Test
    void FromArrSorted(){
        RedBlackTree bst = new RedBlackTree(ref);
        Assertions.assertArrayEquals(refSorted,bst.Sorted());
    }

    @Test
    @Disabled
    void RemoveRoot(){
        RedBlackTree bst = new RedBlackTree(ref);
        bst.Remove(5);
        int[] ref = {3,6,1,6,9,2,7,10,7};
        Arrays.sort(ref);
        Assertions.assertArrayEquals(ref,bst.Sorted());
    }

    @Test
    @Disabled
    void MaxTest(){
        NaiveBST bst = new NaiveBST(ref);
        Assertions.assertEquals(10,bst.Max());
        bst.Remove(10);
        Assertions.assertEquals(9,bst.Max());
    }

    @Test
    @Disabled
    void MinTest(){
        NaiveBST bst = new NaiveBST(ref);
        Assertions.assertEquals(1,bst.Min());
        bst.Remove(1);
        Assertions.assertEquals(2,bst.Min());
    }
}
