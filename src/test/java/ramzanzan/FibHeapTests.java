package ramzanzan;

import ramzanzan.structures.heaps.FibonacciHeap;
import ramzanzan.structures.heaps.BinaryHeap;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Random;

public class FibHeapTests {

    static class TestableFibHeap<T> extends FibonacciHeap<T>{
        public int getRootsSize(){
            if(min==null) return 0;
            FibonacciHeap.Node n = min;
            int count = 0;
            do{
                count++;
                n=n.right;
            }while (n!=min);
            return count;
        }
    }

    static TestableFibHeap<Integer> flatHeapOfSize(int size, int startKey){
        TestableFibHeap<Integer> fh = new TestableFibHeap<>();
        for(int i=0;i<size;++i)
            fh.insert(i+startKey,i+startKey);
        return fh;
    }

    static TestableFibHeap<Integer> consolidatedHeapOfSize(int size, int startKey){
        TestableFibHeap<Integer> fh = flatHeapOfSize(size,startKey);
        fh.insert(startKey-1,startKey-1);
        fh.removeMin();
        return fh;
    }

//    @RepeatedTest(value = 20)
//    void FibHeapTest(){
//        Random random = new Random();
//        int k = 100;
//        int[] arr = new int[k];
//        for (int i=0;i<k;++i)
//            arr[i]=random.nextInt(1000);
//        int[] arr2 = Arrays.copyOf(arr,arr.length);
//        Arrays.sort(arr2);
//
//        FibonacciHeap<Integer> fh = new FibonacciHeap<>();
//        BinaryHeap mh = new BinaryHeap();
//        fh.insert(arr[0],arr[0]);
//        mh.add(arr[0]);
//        for(int i=1;i<k;++i){
//            if(random.nextInt(10)==9 && mh.getSize()>0)
//
//                Assertions.assertEquals(mh.getMin(),fh.removeMin());
//            else{
//                mh.add(arr[i]);
//                fh.insert(arr[i],arr[i]);
//            }
//        }
//        System.out.println(fh);
//    }

    @Test
    @Order(0)
    void unionZeroThis(){
        TestableFibHeap<Integer> thiss = flatHeapOfSize(0,0);
        TestableFibHeap<Integer> that = flatHeapOfSize(1,42);
        thiss.union(that);
        Assertions.assertEquals(42,thiss.getMin());
        Assertions.assertEquals(1,thiss.getSize());
        Assertions.assertEquals(1,thiss.getRootsSize());
    }

    @Test
    @Order(0)
    void unionZeroThat(){
        TestableFibHeap<Integer> thiss = flatHeapOfSize(1,42);
        TestableFibHeap<Integer> that = flatHeapOfSize(0,0);
        thiss.union(that);
        Assertions.assertEquals(42,thiss.getMin());
        Assertions.assertEquals(1,thiss.getSize());
        Assertions.assertEquals(1,thiss.getRootsSize());
    }


    @Test
    @Order(1)
    void emptyHeap(){
        FibonacciHeap<Integer> fh = new FibonacciHeap<>();
        Assertions.assertNull(fh.removeMin());
    }

    @Test
    @Order(2)
    void oneElement(){
        FibonacciHeap<Integer> fh = flatHeapOfSize(1,0);
        Assertions.assertEquals(0,fh.removeMin());
    }

    @Test
    @Order(3)
    //Если тест пройден, то пирамида построенная с consolidatedHeapOfSize() корректна.
    void hasNeighborsAndNoChildren(){
        TestableFibHeap<Integer> fh = new TestableFibHeap<>();
        fh.insert(0,0);
        fh.insert(1,1);
        fh.insert(2,2);
        fh.insert(4,4);
        fh.insert(3,3);
        Assertions.assertEquals(0,fh.removeMin());
        Assertions.assertEquals(1,fh.getMin());
        Assertions.assertEquals(4,fh.getSize());
        Assertions.assertEquals(1,fh.getRootsSize());
    }

    @Test
    @Order(4)
    void noNeighborsAndHasChildren(){
        TestableFibHeap<Integer> fh = consolidatedHeapOfSize(8,0);
        Assertions.assertEquals(0,fh.removeMin());
        Assertions.assertEquals(1,fh.getMin());
        Assertions.assertEquals(7,fh.getSize());
        Assertions.assertEquals(3,fh.getRootsSize());
    }

    @Test
    @Order(4)
    void union(){
        TestableFibHeap<Integer> thiss = consolidatedHeapOfSize(8,24);
        TestableFibHeap<Integer> that = flatHeapOfSize(8,42);
        thiss.union(that);
        Assertions.assertEquals(24,thiss.getMin());
        Assertions.assertEquals(8+8,thiss.getSize());
        Assertions.assertEquals(1+8,thiss.getRootsSize());
    }

    @Test
    @Order(4)
    void hasNeighborsAndHasChildren(){
        TestableFibHeap<Integer> fh = consolidatedHeapOfSize(7,0);
        TestableFibHeap<Integer> addition = consolidatedHeapOfSize(7,8);
        fh.union(addition);
        Assertions.assertEquals(0, fh.removeMin());
        Assertions.assertEquals(1,fh.getMin());
        Assertions.assertEquals(13,fh.getSize());
        Assertions.assertEquals(3,fh.getRootsSize());
        System.out.println(fh);
    }
}
