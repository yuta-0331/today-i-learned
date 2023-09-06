#include <stdio.h>
#include <stdbool.h>

int main() {
    // 配列の作成
    int numbers[10];
    for (int i = 0; i < 10; i++) {
        int inputNum;
        printf("数値を入力してください\n");
        scanf("%d", &inputNum);
        numbers[i] = inputNum;
    }

    // sortのアルゴリズム
    for (int i = 0; i < 10; i++) {
        int maxIndex = 0;
        for (int k = 1; k < 10 - i; k++) {
            if (numbers[k] > numbers[maxIndex]) {
                maxIndex = k;
            }
        }
        int tmp = numbers[maxIndex];
        numbers[maxIndex] = numbers[9 - i];
        numbers[9 - i] = tmp;
    }

    // 配列の表示
    for (int i = 0; i < 10; i++) {
        printf("%d ", numbers[i]);
    }
}