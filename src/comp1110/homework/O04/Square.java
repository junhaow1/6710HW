package comp1110.homework.O04;

public class Square extends Shape {
    public double length;
    public double x;
    public double y;

    @Override
    public boolean overlaps(Shape other) {
        return ((other.x >= this.x - length) && (other.x <= this.x + length)) &&
                ((other.y >= this.y - length) && (other.y <= this.y + length));

    }
    @Override
    public double perimeter() {
        return 4*length;
    }

    @Override
    public double area() {
        return length*length;
    }

    public Square(double length) {
        this.length = length;
    }
}
