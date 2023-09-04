#include <stdio.h>

int main() {
    int month;
    printf("月を入力してください: ");
    scanf("%d", &month);
    
    // 入力チェック
    if (month > 12 || month < 0) {
        printf("不正な入力です");
    }

    printf("%d月は", month);
    switch (month)
    {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
        printf("31日");
        break;
    case 2:
        printf("28日");
        break;
    case 4:
    case 6:
    case 9:
    case 11:
        printf("30日");
        break;
    } 
}