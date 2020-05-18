package ramzanzan.structures.heaps;

import java.util.Arrays;
import java.util.Comparator;

public class BinaryHeap<T> implements MinHeap<T> {
    private int size;
    private T[] arr;
    private Comparator<T> cpr;

    public BinaryHeap(T[] arr, Comparator<T> cpr){
        this.cpr=cpr;
        this.arr=arr;
        size=arr.length;
        for(int i=size/2-1; i>=0; i--)
            heapify(i);
    }

    @SuppressWarnings("unchecked")
    public BinaryHeap(Comparator<T> comparator){
        size = 0;
        arr = (T[]) new Object[10];
        cpr = comparator;
    }

    @Override
    public int getSize() {
        return size;
    }

    private int parentIdx(int i) {
        return (i-2+i%2)/2;
    }

    private int leftIdx(int i) {
        return i*2+1;
    }

    private int rightIdx(int i) {
        return i*2+2;
    }

    public void heapify(int i) {
        int l= leftIdx(i);
        int r= rightIdx(i);
        int min = i;
        if(l< size && cpr.compare(arr[l],arr[i])<0)
            min=l;
        if(r< size && cpr.compare(arr[r],arr[min])<0)
            min=r;
        if(i!=min){
            T tmp = arr[i];
            arr[i]= arr[min];
            arr[min]=tmp;
            heapify(min);
        }
    }

    public void add(T e){
        if(size == arr.length){
            arr = Arrays.copyOf(arr,size*2);
        }
        ++size;
        arr[size-1]=null;
        updateKey(size-1,e);
    }

    //todo remove sec. cond
    //todo why else?
    private void updateKey(int i, T e){
        if(arr[i]==null || cpr.compare(arr[i],e)>0) {
            arr[i]=e;
            while (i>0 && cpr.compare(arr[parentIdx(i)],arr[i])>0) {
                T tmp = arr[i];
                arr[i] = arr[parentIdx(i)];
                i = parentIdx(i);
                arr[i] = tmp;
            }
        } else {
            arr[i]=e;
            heapify(i);
        }
    }

    @Override
    public T getMin(){
        if(size==0) throw new IndexOutOfBoundsException();
        return arr[0];
    }

    @Override
    public T removeMin() {
        if(size==0) throw new IndexOutOfBoundsException();
        T top = arr[0];
        arr[0]= arr[size-1];
        --size;
        heapify(0);
        return top;
    }

    @Override
    public void merge() {
        throw new UnsupportedOperationException();
    }
}
