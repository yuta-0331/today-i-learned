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
        printf("元旦、成人の日");
        break;
    case 2:
        printf("建国記念の日");
        break;
    case 3:
        printf("春分の日");
        break;
    case 4:
        printf("昭和の日");
        break;
    case 5:
        printf("憲法記念日、みどりの日、こどもの日");
        break;
    case 7:
        printf("海の日");
        break;
    case 9:
        printf("敬老の日、秋分の日");
        break;
    case 10:
        printf("体育の日");
        break;
    case 11:
        printf("文化の日、勤労感謝の日");
        break;
    case 12:
        printf("天皇誕生日");
        break;
    default:
        printf("%d月は祝日がありません", month);
        break;
    } 
}