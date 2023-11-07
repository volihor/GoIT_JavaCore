package mod_08_interfaces_enum;

public abstract class Figure {
    private final String name;
    private double area;
    private double perimeter;
    public Figure(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void printName() {
        System.out.println("Name of this figure: " + name);
    }
    public abstract String getClassName();  //for some task :)
    public abstract double getArea(); //for now it is not used
    public abstract double getPerimeter(); //for now it is not used

    @Override
    public String toString(){
        return "Figure name is: " + name;
    }
}
