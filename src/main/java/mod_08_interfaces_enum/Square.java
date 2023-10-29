package mod_08_interfaces_enum;

public class Square extends Rectangle {
    public Square() {
        super("Square");
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
