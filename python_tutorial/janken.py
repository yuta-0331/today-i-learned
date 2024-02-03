import random

hands = "グー", "チョキ", "パー"
while (True):
    player_hand = int(input("0~2の数字を入力してください>>>"))
    com_hand = random.randint(0, 2)

    result = player_hand - com_hand
    if result == -1 or result == 2:
        print(hands[player_hand], hands[com_hand], "勝ち")
        break
    elif result == -2 or result == 1:
        print(hands[player_hand], hands[com_hand], "負け")
        break
    else:
        print(hands[player_hand], hands[com_hand], "あいこ")

