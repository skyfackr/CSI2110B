package assignment.pa2;/*
 * Incomplete Experiment 1 
 *
 * CSI2510 Algorithmes et Structures de Donnees
 * www.uottawa.ca
 *
 * Robert Laganiere, 2022
 *
*/

import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

import java.io.*;  
import java.util.Scanner;  

public class Exp1 {
  
  // reads a csv file of 3D points (rethrow exceptions!)
  public static List<Point3D> read(String filename) throws Exception {
	  
    List<Point3D> points= new ArrayList<Point3D>(); 
	double x,y,z;
	
	Scanner sc = new Scanner(new File(filename));  
	// sets the delimiter pattern to be , or \n \r
	sc.useDelimiter(",|\n|\r");  

	// skipping the first line x y z
	sc.next(); sc.next(); sc.next();
	
	// read points
	while (sc.hasNext())  
	{  
		x= Double.parseDouble(sc.next());
		y= Double.parseDouble(sc.next());
		z= Double.parseDouble(sc.next());
		points.add(new Point3D(x,y,z));  
	}   
	
	sc.close();  //closes the scanner  
	
	return points;
  }
  
  public static void main(String[] args) throws Exception {

	  String method= args[0];
  
    // not reading args[0]
	double eps= Double.parseDouble(args[1]);
  
    // reads the csv file
    List<Point3D> points= Exp1.read(args[2]);
	
	Point3D query= new Point3D(Double.parseDouble(args[3]),
								Double.parseDouble(args[4]),
								Double.parseDouble(args[5]));
	
	// creates the NearestNeighbor instance
	INearestNeighbors nn= createNearestNeighbors(method, points);
	List<Point3D> neighbors= nn.rangeQuery(query,eps);
	List<String> neighborsString = new ArrayList<String>();
	for (Point3D point: neighbors) {
		neighborsString.add(point.toString());
	}
	File out= Paths.get(args[6]).toFile();
	out.createNewFile();
	  try (OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream(out))){
		  streamWriter.write(String.join(",\n", neighborsString));
	  }
	
	System.out.println("number of neighbors= "+neighbors.size());
	System.out.println(String.join(",\n", neighborsString));
  }
  private static INearestNeighbors createNearestNeighbors(String method, List<Point3D> points) {
	  if (method.equals("lin")) {
		  return new NearestNeighbors(points);
	  } else if (method.equals("kd")) {
		  return new NearestNeighborsKD(points);
	  } else {
		  throw new IllegalArgumentException("Invalid method");
	  }
  }
}
