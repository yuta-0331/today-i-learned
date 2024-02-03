#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct {
    int draw;
    int lose;
    int win;
} Score;

char *hd[] = {"�O�[", "�`���L", "�p�["};

// ����������
void initialize(Score* s) {
    s->win = s->lose = s->draw = 0; // �X�R�A���N���A
    srand((unsigned)time(NULL));
    printf("����񂯂�Q�[���J�n!!\n");
}

void selectPlayTime(int* num) {
    printf("���񏟕��ɂ��܂����H: ");
    do {
        scanf("%d", num);
        if (*num < 1) {
            printf("�s���ȓ��͂ł�");
        }
    } while (*num < 1);
}

// ����񂯂���s�i�R���s���[�^�̎�̐���/���[�U�[�̎�̓ǂݍ��݁j
void jyanken(int* h_hand, int* c_hand) {
    *c_hand = rand() % 3;
    *(c_hand + 1) = rand() % 3;

    do {
        printf("\n����񂯂�|��!");
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

// score���X�V���Ĕ��茋�ʂ�\��
void update_score_and_disp(Score* s, int result) {
    switch (result) {
        case 0:
            s->draw++;
            puts("���������ł��B\n");
            break;
        case 1:
            s->lose++;
            puts("���Ȃ��̕����ł��B\n");
            break;
        case 2:
            s->win++;
            puts("���Ȃ��̏����ł��B\n");
            break;
    }
}

// �Ē��킷�邩���m�F
int confirm_retry(void) {
    int x;
    printf("������x���܂����H(0)������(1)�͂�: ");
    do {
        scanf("%d", &x);
        if (x != 0 && x != 1) {
            printf("�s���ȓ��͂ł��B");
        }
    } while (x != 0 && x != 1);

    return x;
}

int main() {
    Score score;
    initialize(&score);

    int mode;
    printf("[0]n�񏟕�, [1]�D���Ȃ�������");
    do {
        scanf("%d", &mode);
        if (mode != 0 && mode != 1) {
            printf("�s���ȓ��͂ł��B");
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

        printf("CP1��%s�ACP2��%s�ŁA���Ȃ���%s�ł��B\n", hd[comp[0]], hd[comp[1]], hd[human]);
        int judge = judgeGame(comp, &human);
        
        update_score_and_disp(&score, judge);
        if (mode) {
            num = confirm_retry();
        }
    } while (mode && num || !mode && score.win < num && score.lose < num);

    printf("%d��%d�s%d�����ł���\n", score.win, score.lose, score.draw);
}