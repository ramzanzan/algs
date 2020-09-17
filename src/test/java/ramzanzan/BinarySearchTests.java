package ramzanzan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ramzanzan.algorithms.Algorithms.binarySearch;
import static ramzanzan.algorithms.Algorithms.binarySearchRecursive;

public class BinarySearchTests {

    int[] emptyArr = {};
    int[] arr = {0,1,2,4,8,16,32,64,128,256,1024};

    @Test  void _empty(){
        assertEquals(-1, binarySearch(emptyArr,1));
    }

    @Test  void _firstElem(){
        assertEquals(0,binarySearch(arr,0));
    }

    @Test  void _lastElem(){
        assertEquals(10,binarySearch(arr,1024));
    }

    @Test  void _someElem(){
        assertEquals(3,binarySearch(arr,4));
    }

    @Test  void _noElem(){
        assertEquals(-1,binarySearch(arr,111));
        assertEquals(-1,binarySearch(arr,1023));
        assertEquals(-1,binarySearch(arr,3));
    }

    @Test  void __empty(){
        assertEquals(-1, binarySearchRecursive(emptyArr,1));
    }

    @Test  void __firstElem(){
        assertEquals(0,binarySearchRecursive(arr,0));
    }

    @Test  void __lastElem(){
        assertEquals(10,binarySearchRecursive(arr,1024));
    }

    @Test  void __someElem(){
        assertEquals(3,binarySearchRecursive(arr,4));
    }

    @Test  void __noElem(){
        assertEquals(-1,binarySearchRecursive(arr,3));
        assertEquals(-1,binarySearchRecursive(arr,111));
        assertEquals(-1,binarySearchRecursive(arr,1023));
    }
}
