// Justice Smith
// Nov. 17, 2021
// Comparison-Based Sorts

import java.util.*;

public class SortSuite
{
	
	private static List<Integer> getRandomList(int n)
	{
		List<Integer> list = new ArrayList<Integer>(n);

		for (int i = 0; i < n; i++)
			list.add((int) (Math.random() * 100 + 1));

		return list;
	}

	public static void quickSort(List<Integer> list)
	{
		quickSort(list, 0, list.size() - 1);					
	}

	private static void quickSort(List<Integer> list, int lo, int hi)
	{
		if (lo >= hi) return;

		int mid = lo + (hi - lo) / 2;
		int pivot = list.get(mid);

		int i = lo;
		int j = hi;

		while (i <= j)
		{
			while (list.get(i) < pivot)
			{
				i++;
			}
			while (list.get(j) > pivot)
			{
				j--;
			}
			if (i <= j)
			{
				swap(list, i, j);
				i++;
				j--;
			}
		}

		if (j > lo)
		{
			quickSort(list, lo, j);
		}
		if (i < hi)
		{
			quickSort(list, i, hi);
		}
	}

	private static void swap(List<Integer> list, int x, int y)
	{
		Integer temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	}


	// MergeSort Wrapper
	//
	// To avoid inaccuracies with lo/hi initilizations.
	// By simply asking for a container, we can take away
	// from the user the responsibility of accurately
	// recording its size.
	//
	// Note: This function mutates the existing
	// 		 container to a sorted state. This may not be
	// 		 the correct function if you wish to retain the
	// 		 state of the original list. 
	// 		 See { @link #mergeSortCopy(List<Integer>) }.
	public static void mergeSort(List<Integer> list)
	{
		mergeSort(list, 0, list.size() - 1);
	}


	// MergeSort
	//
	// Space complexity: O(n)
	// Time complexity: O(nlogn)
	//
	// Classical implementation of mergeSort in single, recursive method.
	//
	// Note: This function mutates the existing
	// 		 container to a sorted state. This may not be
	// 		 the correct function if you wish to retain the
	// 		 state of the original list. 
	// 		 See { @link #mergeSortCopy(List<Integer>) }.
	private static void mergeSort(List<Integer> list, int lo, int hi)	
	{
		if (lo >= hi) return;

		int mid = lo + (hi - lo) / 2;

		mergeSort(list, lo, mid);
		mergeSort(list, mid + 1, hi);

		int i = lo;
		int j = mid + 1;
		int k = 0;

		Integer [] sorted = new Integer[hi - lo + 1];

		while (i <= mid || j <= hi)
		{
			if (i > mid)
				{ sorted[k++] = list.get(j++); }
			else if (j > hi) 
				{ sorted[k++] = list.get(i++); }
			else if (list.get(i) < list.get(j)) 
				{ sorted[k++] = list.get(i++); }
			else
				{ sorted[k++] = list.get(j++); }
		}

		for (int z = lo; z <= hi; z++)
			list.set(z, sorted[z - lo]);
	}

    public static void main(String [] args)
    {
        int n = (args.length > 0) ? Integer.parseInt(args[0]) : 10;
        
        List<Integer> arr = getRandomList(n);
        
        System.out.println("Unsorted:");
        System.out.println(arr.toString());
        
		mergeSort(arr);
        
        System.out.println("MergeSorted:");
        System.out.println(arr.toString());

		Collections.shuffle(arr);

        System.out.println("Unsorted:");
        System.out.println(arr.toString());
        
        quickSort(arr);
        
        System.out.println("QuickSorted:");
        System.out.println(arr.toString());

    }
}
