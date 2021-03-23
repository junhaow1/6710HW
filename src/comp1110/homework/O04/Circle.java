package comp1110.homework.O04;

public class Circle extends Shape {
    public double length;
    public double x;
    public double y;

    @Override
    public boolean overlaps(Shape other) {
        return ((other.x - this.x) * (other.x - this.x) + (other.y - this.y) * (other.y - this.y)) < (length * length);
    }

    @Override
    public double perimeter() {
        return 2*Math.PI * length;
    }

    @Override
    public double area() {
        return Math.PI * length * length;
    }


    public Circle(double length) {
        this.length = length;
    }
}
