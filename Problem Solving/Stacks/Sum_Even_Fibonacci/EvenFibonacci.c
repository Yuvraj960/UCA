#include <stdio.h>

long long sumEvenFibonacci(long long limit) {
	long long a = 0, b = 2, sum = 0;
	while (b <= limit) {
		sum += b;
		long long next = 4 * b + a;
		a = b;
		b = next;
	}
	return sum;
}

int main() {
	long long limit = 4000000; // Example limit
	printf("Sum of even Fibonacci numbers up to %lld (DP): %lld\n", limit, sumEvenFibonacci(limit));
	return 0;
}

