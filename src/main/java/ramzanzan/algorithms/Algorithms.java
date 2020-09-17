package ramzanzan.algorithms;

public class Algorithms {
    public static int binarySearch(final int[] arr, int x){
        int rangeStart = 0;
        int rangeLen = arr.length;
        while (rangeLen!=0){
           int mid = rangeStart+rangeLen/2;
           if(arr[mid]==x) return mid;
           if(arr[mid]<x){
               rangeStart=mid+1;
               rangeLen-=rangeLen/2+1;
           }else {
               rangeLen=rangeLen/2;
           }
        }
        return -1;
    }

    public static int binarySearchRecursive(final int[] arr, int x){
        if (arr.length==0) return -1;
        return _binarySearchRecursive(arr,0,arr.length-1,x);
    }

    private static int _binarySearchRecursive(final int[] arr, int from, int to, int x){
        if(from==to) return arr[from]==x ? from : -1;
        int mid = (to-from+1)/2+from;
        if(arr[mid]==x) return mid;
        if(arr[mid]<x)
            return mid==to ? -1 : _binarySearchRecursive(arr,mid+1,to,x);
        else
            return mid==from ? -1 : _binarySearchRecursive(arr,from,mid-1,x);
    }
}
