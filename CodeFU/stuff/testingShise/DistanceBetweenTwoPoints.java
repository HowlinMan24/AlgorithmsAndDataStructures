package CodeFU.stuff.testingShise;

class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) { // Distance between two points
        return Math.sqrt((x - point.x) * (x - point.x) + (y - point.y) * (y - point.y));
    }

}


public class DistanceBetweenTwoPoints {

    Point[] points;

    public DistanceBetweenTwoPoints(Point[] points) {
        this.points = points;
    }

    public float minDistance() {
        float minDistance = Float.MAX_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                minDistance = (float) Math.min(minDistance, points[i].distance(points[j]));
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {

        Point point1 = new Point(4, 5.5);
        Point point2 = new Point(1.2, 12.5);
        Point point3 = new Point(1.5, 12.5);
        Point point4 = new Point(4, -9.9);

        Point[] points = {point1, point2, point3, point4};
        DistanceBetweenTwoPoints betweenTwoPoints = new DistanceBetweenTwoPoints(points);
        System.out.printf("%.2f", betweenTwoPoints.minDistance());

    }

}
