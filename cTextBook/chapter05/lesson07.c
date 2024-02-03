#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct {
    int draw;
    int lose;
    int win;
} Score;

char *hd[] = {"グー", "チョキ", "パー"};

// 初期化処理
void initialize(Score* s) {
    s->win = s->lose = s->draw = 0; // スコアをクリア
    srand((unsigned)time(NULL));
    printf("じゃんけんゲーム開始!!\n");
}

void selectPlayTime(int* num) {
    printf("何回勝負にしますか？: ");
    do {
        scanf("%d", num);
        if (*num < 1) {
            printf("不正な入力です");
        }
    } while (*num < 1);
}

// じゃんけん実行（コンピュータの手の生成/ユーザーの手の読み込み）
void jyanken(int* h_hand, int* c_hand) {
    *c_hand = rand() % 3;
    *(c_hand + 1) = rand() % 3;

    do {
        printf("\nじゃんけんポン!");
        for (int i = 0; i < 3; i++) {
            printf("(%d)%s", i, hd[i]);
        }
        printf(":");
        scanf("%d", h_hand);
    } while (*h_hand < 0|| *h_hand > 2);
}

int judgeGame(int* comp, int* human) {
    int hdNum[] = {1, 2, 4};
    int sum = hdNum[*comp] | hdNum[*(comp + 1)] | hdNum[*human];
    int sumShiftLeft = sum > 4 ? (sum<<1) + 1 : sum << 1;

    if (sum == 7 || sum == 1 || sum == 2 || sum == 4) {
        return 0;
    } else {
        return hdNum[*human] == (sum & sumShiftLeft) ? 2 : 1;
    }
}

// scoreを更新して判定結果を表示
void update_score_and_disp(Score* s, int result) {
    switch (result) {
        case 0:
            s->draw++;
            puts("引き分けです。\n");
            break;
        case 1:
            s->lose++;
            puts("あなたの負けです。\n");
            break;
        case 2:
            s->win++;
            puts("あなたの勝ちです。\n");
            break;
    }
}

// 再挑戦するかを確認
int confirm_retry(void) {
    int x;
    printf("もう一度しますか？(0)いいえ(1)はい: ");
    do {
        scanf("%d", &x);
        if (x != 0 && x != 1) {
            printf("不正な入力です。");
        }
    } while (x != 0 && x != 1);

    return x;
}

int main() {
    Score score;
    initialize(&score);

    int mode;
    printf("[0]n回勝負, [1]好きなだけ挑戦");
    do {
        scanf("%d", &mode);
        if (mode != 0 && mode != 1) {
            printf("不正な入力です。");
        }
    } while (mode != 0 && mode != 1);
    
    int num;
    if (!mode) {
        selectPlayTime(&num);
    }

    do {
        int human;
        int comp[2];
        jyanken(&human, comp);

        printf("CP1は%s、CP2は%sで、あなたは%sです。\n", hd[comp[0]], hd[comp[1]], hd[human]);
        int judge = judgeGame(comp, &human);
        
        update_score_and_disp(&score, judge);
        if (mode) {
            num = confirm_retry();
        }
    } while (mode && num || !mode && score.win < num && score.lose < num);

    printf("%d勝%d敗%d分けでした\n", score.win, score.lose, score.draw);
}