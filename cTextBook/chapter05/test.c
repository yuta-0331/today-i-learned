#include <stdio.h>
#include <stdbool.h>

bool a(double x) {
    return x > 3 || x < 2;
}

bool b(double x) {
    return !(x == 3 || x == 2);
}

int main() {
    printf("%d %d", a(2.1), b(2.1));
}