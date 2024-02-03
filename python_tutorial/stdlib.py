import math
import random
import calculator

lang = ['p', 'y', 't', 'h', 'o', 'n']

random.shuffle(lang)

new_lang = " ".join(lang)
print(lang)

char = random.choice(lang)

print(char)

x = 3.14
print(math.floor(x))
print(math.ceil(x))

print(calculator.calc(3, 4))