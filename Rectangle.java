public class Rectangle {
    double width;
    double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double getArea() {
        return this.width * this.height;
    }

    boolean isLarger(Rectangle arg) {
        return this.getArea() > arg.getArea();
    }

    public static void main(String[] args) {
        Rectangle rect01 = new Rectangle(1, 2);
        Rectangle rect02 = new Rectangle(2, 3);
        System.out.println(rect01.getArea());
        System.out.println(rect01.isLarger(rect02));
    
    }
}