#include <stdio.h>

typedef struct _Book {
    char title[30];
    int price;
} Book;

void sortBookByPrice(Book* pBooks, int size) {
    for (int i = 0; i < size; i++) {
        int lowPriceIndex = 0;
        for (int j = 1; j < size - i; j++) {
            if ((pBooks + j)->price > (pBooks + lowPriceIndex)->price) {
                lowPriceIndex = j;
            }
        }
        Book tmp = *(pBooks + lowPriceIndex);
        *(pBooks + lowPriceIndex) = *(pBooks + size - 1 - i);
        *(pBooks + size - 1 - i) = tmp;
    }
}

int main() {
    Book books[] = {
        {"PHP入門", 1980},
        {"JavaScript", 3980},
        {"Ruby on Rails", 4800},
        {"SQL入門", 2890},
        {"C lang", 2900}
    };
    Book* pBooks = books;
    sortBookByPrice(pBooks, 5);

    for (int i = 0; i < 5; i++) {
        printf("%s\t%d\n", pBooks->title, pBooks->price);
        pBooks++;
    }
}