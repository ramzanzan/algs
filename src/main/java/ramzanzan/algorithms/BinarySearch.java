package ramzanzan.algorithms;

public interface BinarySearch {

    int search(int[] arr, int val);

    class Cyclic implements BinarySearch{
        @Override
        public int search(int[] arr, int val) {
            int from=0, len=arr.length;
            while (len>0){
                int mid=from+len/2;
                if(arr[mid]==val) return mid;
                else if(arr[mid]>val)
                    len=len/2;
                else{
                    from=mid+1;
                    len=(len-1)/2;
                }

            }
            return -1;
        }
    }

    class Recursive implements BinarySearch{
        @Override
        public int search(int[] arr, int val) {
            return search(arr,0,arr.length,val);
        }

        private int search(int[] arr, int from, int len, int val){
            if(len==0) return -1;
            int mid = from+len/2;
            if(arr[mid]==val) return mid;
            else if (arr[mid]>val)
                return search(arr,from,len/2,val);
            else
                return search(arr,mid+1,(len-1)/2,val);

        }
    }
}
