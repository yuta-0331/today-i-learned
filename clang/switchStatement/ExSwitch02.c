#include <stdio.h>

int main() {
    int selectNum;
    printf("1:犬 2:猫 3:インコ 番号を選択してください: ");
    scanf("%d", &selectNum);

    if (selectNum < 0 || selectNum > 3) {
        printf("不正な入力です");
    }

    switch (selectNum) {
        case 1:
            printf("忠誠心が高いです。");
            break;
        case 2:
            printf("自由気ままです。");
            break;
        case 3:
            printf("とても甘えん坊です");
            break;
    }
}