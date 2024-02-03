from functools import reduce



number = 1
number2 = 1.0
greeting = 'こんにちは'
is_ok = True

print(number, type(number))
print(number, type(number2))
print(greeting, type(greeting))
print(is_ok, type(is_ok))

print(2 > 1)
print(1 < 2)

my_friends = ['花子', '太郎', "健太", True]

print(my_friends[0])
print(my_friends)
print(len(my_friends))

my_friends.append(4)
print(len(my_friends))

my_friends.insert(3, 3)

print(my_friends)

my_friends.pop()

print(my_friends)

name_list = ['my', 'name', 'is', 'ken']
print(' '.join(name_list))
print(' '.join(name_list).split(' '))

numbers = (1, 2, 3, 4)
print(type(numbers))

print(numbers)

a = {"a": "k"}

print(type(a))
A = {1, 2, 3}
B = {3, 4, 5}
print(A | B)
print(A & B)

nums = map(int, ["1", "2", "3"])
for num in nums:
    print(num)

print(nums)


def is_even(num):
    return num % 2 == 0


print(is_even(2))
print(is_even(5))
nums = map(int, ["1", "2", "3"])

even_nums = filter(lambda num: num % 2 == 0, nums)

print(list(even_nums))


print(reduce(lambda x, y: x * y, [1, 2, 3, 4, 5]))

a = 100
b = 100
print(a == b)
print(a is b)

list1 = [0, 1, 2]
list2 = [0, 1, 2]
print(list1 == list2)
print(list1 is list2)