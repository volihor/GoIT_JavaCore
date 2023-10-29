package mod_08_interfaces_enum;

public class FigureTest {
    public static void main(String[] args) {
        // create different versions of object types for testing only
        Figure circle = new Circle();
        Shape rectangle = new Rectangle();
        Quadrilaterals square = new Square();
        Hexagon triangle = new Triangle();
        Figure parallelogram = new Parallelogram();

        // test for @Overrided method in Figure superClass
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);
        System.out.println(triangle);
        System.out.println(parallelogram);

        // test for printName() method in Figure superClass
        circle.printName();
        rectangle.printName();
        square.printName();
        triangle.printName();
        parallelogram.printName();

        // test for class FigureNamePrint with method figureNamePrint()
        // that takes any classes that inherits Shape's superClass

        FigureNamePrint figurenameprint = new FigureNamePrint();

        figurenameprint.figureNamePrint(circle);
        figurenameprint.figureNamePrint(rectangle);
        figurenameprint.figureNamePrint(square);
        figurenameprint.figureNamePrint(triangle);
        figurenameprint.figureNamePrint(parallelogram);
    }
}
