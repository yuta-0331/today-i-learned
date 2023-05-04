
public class VirtualPetGame {

    static void sleepAndMove(VirtualPet arg) {
        arg.printStatus();
        arg.move();
        arg.sleep();
        arg.printStatus();
    }
    public static void main(String[] args) {
        VirtualDog taro = new VirtualDog("taro", 120, 60);
        VirtualBird piyo = new VirtualBird("piyo", 80, 40);

        sleepAndMove(taro);
        sleepAndMove(piyo);
    }
}

class VirtualPet {
    String name;
    int maxEnergy;
    int currentEnergy;

    VirtualPet(String name, int maxEnergy, int currentEnergy) {
        this.name = name;
        this.maxEnergy = maxEnergy;
        this.currentEnergy = currentEnergy;
    }

    void printStatus() {
        System.out.println("statusを表示");
        System.out.println(this.name);
        System.out.println(this.maxEnergy);
        System.out.println(this.currentEnergy);
    }

    //オーバーライドさせるメソッド
    void move() {}

    void sleep() {
        System.out.println("よく寝た。体力が回復した!");
        this.currentEnergy = this.maxEnergy;
    }
}

class VirtualDog extends VirtualPet {
    VirtualDog(String name, int maxEnergy, int currentEnergy) {
        super(name, maxEnergy, currentEnergy);
    }

    void move() {
        System.out.println("歩いた。疲れたが体力がついた！");
        this.currentEnergy -= 10;
        this.maxEnergy++;
    }
}

class VirtualBird extends VirtualPet {
    VirtualBird(String name, int maxEnergy, int currentEnergy) {
        super(name, maxEnergy, currentEnergy);
    }

    void move() {
        System.out.println("飛んだ。疲れたが体力がついた！");
        this.currentEnergy -= 10;
        this.maxEnergy++;
    }
}