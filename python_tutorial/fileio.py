# fp = open("sample.txt", mode='w')
# print(fp)
# print(type(fp))
#
# fp.write("good morning")
# fp.close()

with open("sample.txt", mode="r") as f:
    # f.write("good morning")
    data = f.read()

    print(data)


