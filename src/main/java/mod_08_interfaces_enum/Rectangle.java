package mod_08_interfaces_enum;

public class Rectangle extends Quadrilaterals {
    public Rectangle() {
        super("Rectangle");
    }
    public Rectangle(String name) {
        super(name);
    }

    @Override
    public String getClassName() {
        return this.getClass().getName();
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }
}
