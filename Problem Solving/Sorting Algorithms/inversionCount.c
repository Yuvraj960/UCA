#include <stdio.h>
#include <stdlib.h>

int merge(int l, int mid, int r, int arr[], int aux[])
{
	int i = l, j = mid + 1, inv = 0;
	int k;
	for (k = l; k <= r; k++)
	{
		if (i > mid)
		{
			aux[k] = arr[j];
			j++;
		}
		else if (j > r)
		{
			aux[k] = arr[i];
			i++;
		}
		else if (arr[i] > arr[j])
		{
			aux[k] = arr[j];
			j++;
			inv += (mid - i + 1);
		}
		else
		{
			aux[k] = arr[i];
			i++;
		}
	}
	for (k = l; k <= r; k++)
	{
		arr[k] = aux[k];
	}
	return inv;
}

int countInversions(int arr[], int aux[], int l, int r)
{
	if (l >= r)
		return 0;
	int mid = l + (r - l) / 2;
	int inv = 0;
	inv += countInversions(arr, aux, l, mid);
	inv += countInversions(arr, aux, mid + 1, r);
	inv += merge(l, mid, r, arr, aux);
	return inv;
}

int main()
{
	int a[] = {3, 2, 5, 7, 100, 99, -9, 5, 7, 8, 2, 8, 18, 11};
	int n = sizeof(a) / sizeof(a[0]);
	int *aux = (int *)malloc(n * sizeof(int));
	if (!aux)
	{
		printf("Memory allocation failed\n");
		return 1;
	}
	int inv = countInversions(a, aux, 0, n - 1);
	printf("%d\n", inv);
	free(aux);
	return 0;
}
