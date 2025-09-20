#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// The Base64 character set.
static const char base64_chars[] =
    "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    "abcdefghijklmnopqrstuvwxyz"
    "0123456789+/";

/**
 * @brief Encodes a block of data into Base64.
 *
 * @param data The input data to encode (unsigned bytes).
 * @param input_length The number of bytes in the input data.
 * @param output_length A pointer to a size_t variable where the length
 * of the output string will be stored.
 * @return A dynamically allocated, null-terminated string containing the
 * Base64 encoded data. The caller is responsible for freeing this memory.
 * Returns NULL if memory allocation fails.
 */
char* base64_encode(const unsigned char *data, size_t input_length, size_t *output_length) {
    // Calculate the length of the output string. It's always a multiple of 4.
    *output_length = 4 * ((input_length + 2) / 3);

    // Allocate memory for the output string plus a null terminator.
    char *encoded_data = malloc(*output_length + 1);
    if (encoded_data == NULL) {
        fprintf(stderr, "Error: Memory allocation failed.\n");
        return NULL;
    }

    size_t i, j;
    // Process the input data in chunks of 3 bytes.
    for (i = 0, j = 0; i < input_length; ) {
        // --- Get the 3 bytes for the current chunk ---
        // If there are fewer than 3 bytes left, use 0 for the missing bytes.
        unsigned char byte1 = data[i++];
        unsigned char byte2 = (i < input_length) ? data[i++] : 0;
        unsigned char byte3 = (i < input_length) ? data[i++] : 0;

        // --- Convert the 3 bytes (24 bits) into 4 Base64 indices (4 * 6 bits) ---

        // Index 1: The first 6 bits of byte1.
        // [b1b1b1b1 b1b1]b1b1
        unsigned int index1 = byte1 >> 2;

        // Index 2: The last 2 bits of byte1 and the first 4 bits of byte2.
        // b1b1[b1b1b1b1]b1b1
        unsigned int index2 = ((byte1 & 0x03) << 4) | (byte2 >> 4);

        // Index 3: The last 4 bits of byte2 and the first 2 bits of byte3.
        // b1b1b1b1[b1b1b1b1]
        unsigned int index3 = ((byte2 & 0x0F) << 2) | (byte3 >> 6);

        // Index 4: The last 6 bits of byte3.
        // b1b1b1b1 b1b1[b1b1b1b1]
        unsigned int index4 = byte3 & 0x3F;

        // --- Map indices to Base64 characters and store them in the output ---
        encoded_data[j++] = base64_chars[index1];
        encoded_data[j++] = base64_chars[index2];
        encoded_data[j++] = base64_chars[index3];
        encoded_data[j++] = base64_chars[index4];
    }

    // --- Handle Padding ---
    // If the input length was not a multiple of 3, we need to add padding ('=').
    int mod = input_length % 3;
    if (mod > 0) {
        // If there was only 1 input byte, the last two output characters are padding.
        if (mod == 1) {
            encoded_data[*output_length - 1] = '=';
            encoded_data[*output_length - 2] = '=';
        }
        // If there were 2 input bytes, the last output character is padding.
        else if (mod == 2) {
            encoded_data[*output_length - 1] = '=';
        }
    }

    // Add the null terminator to the end of the string.
    encoded_data[*output_length] = '\0';

    return encoded_data;
}

// Main function to demonstrate the encoder.
int main() {
    // --- Test Case 1: "Man" (no padding needed) ---
    const char *test_str1 = "Man";
    size_t out_len1;
    char *encoded1 = base64_encode((const unsigned char*)test_str1, strlen(test_str1), &out_len1);
    printf("Original:  \"%s\"\n", test_str1);
    printf("Encoded:   \"%s\"\n", encoded1);
    printf("Expected:  \"TWFu\"\n\n");
    free(encoded1);

    // --- Test Case 2: "Ma" (one padding char needed) ---
    const char *test_str2 = "Ma";
    size_t out_len2;
    char *encoded2 = base64_encode((const unsigned char*)test_str2, strlen(test_str2), &out_len2);
    printf("Original:  \"%s\"\n", test_str2);
    printf("Encoded:   \"%s\"\n", encoded2);
    printf("Expected:  \"TWE=\"\n\n");
    free(encoded2);

    // --- Test Case 3: "M" (two padding chars needed) ---
    const char *test_str3 = "M";
    size_t out_len3;
    char *encoded3 = base64_encode((const unsigned char*)test_str3, strlen(test_str3), &out_len3);
    printf("Original:  \"%s\"\n", test_str3);
    printf("Encoded:   \"%s\"\n", encoded3);
    printf("Expected:  \"TQ==\"\n\n");
    free(encoded3);

    // --- Test Case 4: "Hello, World!" ---
    const char *test_str4 = "Hello, World!";
    size_t out_len4;
    char *encoded4 = base64_encode((const unsigned char*)test_str4, strlen(test_str4), &out_len4);
    printf("Original:  \"%s\"\n", test_str4);
    printf("Encoded:   \"%s\"\n", encoded4);
    printf("Expected:  \"SGVsbG8sIFdvcmxkIQ==\"\n\n");
    free(encoded4);

    return 0;
}
