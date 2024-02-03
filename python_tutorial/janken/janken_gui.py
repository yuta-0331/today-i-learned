import random
import tkinter as tk
from PIL import Image, ImageTk

root = tk.Tk()
root.geometry("420x400")

gu_image = Image.open("image/janken_gu.png").convert("RGB").resize((100, 100))
gu_image = ImageTk.PhotoImage(gu_image)
tk.Label(root, image=gu_image).place(x=20, y=200)

choki_image = Image.open("image/janken_choki.png").convert("RGB").resize((100, 100))
choki_image = ImageTk.PhotoImage(choki_image)
tk.Label(root, image=choki_image).place(x=160, y=200)

pa_image = Image.open("image/janken_pa.png").convert("RGB").resize((100, 100))
pa_image = ImageTk.PhotoImage(pa_image)
tk.Label(root, image=pa_image).place(x=300, y=200)

hands = "グー", "チョキ", "パー"
player_hand = 0

def gu_func():
    judge(0)


def choki_func():
    judge(1)


def pa_func():
    judge(2)


tk.Button(root, text="グー", command=gu_func).place(x=50, y=320)
tk.Button(root, text="チョキ", command=choki_func).place(x=180, y=320)
tk.Button(root, text="パー", command=pa_func).place(x=325, y=320)

enemy_label = tk.Label(root, image=gu_image)
enemy_label.place(x=160, y=20)
text_label = tk.Label(root, text="最初はグー！じゃんけん！")
text_label.place(x=140, y=140)

def judge(me):
    com_hand = random.randint(0, 2)
    result = player_hand - com_hand
    if result == -1 or result == 2:
        text_label.configure(text="勝ち")
    elif result == -2 or result == 1:
        text_label.configure(text="負け")
    else:
        text_label.configure(text="あいこ")
print(text_label)

root.mainloop()