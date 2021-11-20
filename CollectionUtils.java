// Justice Smith
// Nov. 17, 2021
// General Utilities to generate, destroy, and manipulate collections

import java.util.*;

class CollectionUtils
{

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
}

