package Lab08.pack;

public class MyQuickSort_670764 {
    public void qSort(int[] arr) {
        qSort_lomuto(arr, 0, arr.length-1);
    }
    private void qSort_lomuto(int[] arr, int low, int high) {
        if (low < high) {
            int pivot_index = partition_lomuto(arr, low, high);
            qSort_lomuto(arr, low, pivot_index - 1);
            qSort_lomuto(arr, pivot_index + 1, high);
        }
    }
    private int partition_lomuto(int[] arr, int low, int high) { 
        int pivot_v = arr[high];
        int i = low, tmp;
        
        for (int j = low; j < high; j++)
        {
            if (arr[j] <= pivot_v)
            {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        tmp = arr[i];
        arr[i] = arr[high];
        arr[high] = tmp;

        return i;
    }
}