package grahamScan;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.*;

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}


public class GrahamScan {

    private static double determinant(Point p1, Point p2, Point p3) {

        double result=       p1.x * (p2.y - p3.y)
                - p2.x * (p1.y - p3.y)
                + p3.x * (p1.y - p2.y);

        return result;
    }

    // Graham Scan
    public static List<Point> convexHull(Point[] points, Point min) {

        Arrays.sort(points, (p1, p2) -> {
            double aciA = Math.atan2(p1.y - min.y, p1.x - min.x);
            double aciB = Math.atan2(p2.y - min.y, p2.x - min.x);
            return Double.compare(aciA, aciB);
        });
        /*
        System.out.println("Sorted points:");
        for (Point point : points) {
            System.out.println("("+point.x + "," + point.y+")");
        }
        */
        Stack<Point> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);

        for (int i = 2; i < points.length; i++) {
            while (stack.size() > 1 && determinant(stack.get(stack.size() - 2), stack.peek(), points[i]) <= 0) {
                stack.pop();
            }
            stack.push(points[i]);
        }

        return new ArrayList<>(stack);
    }

    public static double calculateDistance(Point p1, Point p2){
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("start: "+ LocalDateTime.now());

        File file = new File("test2.txt");
        Scanner scanner = new Scanner(file);
        List<Double> listOfx = new ArrayList<Double>();
        List<Double> listOfy = new ArrayList<Double>();

        int index = 0;
        while(scanner.hasNext()){
            if(index%2 == 0)
                listOfx.add(scanner.nextDouble());
            else
                listOfy.add(scanner.nextDouble());
            index++;
        }
        scanner.close();

        System.out.println("reading completed");
        System.out.println("start: "+LocalDateTime.now());

        Point[] points = new Point[index/2];

        for(int i =0; i<index/2; i++){
            points[i] = new Point(listOfx.get(i), listOfy.get(i));
        }

        Point min = points[0];

        for (Point point : points) {
            if((point.y < min.y) || (point.y == min.y && point.x < min.x)){
                min = point;
            }
        }

        List<Point> convexHullPoints = convexHull(points,min);

        System.out.println("Convex Hull Points:");
        for (Point p : convexHullPoints) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }

        System.out.println("selected convex hull points");
        System.out.println("start: "+LocalDateTime.now());
        Point point1=null;
        Point point2=null;
        double maxDistance=0;
        double currentDistance=0;
        int listSize = convexHullPoints.size();
        for(int i=0; i<listSize-1; i++){
            for(int j=i+1; j<listSize; j++){
                currentDistance=calculateDistance(convexHullPoints.get(i), convexHullPoints.get(j));
                if(maxDistance < currentDistance){
                    maxDistance = currentDistance;
                    point1 = convexHullPoints.get(i);
                    point2 = convexHullPoints.get(j);
                }
            }
        }
        System.out.println("Max distance= "+ maxDistance+", Points = "+"(" + point1.x +
                "," +point1.y +")," + "(" + point2.x +","+point2.y+")");
        System.out.println("end: "+LocalDateTime.now());
    }
}
