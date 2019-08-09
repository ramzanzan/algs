package labrat.ds;

import java.util.Arrays;

public class MaxHeap implements Heap {
    int size;
    public int[] BackArr;

    public MaxHeap(int[] arr){
        this.BackArr =arr;
        size =arr.length;
        for(int i = size /2-1; i>=0; i--)
            Heapify(i);
    }

    @Override
    public int ParentIdx(int i) {
        return (i-2+i%2)/2;
    }

    @Override
    public int LeftIdx(int i) {
        return i*2+1;
    }

    @Override
    public int RightIdx(int i) {
        return i*2+2;
    }

    @Override
    public void Heapify(int i) {
        int l=LeftIdx(i);
        int r=RightIdx(i);
        int max = i;
        if(l< size && BackArr[l]> BackArr[i])
            max=l;
        if(r< size && BackArr[r]> BackArr[max])
            max=r;
        if(i!=max){
            int tmp = BackArr[i];
            BackArr[i]= BackArr[max];
            BackArr[max]=tmp;
            Heapify(max);
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void resetLen() {
        size = BackArr.length;
    }

    @Override
    public int Pop(){
        if(size==0) throw new IndexOutOfBoundsException();
        int top = BackArr[0];
        BackArr[0]=BackArr[size-1];
        --size;
        Heapify(0);
        return top;
    }

    public void UpdateKey(int i, int key){
        if(BackArr[i]<key) {
            BackArr[i]=key;
            while (i>0 && BackArr[ParentIdx(i)] < BackArr[i]) {
                int tmp = BackArr[i];
                BackArr[i] = BackArr[ParentIdx(i)];
                BackArr[ParentIdx(i)] = tmp;
                i = ParentIdx(i);
            }
        } else {
            BackArr[i]=key;
            Heapify(i);
        }
    }

    public void Put(int key){
        if(size==BackArr.length){
            int[] n = Arrays.copyOf(BackArr,size*2);
            BackArr=n;
        }
        ++size;
        BackArr[size-1]=Integer.MIN_VALUE;
        UpdateKey(size-1,key);
    }

    public void RemoveKey(int i){
        if(i>=size) throw new IndexOutOfBoundsException();
        BackArr[i]=BackArr[size-1];
        --size;
        Heapify(i);
    }
}
