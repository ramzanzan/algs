package ramzanzan;

import ramzanzan.algorithms.Sort;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;
import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SortsTests {

    int[] ints;
    int[] referenceArr;
    Random random = new Random();

    @BeforeEach
    void FillRef(){
        int len = 500+random.nextInt(2);
        ints = new int[len];
        for(int i = 0; i< ints.length; i++)
            ints[i]=random.nextInt();
        referenceArr = Arrays.copyOf(ints, ints.length);
        Arrays.sort(referenceArr);
    }

    @RepeatedTest(100)
    void MergeSortTest(){
//        Sort.MergeSort.Sort(ints);
//        Assertions.assertArrayEquals(referenceArr, ints);
    }

    @RepeatedTest(100)
    void HeapSortTest(){
        new Sort.HeapSort().sort(ints);
        Assertions.assertArrayEquals(referenceArr, ints);
    }

    @RepeatedTest(100)
    void QuickSortTest(){
        new Sort.QuickSort().sort(ints);
        Assertions.assertArrayEquals(referenceArr, ints);
    }

    @RepeatedTest(100)
    void InsertionSort(){
        new Sort.InsertionSort().sort(ints);
        Assertions.assertArrayEquals(referenceArr,ints);
    }
}
