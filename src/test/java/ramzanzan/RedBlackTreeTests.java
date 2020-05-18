package ramzanzan;

import ramzanzan.structures.bst.NaiveBst;
import ramzanzan.structures.bst.RedBlackTree;
import org.junit.jupiter.api.*;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RedBlackTreeTests {

    int[] ref = {5,3,6,1,6,9,2,7,10,7,3,52,562,5212,73,35,8,543,67,98,14,67,8,124,848,5,-1,0,124,-1214,124};
    int[] refSorted;
    int[] refIR1;
    int[] refIR2;

//    @BeforeAll
////    void Init(){
////        refSorted = Arrays.copyOf(ref,ref.length);
////        Arrays.sort(refSorted);
////    }
////
////    @Test
////    void FromArrSorted(){
////        RedBlackTree bst = new RedBlackTree(ref);
////        Assertions.assertArrayEquals(refSorted,bst.toArray());
////    }
////
////    @Test
////    @Disabled
////    void RemoveRoot(){
////        RedBlackTree bst = new RedBlackTree(ref);
////        bst.remove(5);
////        int[] ref = {3,6,1,6,9,2,7,10,7};
////        Arrays.sort(ref);
////        Assertions.assertArrayEquals(ref,bst.toArray());
////    }
////
////    @Test
////    @Disabled
////    void MaxTest(){
////        NaiveBst bst = new NaiveBst(ref);
////        Assertions.assertEquals(10,bst.Max());
////        bst.remove(10);
////        Assertions.assertEquals(9,bst.Max());
////    }
////
////    @Test
////    @Disabled
////    void MinTest(){
////        NaiveBst bst = new NaiveBst(ref);
////        Assertions.assertEquals(1,bst.min());
////        bst.remove(1);
//        Assertions.assertEquals(2,bst.min());
//    }
}
