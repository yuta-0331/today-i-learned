package gold01;

enum Gold16 {
    A("hello"), B("hello"), C("hello");
    private final String value;
    private Gold16(String value) {
        System.out.println(value);
        this.value = value;
    }
    @Override
    public String toString() {
        return this.value;
    }
}

class Main16 {
    public static void main(String[] args) {
        System.out.println(Gold16.A);
    }
}
