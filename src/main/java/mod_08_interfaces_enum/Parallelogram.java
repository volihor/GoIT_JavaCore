package mod_08_interfaces_enum;

public class Parallelogram extends Quadrilaterals {
    public Parallelogram() {
        super("Parallelogram");
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
