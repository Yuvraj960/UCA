#include <stdio.h>

// Utility function to swap two elements
void swap(int *a, int *b) {
	int t = *a;
	*a = *b;
	*b = t;
}

// Partition function using Lomuto partition scheme
int partition(int arr[], int low, int high) {
	int pivot = arr[high];
	int i = low - 1;
	for (int j = low; j < high; j++) {
		if (arr[j] <= pivot) {
			i++;
			swap(&arr[i], &arr[j]);
		}
	}
	swap(&arr[i + 1], &arr[high]);
	return i + 1;
}

// Optimized Quick Sort with tail call elimination
void quickSort(int arr[], int low, int high) {
	while (low < high) {
		// Partition the array
		int pi = partition(arr, low, high);

		// Recur for the smaller part first to optimize stack usage
		if (pi - low < high - pi) {
			quickSort(arr, low, pi - 1);
			low = pi + 1;
		} else {
			quickSort(arr, pi + 1, high);
			high = pi - 1;
		}
	}
}

// Function to print an array
void printArray(int arr[], int size) {
	for (int i = 0; i < size; i++)
		printf("%d ", arr[i]);
	printf("\n");
}

// Example usage
int main() {
	int arr[] = {10, 7, 8, 9, 1, 5};
	int n = sizeof(arr) / sizeof(arr[0]);
	printf("Original array: ");
	printArray(arr, n);
	quickSort(arr, 0, n - 1);
	printf("Sorted array: ");
	printArray(arr, n);
	return 0;
}
