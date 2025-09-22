#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// The Base64 character set.
static const char base64_chars[] =
    "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    "abcdefghijklmnopqrstuvwxyz"
    "0123456789+/";

// --- ADDED: Decoding table and build function ---
static char decoding_table[256];
static void build_decoding_table() {
    // Fills the decoding table with values.
    // Invalid characters will be 0, which works because the input to the decoder
    // is validated to not contain null characters.
    memset(decoding_table, 0, 256);
    for (int i = 0; i < 64; i++) {
        decoding_table[(unsigned char)base64_chars[i]] = i;
    }
}

/**
 * @brief Decodes a Base64 encoded string.
 *
 * @param data The null-terminated Base64 string to decode.
 * @param input_length The length of the input string.
 * @param output_length A pointer to a size_t variable where the length
 * of the output data will be stored.
 * @return A dynamically allocated buffer containing the decoded data.
 * The caller is responsible for freeing this memory.
 * Returns NULL if memory allocation fails or input is invalid.
 */
unsigned char* base64_decode(const char *data, size_t input_length, size_t *output_length) {
    // The input length must be a multiple of 4.
    if (input_length % 4 != 0) return NULL;

    // Calculate the output length.
    *output_length = input_length / 4 * 3;
    if (data[input_length - 1] == '=') (*output_length)--;
    if (data[input_length - 2] == '=') (*output_length)--;

    // Allocate memory for the decoded data.
    unsigned char *decoded_data = malloc(*output_length);
    if (decoded_data == NULL) {
        fprintf(stderr, "Error: Memory allocation failed.\n");
        return NULL;
    }

    size_t i, j;
    // Process the input string in chunks of 4 characters.
    for (i = 0, j = 0; i < input_length; ) {
        // --- Get the 6-bit values for the 4 characters from the lookup table ---
        unsigned int val1 = decoding_table[(unsigned char)data[i++]];
        unsigned int val2 = decoding_table[(unsigned char)data[i++]];
        unsigned int val3 = decoding_table[(unsigned char)data[i++]];
        unsigned int val4 = decoding_table[(unsigned char)data[i++]];

        // --- Reassemble the 6-bit values into 3 bytes (8-bits) ---

        // Byte 1: First 6 bits of val1 and first 2 bits of val2.
        unsigned char byte1 = (val1 << 2) | (val2 >> 4);
        // Byte 2: Last 4 bits of val2 and first 4 bits of val3.
        unsigned char byte2 = ((val2 & 0x0F) << 4) | (val3 >> 2);
        // Byte 3: Last 2 bits of val3 and all 6 bits of val4.
        unsigned char byte3 = ((val3 & 0x03) << 6) | val4;

        // --- Store the bytes in the output buffer ---
        // We check if we have space, which handles the padding cases.
        if (j < *output_length) decoded_data[j++] = byte1;
        if (j < *output_length) decoded_data[j++] = byte2;
        if (j < *output_length) decoded_data[j++] = byte3;
    }

    return decoded_data;
}

// Main function to demonstrate the encoder and decoder.
int main() {
    // --- Build the decoding table once ---
    build_decoding_table();

    printf("--- ENCODING TESTS ---\n\n");
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

    // --- DECODING TESTS ---
    printf("--- DECODING TESTS ---\n\n");
    
    // --- Test Case 5: Decode "TWFu" ---
    const char *test_b64_str1 = "TWFu";
    size_t decoded_len1;
    unsigned char *decoded1 = base64_decode(test_b64_str1, strlen(test_b64_str1), &decoded_len1);
    printf("Encoded:    \"%s\"\n", test_b64_str1);
    printf("Decoded:    \"%.*s\"\n", (int)decoded_len1, decoded1);
    printf("Expected:   \"Man\"\n\n");
    free(decoded1);

    // --- Test Case 6: Decode "TWE=" ---
    const char *test_b64_str2 = "TWE=";
    size_t decoded_len2;
    unsigned char *decoded2 = base64_decode(test_b64_str2, strlen(test_b64_str2), &decoded_len2);
    printf("Encoded:    \"%s\"\n", test_b64_str2);
    printf("Decoded:    \"%.*s\"\n", (int)decoded_len2, decoded2);
    printf("Expected:   \"Ma\"\n\n");
    free(decoded2);

    // --- Test Case 7: Decode "TQ==" ---
    const char *test_b64_str3 = "TQ==";
    size_t decoded_len3;
    unsigned char *decoded3 = base64_decode(test_b64_str3, strlen(test_b64_str3), &decoded_len3);
    printf("Encoded:    \"%s\"\n", test_b64_str3);
    printf("Decoded:    \"%.*s\"\n", (int)decoded_len3, decoded3);
    printf("Expected:   \"M\"\n\n");
    free(decoded3);

    // --- Test Case 8: Decode "SGVsbG8sIFdvcmxkIQ==" ---
    const char *test_b64_str4 = "SGVsbG8sIFdvcmxkIQ==";
    size_t decoded_len4;
    unsigned char *decoded4 = base64_decode(test_b64_str4, strlen(test_b64_str4), &decoded_len4);
    printf("Encoded:    \"%s\"\n", test_b64_str4);
    printf("Decoded:    \"%.*s\"\n", (int)decoded_len4, decoded4);
    printf("Expected:   \"Hello, World!\"\n\n");
    free(decoded4);

    return 0;
}

