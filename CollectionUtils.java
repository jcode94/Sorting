// Justice Smith
// Nov. 17, 2021
// General Utilities to generate, destroy, and manipulate collections

import java.util.*;

class CollectionUtils
{
	public static List<Integer> getRandomList(int n)
	{
		List<Integer> list = new ArrayList<Integer>(n);

		for (int i = 0; i < n; i++)
			list.add((int) (Math.random() * 100 + 1));

		return list;
	}

	public static void swap(List<Integer> list, int x, int y)
	{
		Integer temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	}
}

