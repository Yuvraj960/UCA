#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Simple function to swap bytes between two memory locations
void swap_bytes(void *a, void *b, int size) {
    char temp;
    char *ptr_a = (char*)a;
    char *ptr_b = (char*)b;
    
    for (int i = 0; i < size; i++) {
        temp = ptr_a[i];
        ptr_a[i] = ptr_b[i];
        ptr_b[i] = temp;
    }
}

// Simple merge function for generic data
void merge(void *arr, int left, int mid, int right, int elem_size, int (*compare)(void*, void*)) {
    int i, j, k;
    int n1 = mid - left + 1;
    int n2 = right - mid;
    
    // Create temporary arrays
    char *left_arr = (char*)malloc(n1 * elem_size);
    char *right_arr = (char*)malloc(n2 * elem_size);
    
    // Copy data to temp arrays
    for (i = 0; i < n1; i++) {
        for (int byte = 0; byte < elem_size; byte++) {
            left_arr[i * elem_size + byte] = ((char*)arr)[(left + i) * elem_size + byte];
        }
    }
    for (j = 0; j < n2; j++) {
        for (int byte = 0; byte < elem_size; byte++) {
            right_arr[j * elem_size + byte] = ((char*)arr)[(mid + 1 + j) * elem_size + byte];
        }
    }
    
    // Merge the temp arrays back
    i = 0;
    j = 0;
    k = left;
    
    while (i < n1 && j < n2) {
        void *left_elem = &left_arr[i * elem_size];
        void *right_elem = &right_arr[j * elem_size];
        
        if (compare(left_elem, right_elem) <= 0) {
            for (int byte = 0; byte < elem_size; byte++) {
                ((char*)arr)[k * elem_size + byte] = left_arr[i * elem_size + byte];
            }
            i++;
        } else {
            for (int byte = 0; byte < elem_size; byte++) {
                ((char*)arr)[k * elem_size + byte] = right_arr[j * elem_size + byte];
            }
            j++;
        }
        k++;
    }
    
    // Copy remaining elements
    while (i < n1) {
        for (int byte = 0; byte < elem_size; byte++) {
            ((char*)arr)[k * elem_size + byte] = left_arr[i * elem_size + byte];
        }
        i++;
        k++;
    }
    
    while (j < n2) {
        for (int byte = 0; byte < elem_size; byte++) {
            ((char*)arr)[k * elem_size + byte] = right_arr[j * elem_size + byte];
        }
        j++;
        k++;
    }
    
    free(left_arr);
    free(right_arr);
}

// Simple merge sort function
void merge_sort(void *arr, int left, int right, int elem_size, int (*compare)(void*, void*)) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        
        merge_sort(arr, left, mid, elem_size, compare);
        merge_sort(arr, mid + 1, right, elem_size, compare);
        merge(arr, left, mid, right, elem_size, compare);
    }
}

// Main sorting function - easy to use
void simple_sort(void *arr, int count, int elem_size, int (*compare)(void*, void*)) {
    merge_sort(arr, 0, count - 1, elem_size, compare);
}

// Compare functions for different types
int compare_int(void *a, void *b) {
    int x = *(int*)a;
    int y = *(int*)b;
    return x - y;
}

int compare_float(void *a, void *b) {
    float x = *(float*)a;
    float y = *(float*)b;
    if (x < y) return -1;
    if (x > y) return 1;
    return 0;
}

int compare_char(void *a, void *b) {
    char x = *(char*)a;
    char y = *(char*)b;
    return x - y;
}

// Print functions
void print_int_array(int *arr, int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void print_float_array(float *arr, int size) {
    for (int i = 0; i < size; i++) {
        printf("%.2f ", arr[i]);
    }
    printf("\n");
}

void print_char_array(char *arr, int size) {
    for (int i = 0; i < size; i++) {
        printf("%c ", arr[i]);
    }
    printf("\n");
}

int main() {
    printf("Simple Generic Merge Sort\n");
    printf("========================\n\n");
    
    // Test with integers
    printf("1. Sorting integers:\n");
    int numbers[] = {64, 34, 25, 12, 22, 11, 90};
    int num_count = 7;
    
    printf("Before: ");
    print_int_array(numbers, num_count);
    
    simple_sort(numbers, num_count, sizeof(int), compare_int);
    
    printf("After:  ");
    print_int_array(numbers, num_count);
    printf("\n");
    
    // Test with floats
    printf("2. Sorting floats:\n");
    float decimals[] = {3.14, 1.41, 2.71, 9.81, 6.28};
    int float_count = 5;
    
    printf("Before: ");
    print_float_array(decimals, float_count);
    
    simple_sort(decimals, float_count, sizeof(float), compare_float);
    
    printf("After:  ");
    print_float_array(decimals, float_count);
    printf("\n");
    
    // Test with characters
    printf("3. Sorting characters:\n");
    char letters[] = {'z', 'a', 'm', 'c', 'x', 'b'};
    int char_count = 6;
    
    printf("Before: ");
    print_char_array(letters, char_count);
    
    simple_sort(letters, char_count, sizeof(char), compare_char);
    
    printf("After:  ");
    print_char_array(letters, char_count);
    
    return 0;
}