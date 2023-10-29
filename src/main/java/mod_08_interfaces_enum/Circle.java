package mod_08_interfaces_enum;

public class Circle extends Ellipse {
    public Circle() {
        super("Circle");
    }

    @Override
    public String getClassName() {
        return this.getClass().getName();
    }

    @Override
    public double getArea() {
        return 0;
    }

}
