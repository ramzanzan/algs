package ramzanzan;

import ramzanzan.algorithms.Sort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.Random;

public class CountingSortTests {

    int[] Ints;
    int[] ReferenceArr;
    Random random = new Random();

    @BeforeEach
    void FillRef(){
        int len = 500+random.nextInt(2);
        Ints = new int[len];
        for(int i=0;i<Ints.length;i++)
            Ints[i]=random.nextInt(1000)-500;
        ReferenceArr = Arrays.copyOf(Ints,Ints.length);
        Arrays.sort(ReferenceArr);
    }

    @RepeatedTest(1000)
    void CountingSortTest(){
        int[] res = Sort.CountingSort.Sort(Ints);
        Assertions.assertArrayEquals(ReferenceArr,res);
    }
}
