package Lab08.pack;

public class MyMergeSort_670764 {
    public void mSort(int[] arr) {
        mSort(arr,0,arr.length-1);
    }
    private void mSort(int[] arr, int low, int high) {
        if (low >= high)    return;
        int mid = low + ((high - low) >> 1);
        mSort(arr,low,mid);
        mSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    private void merge(int[] arr, int low, int mid, int high) { 
        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high)
        {
            if (arr[i] <= arr[j])
                tmp[k++] = arr[i++];
            else
                tmp[k++] = arr[j++];
        }
        while (i <= mid)
            tmp[k++] = arr[i++];

        while (j <= high)
            tmp[k++] = arr[j++];

        System.arraycopy(tmp, 0, arr, low, tmp.length);
    }

    // public static void main(String[] args) {

    //     int [] arr = {42, 17, -5, 88, 23, 91, -12, 65, 7, 30, 55, -9, 2, 48, 76, 1, -22, 99, 14, 61, 37, 83, -18, 50, 29, 72, 6, 40, 11, 68};
    //     MyMergeSort_670764 sol = new MyMergeSort_670764();
    //     sol.mSort(arr);
    //     System.out.println(Arrays.toString(arr));
    //     System.out.println("Length: " + arr.length);
    // }
    
}
