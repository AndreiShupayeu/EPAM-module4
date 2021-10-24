package by.epam.module4.simple.classes.objects.task7;
//Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
//площади, периметра и точки пересечения медиан.

public class Task7 {
    public static void main(String[] args) {

        Point point1 = new Point(-1, 1);
        Point point2 = new Point(1, 1);
        Point point3 = new Point(0, -1);

        Point point4 = new Point(2, 2);
        Point point5 = new Point(3, 2);
        Point point6 = new Point(4, 2);

        Triangle triangle = Triangle.createTriangle(point1, point2, point3);
        if (triangle == null) {
            System.out.println("Points are on one line!!!");
        }

        Triangle triangle1 = Triangle.createTriangle(point4, point5, point6);
        if (triangle1 == null) {
            System.out.println("Points are on one line!!!");
        }

        System.out.println();
        System.out.println("Perimeter of triangle: " + triangle.getPerimeter());
        System.out.println("Square of triangle: " + triangle.getSquare());
        System.out.println("Point (x): " + triangle.getPointIntersectionMedians().getX());
        System.out.println("Point (y): " + triangle.getPointIntersectionMedians().getY());

    }
}

class Triangle {
    private final Point point1;
    private final Point point2;
    private final Point point3;


    private Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public static Triangle createTriangle(Point point1, Point point2, Point point3) {
        if (PointUtils.isOneStraightLine(point1, point2, point3)) {
            return null;
        } else {
            return new Triangle(point1, point2, point3);
        }
    }

    public double getPerimeter() {
        return PointUtils.getDistance(point1, point2) + PointUtils.getDistance(point1, point3) +
                PointUtils.getDistance(point2, point3);
    }

    public double getSquare() {
        double hP = getPerimeter() / 2;
        return Math.sqrt(hP * (hP - PointUtils.getDistance(point1, point2)) *
                (hP - PointUtils.getDistance(point1, point3)) *
                (hP - PointUtils.getDistance(point2, point3)));
    }

    public Point getPointIntersectionMedians() {
        int x = (point1.getX() + point2.getX() + point3.getX()) / 3;
        int y = (point1.getY() + point2.getY() + point3.getY()) / 3;
        return new Point(x, y);
    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

class PointUtils {
    public static double getDistance(Point a, Point b) {
        return Math.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()) + (b.getY() - a.getY()) * (b.getY() - a.getY()));
    }

    public static boolean isOneStraightLine(Point a, Point b, Point c) {
        return ((c.getX() - a.getX()) * (b.getY() - a.getY()) == (c.getY() - a.getY()) * (b.getX() - a.getX()));
    }
}