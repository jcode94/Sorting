import java.util.*;

public class MergeSort
{
    public static void mergeSort(int [] arr, int lo, int hi)
    {
        if (lo >= hi) return;
        
        int mid = lo + (hi - lo) / 2;
        
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        
        int i = lo;
        int j = mid + 1;
        int k = 0;
        int [] sorted = new int[hi - lo + 1];    
        
        while (i <= mid || j <= hi)
        {
            if (i > mid)
                sorted[k++] = arr[j++];
            else if (j > hi)
                sorted[k++] = arr[i++];
            else if (arr[i] > arr[j])
                sorted[k++] = arr[j++];
            else
                sorted[k++] = arr[i++];
        }
        
        for (int z = lo; z <= hi; z++)
        {
            arr[z] = sorted[z - lo];
        }
    }
    
    public static int [] getRandomArray(int n)
    {
        int [] arr = new int[n];
        
        for (int i = 0; i < n; i++)
        {
            arr[i] = (int) (Math.random() * 100 + 1);
        }
        
        return arr;
    }
    
    public static void main(String [] args)
    {
        int n = (args.length > 0) ? Integer.parseInt(args[0]) : 10;
        
        int [] arr = getRandomArray(n);
        
        System.out.println("Unsorted:");
        System.out.println(Arrays.toString(arr));
        
        mergeSort(arr, 0, arr.length - 1);
        
        System.out.println("Sorted:");
        System.out.println(Arrays.toString(arr));
    }
}