class Animal:

    count = 0

    def __init__(self, kind, age):
        self.kind = kind
        self.age = str(age) + "歳"
        Animal.count += 1

    def cry(self):
        print("私は" + self.kind + "です")


class Dog(Animal):
    def run(self):
        print("駆け回ります")

    def cry(self):
        print("わんわん")

class Cat(Animal):
    def __init__(self, kind, age, color):
        super().__init__(kind, age)
        self.color = color

    def cry(self):
        print("にゃーん" + self.kind + "だにゃん")


pochi = Dog("秋田犬", 8)
pochi.cry()
pochi.run()

tama = Cat("三毛猫", 3, "パステル")
tama.cry()