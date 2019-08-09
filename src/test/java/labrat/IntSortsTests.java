package labrat;

import labrat.algs.IntSorts;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;
import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IntSortsTests {

    int[] Ints;
    int[] ReferenceArr;
    Random random = new Random();

    @BeforeEach
    void FillRef(){
        int len = 500+random.nextInt(2);
        Ints = new int[len];
        for(int i=0;i<Ints.length;i++)
            Ints[i]=random.nextInt();
        ReferenceArr = Arrays.copyOf(Ints,Ints.length);
        Arrays.sort(ReferenceArr);
    }

    @RepeatedTest(1000)
    void MergeSortTest(){
        IntSorts.MergeSort.Sort(Ints);
        Assertions.assertArrayEquals(ReferenceArr,Ints);
    }

    @RepeatedTest(1000)
    void HeapSortTest(){
        IntSorts.HeapSort.Sort(Ints);
        Assertions.assertArrayEquals(ReferenceArr,Ints);
    }

    @RepeatedTest(1000)
    void QuickSortTest(){
        IntSorts.QuickSort.Sort(Ints);
        Assertions.assertArrayEquals(ReferenceArr,Ints);
    }

}
