#include <stdio.h>

int main() {
    int n;
    printf("%zu\n", sizeof 1);
    printf("%zu\n", sizeof(unsigned)-1);
    printf("%zu\n", sizeof n+2);
    printf("%zu\n", sizeof+1);
    printf("%zu\n", sizeof(double)-1);
    printf("%zu\n", sizeof(n + 2));
    printf("%zu\n", sizeof-1);
    printf("%zu\n", sizeof((double)-1));
    printf("%zu\n", sizeof(n+2.0));
}