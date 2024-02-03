for i in range(0, 10, 2):
    print(i)

scores = [55, 43, 78]

for score in scores:
    print(score)

for score in scores:
    if score >= 70:
        print(str(score) + "success")
    else:
        print(str(score) + "fail")


for x in range(1, 10):
    for y in range(1, 10):
        print(str(x) + "*" + str(y) + "=" + str(x * y))

weight = 70

while weight >= 50:
    weight -= 1
    print(weight)