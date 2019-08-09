package labrat.algs;

import labrat.ds.MaxHeap;

import java.util.Arrays;
import java.util.Random;

//intentionally unsafe
public class IntSorts {

    public static class MergeSort{
        static void Merge(int[] arr, int startIdx, int firstSeqLen, int secondSeqLen){
            int[] copy = Arrays.copyOfRange(arr,startIdx,startIdx+firstSeqLen+secondSeqLen);
            int i1=0,i2=0;
            while(i1<firstSeqLen && i2<secondSeqLen){
                if(copy[i1]<=copy[i2+firstSeqLen])
                    arr[startIdx+i1+i2]=copy[i1++];
                else
                    arr[startIdx+i1+i2]=copy[firstSeqLen+i2++];
            }
            for(;i1<firstSeqLen;i1++)
                arr[startIdx+i1+i2]=copy[i1];
            for (;i2<secondSeqLen;i2++)
                arr[startIdx+i1+i2]=copy[firstSeqLen+i2];
        }
        static void Sort(int[] arr, int startIdx, int len){
            if(len==1) return;
            int secSeqLen = len/2;
            Sort(arr,startIdx,len-secSeqLen);
            Sort(arr,startIdx+len-secSeqLen,secSeqLen);
            Merge(arr,startIdx,len-secSeqLen,secSeqLen);
        }
        public static void Sort(int[] arr){
            Sort(arr,0,arr.length);
        }
    }

    public static class HeapSort{
        public static void Sort(int[] arr){
            MaxHeap heap = new MaxHeap(arr);
            int last = heap.getSize()-1;
            for(int i = heap.getSize(); i>0; i--){
                int tmp = arr[0];
                arr[0] = arr[last];
                arr[last]=tmp;
                heap.setSize(last--);
                heap.Heapify(0);
            }
        }
    }

    public static class QuickSort{
        Random r = new Random();
        static Random random = new Random(); //concurrency will break a uniform distribution

        static int Partition(int[] arr,int startIdx, int endIdx){
            int i = random.nextInt(endIdx-startIdx+1)+startIdx;
            int tmp = arr[i];
            arr[i]=arr[endIdx];
            arr[endIdx]=tmp;
            i=startIdx-1;
            for(int j=startIdx;j<endIdx;j++)
                if(arr[j]<=arr[endIdx]){
                    tmp = arr[++i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            tmp=arr[i+1];
            arr[i+1]=arr[endIdx];
            arr[endIdx]=tmp;
            return i+1;
        }
        static void Sort(int[] arr, int startIdx, int endIdx){
            if(startIdx>=endIdx) return;
            int p = Partition(arr,startIdx,endIdx);
            Sort(arr,startIdx,p-1);
            Sort(arr,p+1,endIdx);
        }
        public static void Sort(int[] arr){
            Sort(arr,0,arr.length-1);
        }

    }

    public static class CountingSort{

        public static int[] Sort(int[] arr, int min, int max){
            int range = max-min;
            if (range<0) throw new IllegalArgumentException("range overflow: max-min > 2^31-1");
            int[] count = new int[range+1];
            int[] res = new int[arr.length];
            for(int i=0;i<arr.length;i++)
                count[arr[i]-min]=count[arr[i]-min]+1;
            count[0] = count[0]>0 ? count[0]-1 : 0;
            for(int i=1;i<count.length;i++)
                count[i]=count[i]+count[i-1];
            for(int i=0;i<arr.length;i++){
                res[count[arr[i]-min]]=arr[i];
                count[arr[i]-min]=count[arr[i]-min]-1;
            }
            return res;
        }
        public static int[] Sort(int arr[]){
            int min=arr[0];
            int max=arr[0];
            for(int i=1;i<arr.length;i++){
                if(arr[i]<min) min=arr[i];
                else if(arr[i]>max) max=arr[i];
            }
            return Sort(arr,min,max);
        }
    }
}
