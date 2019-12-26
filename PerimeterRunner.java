/*
* This class is renponsable for returned the shape perimeter
*/

import edu.duke.*;

public class PerimeterRunner{
    
    public double getPerimeter(Shape s) {
        double perimeter = 0;
        Point prevPt = s.getLastPoint();
    

        for(Point current_Pt: s.getPoints()){
            double currDist = prevPt.distance(current_Pt);
            perimeter += currDist;
            prevPt = current_Pt;
        }

        return perimeter;

    }
    
    public static void main(String[] args) {
        Shape s = new Shape();
        Point a = new Point(3,2);
        Point b = new Point(3,7);
        Point c = new Point(6,2);

        s.addPoint(a);
        s.addPoint(b);
        s.addPoint(c);

        PerimeterRunner Perim_run = new PerimeterRunner();

        System.out.println(Perim_run.getPerimeter(s));

    }
}