package middletest.q1;

import middletest.q1.enumType.EShape;
import middletest.q1.shape.Circle;
import middletest.q1.shape.Rectangle;
import middletest.q1.shape.Shape;
import middletest.q1.shape.Triangle;

import java.math.BigDecimal;

import static middletest.q1.enumType.EShape.TRIANGLE;
import static middletest.q1.enumType.EShape.RECTANGLE;
import static middletest.q1.enumType.EShape.CIRCLE;

public class ShapeAreaTester {
    public static void main(String[] args) {

        System.out.println("\n================\n");

        printShapeArea(TRIANGLE, new BigDecimal("3.14159265358979323846"), new BigDecimal("2.71828182845904523536"));
        printShapeArea(TRIANGLE, new BigDecimal("3"), new BigDecimal("4.5"));
        printShapeArea(TRIANGLE, new BigDecimal("3"), new BigDecimal("4"));

        shapeCreateException(TRIANGLE, "0", "2.71828182845904523536");
        shapeCreateException(TRIANGLE, "-5", "30.55");

        System.out.println("\n================\n");

        printShapeArea(RECTANGLE, new BigDecimal("3.14159265358979323846"), new BigDecimal("2.71828182845904523536"));
        printShapeArea(RECTANGLE, new BigDecimal("3"), new BigDecimal("4.5"));
        printShapeArea(RECTANGLE, new BigDecimal("3"), new BigDecimal("4"));

        shapeCreateException(RECTANGLE, "0", "2.71828182845904523536");
        shapeCreateException(RECTANGLE, "-5", "30.55");

        System.out.println("\n================\n");

        printShapeArea(CIRCLE, new BigDecimal("3.14159265358979323846"));
        printShapeArea(CIRCLE, new BigDecimal("2.5"));
        printShapeArea(CIRCLE, new BigDecimal("5"));

        shapeCreateException(CIRCLE, "0", null);
        shapeCreateException(CIRCLE, "-5", null);

        System.out.println("\n================\n");
    }

    private static void printShapeArea(EShape shapeType, BigDecimal... dimensions) {
        Shape shape = createShape(shapeType, dimensions);
        System.out.println(shapeType + ": " + shape.getArea());
    }

    private static void shapeCreateException(EShape shapeType, String num1, String num2) {
        BigDecimal dim1 = new BigDecimal(num1);
        BigDecimal dim2 = num2 != null ? new BigDecimal(num2) : null;
        try {
            createShape(shapeType, dim1, dim2);
        } catch (Exception e) {
            System.out.println("💣" + e.getMessage() + "💣");
        }
    }

    private static Shape createShape(EShape shapeType, BigDecimal... dimensions) {
        return switch (shapeType) {
            case TRIANGLE -> new Triangle(dimensions[0], dimensions[1]);
            case RECTANGLE -> new Rectangle(dimensions[0], dimensions[1]);
            case CIRCLE -> new Circle(dimensions[0]);
        };
    }
}
