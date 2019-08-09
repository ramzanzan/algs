package labrat.ds;

public interface Heap {
    int ParentIdx(int i);
    int LeftIdx(int i);
    int RightIdx(int i);
    void Heapify(int i);
    int getSize();
    void setSize(int size);
    void resetLen();
    int Pop();
    void UpdateKey(int i,int key);
    void Put(int key);
}
