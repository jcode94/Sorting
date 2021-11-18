// Justice Smith
// October 29, 2021
// MergeSort.c

#include <stdio.h>
#include <stdlib.h>
#include <time.h>


void mergeSort(int* arr, int lo, int hi)
{
	if (lo >= hi)
		return;

	int mid = lo + (hi - lo) / 2;

	mergeSort(arr, lo, mid);
	mergeSort(arr, mid + 1, hi);

	int i = lo;
	int j = mid + 1;
	int k = 0;

	int* sortedArr = calloc((hi - lo + 1), sizeof(int));

	while (i <= mid || j <= hi)
	{
		if (i > mid)
		{
			sortedArr[k++] = arr[j++];
		}
		else if (j > hi)
		{
			sortedArr[k++] = arr[i++];
		}
		else if (arr[i] > arr[j])
		{
			sortedArr[k++] = arr[j++];
		}
		else
		{
			sortedArr[k++] = arr[i++];
		}
	}
	for (int z = lo; z <= hi; z++)
	{
		arr[z] = sortedArr[z - lo];
	}

	free(sortedArr);
}

void printArr(int* arr, int size)
{
	for (int i = 0; i < size; i++)
		printf("%d ", arr[i]);

	printf("\n");
}

int main()
{
	int sizeArr = 10;

	int* arr = calloc(sizeArr, sizeof(int));

	srand(time(0));

	for (int i = 0; i < sizeArr; i++)
	{
		arr[i] = (rand() % 100) + 1;
	}

	printf("Unsorted:\n");
	printArr(arr, sizeArr);

	mergeSort(arr, 0, sizeArr - 1);

	printf("Sorted:\n");
	printArr(arr, sizeArr);

	free(arr);
}
