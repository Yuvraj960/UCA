#include <stdio.h>

void solve(int n, char source, char auxiliary, char destination) {
	if (n == 1) {
		printf("Move disk 1 from %c to %c\n", source, destination);
		return;
	}
	solve(n - 1, source, destination, auxiliary);
	printf("Move disk %d from %c to %c\n", n, source, destination);
	solve(n - 1, auxiliary, source, destination);
}

int main() {
	int n = 3; // Number of disks (change as needed)
	solve(n, 'A', 'B', 'C');
	return 0;
}
