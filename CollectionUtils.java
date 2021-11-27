// Justice Smith
// Nov. 17, 2021
// General Utilities to generate, destroy, and manipulate collections

import java.util.*;

class CollectionUtils
{

    public static Integer findMax(List<Integer> list)
    {
        if (list == null) return null;

        Integer max = list.get(0);
        for (Integer val : list)
            if (val > max)
                max = val;

        return max;
    }

    public static Integer findMin(List<Integer> list)
    {
        if (list == null) return null;

        Integer min = list.get(0);
        for (Integer val : list)
            if (val < min)
                min = val;

        return min;
    }

	// Returns list of random integers on the range [1, 100]
	public static List<Integer> getRandomList(int n)
	{
		return getRandomList(n, 1, 100);
	}

	public static List<Integer> getRandomList(int n, int min, int max)
	{
		List<Integer> list = new ArrayList<Integer>(n);

		for (int i = 0; i < n; i++)
			list.add((int) (Math.random() * max + min));

		return list;
	}

	public static void swap(List<Integer> list, int x, int y)
	{
		Integer temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	}

    public static void swap(int [] srcArr, int index1, int index2)
    {
        int temp = srcArr[index1];
        srcArr[index1] = srcArr[index2];
        srcArr[index2] = temp;
    }

    public static double median3(int a, int b, int c)
    {
        return Math.max(
                    Math.min(a, b), 
                    Math.min(Math.max(a, b), c)
               );
    }

    // Takes first four elements, finds the upper bound of the
    // lower half and the lower bound of the upper half and then
    // finds median of 3 of those and remaining last element.
    public static double median5(int [] a)
    {
        int val1 = Math.max(Math.min(a[0], a[1]), Math.min(a[2], a[3]));
        int val2 = Math.min(Math.max(a[0], a[1]), Math.max(a[2], a[3]));

        return median3(val1, val2, a[4]);
    }

    public static void main(String [] args)
    {
        int [] test = new int[] { 3, 9, 0, 5, 7 };

        System.out.println("Array: " + Arrays.toString(test));
        System.out.println("Median of 5: " + median5(test));
    }
}

