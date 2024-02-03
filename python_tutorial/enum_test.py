seasons = ["spring", "summer", "fall", "winter"]
print(list(enumerate(seasons)))

english = "english"
for (i, c) in enumerate(english):
    print(i, c)


dic = {"a": 1, "b": 2}
print(enumerate(dic))

prices = [100, 200, 300]
quantities = [1, 2, 3]

for (price, quantity) in zip(prices, quantities):
    print(price * quantity)

print([i for i in range(10) if i % 3 == 0])

print([i if i % 2 == 0 else i * i for i in range(10)])