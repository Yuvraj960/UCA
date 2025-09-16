#include <stdio.h>

/*
 * sign(x) returns:
 *   1  if x > 0
 *   0  if x == 0
 *  -1  if x < 0
 *
 * Step-by-step explanation:
 * 1. (!!x) converts x to 1 if non-zero, 0 if zero.
 * 2. (x >> 31) shifts x right by 31 bits:
 *      - For positive x: result is 0.
 *      - For zero: result is 0.
 *      - For negative x: result is -1 (all bits set).
 * 3. Bitwise OR combines the results:
 *      - Positive: 1 | 0 = 1
 *      - Zero:     0 | 0 = 0
 *      - Negative: 1 | -1 = -1
 */
int sign(int x) {
    // Returns 1 if x > 0, 0 if x == 0, -1 if x < 0
    return (!!x) | (x >> 31);
}

/*
 * conditional(x, y, z) returns y if x is non-zero, else returns z.
 * Equivalent to: x ? y : z
 *
 * Step-by-step explanation:
 * 1. !!x converts x to 1 if non-zero, 0 if zero.
 * 2. ~0 is all 1s (0xFFFFFFFF). Negate (!!x) and add 1 to get mask:
 *      - If x != 0: mask = ~0 + 1 = 0xFFFFFFFF (all 1s)
 *      - If x == 0: mask = ~0 + 0 = 0x00000000 (all 0s)
 * 3. Use mask to select y or z:
 *      - (mask & y) selects y if mask is all 1s, else 0.
 *      - (~mask & z) selects z if mask is all 0s, else 0.
 *      - OR the results to get either y or z.
 */
int conditional(int x, int y, int z) {
    int mask = ~(!x) + 1;
    return (mask & y) | (~mask & z);
}

/*
 * bang(x) computes !x (returns 1 if x == 0, else 0) without using !.
 *
 * Step-by-step explanation:
 * 1. For any non-zero x, either x or -x will have the sign bit set.
 * 2. (x | -x) will have the sign bit set for any non-zero x.
 * 3. Shift right by 31 to get 0xFFFFFFFF for non-zero, 0x0 for zero.
 * 4. Add 1 to invert: 0xFFFFFFFF + 1 = 0 (for non-zero), 0x0 + 1 = 1 (for zero).
 */
int bang(int x) {
    return ((x | (~x + 1)) >> 31) + 1;
}

/*
 * invert(x, p, n) returns x with n bits inverted starting at position p.
 *
 * Step-by-step explanation:
 * 1. Create a mask with n 1s: (1 << n) - 1
 * 2. Shift mask to position p: ((1 << n) - 1) << p
 * 3. XOR x with mask to flip the targeted bits.
 */
int invert(int x, int p, int n) {
    int mask = ((1 << n) - 1) << p;
    return x ^ mask;
}

int main() {
    // Test sign function
    printf("sign(130) = %d\n", sign(130));    // Expected: 1
    printf("sign(-23) = %d\n", sign(-23));    // Expected: -1
    printf("sign(0) = %d\n", sign(0));        // Expected: 0

    // Test conditional function
    printf("conditional(2, 4, 5) = %d\n", conditional(2, 4, 5)); // Expected: 4
    printf("conditional(0, 4, 5) = %d\n", conditional(0, 4, 5)); // Expected: 5

    // Test bang function
    printf("bang(3) = %d\n", bang(3));        // Expected: 0
    printf("bang(0) = %d\n", bang(0));        // Expected: 1

    // Test invert function
    // Example: invert(0b101011, 1, 3) flips bits 1,2,3 (positions start from 0)
    int x = 0b101011;
    int result = invert(x, 1, 3); // Should flip bits 1,2,3
    printf("invert(0b101011, 1, 3) = 0b%06b (%d)\n", result, result);

    // Additional invert test
    printf("invert(0xF0F0, 4, 4) = 0x%X\n", invert(0xF0F0, 4, 4)); // Flip bits 4-7

    return 0;
}

