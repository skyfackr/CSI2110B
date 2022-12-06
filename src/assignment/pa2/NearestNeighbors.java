package assignment.pa2;/*
 * Linear neighbors search
 *
 * CSI2510 Algorithmes et Structures de Donnees
 * www.uottawa.ca
 *
 * Robert Laganiere, 2022
 *
*/ 
import java.util.List;
import java.util.ArrayList;

public class NearestNeighbors implements INearestNeighbors {

  protected java.util.List<Point3D> points; 

  // construct with list of points
  public NearestNeighbors(List<IPoint3D> points) {
       
    this.points= points; 
  }

  // gets the neighbors of p (at a distance less than eps)
  @Override
  public List<Point3D> rangeQuery(IPoint3D p, double eps) {

    // empty list to contain the neighbors
    List<Point3D> neighbors= new ArrayList<Point3D>(); 

    for (Point3D point: points) {

       if (p.distance(point) < eps) {
		   neighbors.add(point);
	   }
    }
	
    return neighbors;
  }  
}
