import random

def mergeSort(arr, lo, hi):
	if lo >= hi:
		return
		
	mid = lo + int((hi - lo) / 2)

	mergeSort(arr, 0, mid)
	mergeSort(arr, mid + 1, hi)

	i = lo
	j = mid + 1
	sorted = []

	while i <= mid and j <= hi:
		if i > mid:
			sorted.append(arr[j])
			j+=1
		elif j > mid:
			sorted.append(arr[i])
			i+=1
		elif arr[i] > arr[j]:
			sorted.append(arr[j])
			j+=1
		else:
			sorted.append(arr[i])
			i+=1

	for i in range(lo, hi):
		arr[i] = sorted[i - lo]

def getRandomArr():
	return [random.randint(1, 100) for i in range(10)]

def main():
	print("starting") # test comment, still not printing anything
	arr = getRandomArr()

	print("Unsorted:\n")
	print(arr)
	print('\n')

	mergeSort(arr, 0, len(arr) - 1)

	print("Sorted:\n")
	print(arr)
	print('\n')
	
main()