public class PaperFortune {
    public static void main(String[] args) {
        int ran = (int) (Math.random() * 10) + 1;

        String result;

        if (ran == 1) {
            result = "大凶";
        } else if (ran < 3) {
            result = "凶";
        } else if (ran < 5) {
            result = "吉";
        } else if (ran < 7) {
            result = "小吉";
        } else if (ran < 9) {
            result = "中吉";
        } else {
            result = "大吉";
        }

        System.out.println("あなたは" + result + "です。");
    }
}
