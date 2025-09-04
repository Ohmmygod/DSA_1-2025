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
        /* your code */

    }
}