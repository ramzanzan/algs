package ramzanzan.algorithms;

import ramzanzan.structures.heaps.BinaryHeap;

import java.util.Arrays;
import java.util.Random;

public interface Sort{

    void sort(int[] arr);

    class InsertionSort implements Sort{
        @Override
        public void sort(int[] arr) {
            for(int i=1;i<arr.length;++i){
                int k = arr[i];
                int j = i-1;
                while (j>=0 && k<arr[j]) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j+1]=k;
            }
        }
    }

    class MergeSort implements Sort{

        @Override
        public void sort(int[] arr) {
            sort(arr,0,arr.length);
        }

        private void sort(int[] arr, int startIdx, int len){
            if(len==1) return;
            int secSeqLen = len/2;
            sort(arr,startIdx,len-secSeqLen);
            sort(arr,startIdx+len-secSeqLen,secSeqLen);
            merge(arr,startIdx,len-secSeqLen,secSeqLen);
        }

        private void merge(int[] arr, int startIdx, int firstSeqLen, int secondSeqLen){
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
    }

    class HeapSort implements Sort{
        @Override
        public void sort(int[] arr){
            var iarr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            var bh = new BinaryHeap<>(iarr, Integer::compareTo);
            for(int i=0;i<arr.length;i++)
                arr[i]=bh.removeMin();
        }
    }

    class QuickSort implements Sort{
        static Random random = new Random(); //concurrency will break an uniform distribution
        
        @Override
        public void sort(int[] arr){
            sort(arr,0,arr.length-1);
        }

        void sort(int[] arr, int startIdx, int endIdx){
            if(startIdx>=endIdx) return;
            int p = partition(arr,startIdx,endIdx);
            sort(arr,startIdx,p-1);
            sort(arr,p+1,endIdx);
        }
        
        int partition(int[] arr, int startIdx, int endIdx){
            int i = random.nextInt(endIdx-startIdx+1)+startIdx;
            int tmp = arr[i];
            arr[i]=arr[endIdx];
            arr[endIdx]=tmp;
            i=startIdx-1;
            for(int j=startIdx;j<endIdx;j++)
                if(arr[j]<=arr[endIdx]){
                    i++;
                    arr[i] ^= arr[j];
                    arr[j] ^= arr[i];
                    arr[i] ^= arr[j];
                }
            tmp=arr[i+1];
            arr[i+1]=arr[endIdx];
            arr[endIdx]=tmp;
            return i+1;
        }

    }

    class CountingSort{
        //todo
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
