package ramzanzan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ramzanzan.algorithms.BinarySearch;

public interface BinarySearchTests {

    int[] emptyArr = {};
    int[] arr = {0,1,2,4,8,16,32,64,128,256,1024};

    BinarySearch impl();

    @Test default void empty(){
        Assertions.assertEquals(-1, impl().search(emptyArr,1));
    }

    @Test default void firstElem(){
        Assertions.assertEquals(0,impl().search(arr,0));
    }

    @Test default void lastElem(){
        Assertions.assertEquals(10,impl().search(arr,1024));
    }

    @Test default void someElem(){
        Assertions.assertEquals(3,impl().search(arr,4));
    }

    @Test default void noElem(){
        Assertions.assertEquals(-1,impl().search(arr,111));
        Assertions.assertEquals(-1,impl().search(arr,1023));
        Assertions.assertEquals(-1,impl().search(arr,3));
    }
}

class CyclicTests implements BinarySearchTests{
    @Override
    public BinarySearch impl() {
        return new BinarySearch.Cyclic();
    }
}

class RecursiveTests implements BinarySearchTests{
    @Override
    public BinarySearch impl() {
        return new BinarySearch.Recursive();
    }
}
