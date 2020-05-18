package ramzanzan.structures.heaps;

public interface MinHeap<T>{
    int getSize();
    T getMin();
    T removeMin();
    void add(T e);
    void merge();
}
