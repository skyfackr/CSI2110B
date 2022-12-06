/*
 * Copyright (c) 2022.
 * Sky Jiang 300217544
 */

package assignment.pa2;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Exp1Test {
    static final String DIR="./exp1";
    public static void main(String[] args) throws Exception {
        List<List<List<Point3D>>> data=loadAll(DIR);
        for (List<List<Point3D>> pair : data) {
            List<Point3D> f1,f2;
            f1=pair.get(0);
            f2=pair.get(1);
            if (containsAll(f1,f2)) {
                System.out.printf("File %d OK%n", data.indexOf(pair));
            }
            else {
                System.out.printf("File %d Not Same%n", data.indexOf(pair));
            }
        }
    }
    static List<List<List<Point3D>>> loadAll(String dir) throws Exception {
        List<List<List<Point3D>>> all=new ArrayList<>();
        for (int i=1;i<=6;i++)
        {
            File f1 = new File(dir,"pt%d_kd.txt".formatted(i));
            File f2 = new File(dir,"pt%d_lin.txt".formatted(i));
            all.add(loadPair(f1,f2));
        }
        return all;
    }
    static List<List<Point3D>> loadPair(File f1, File f2) throws Exception {
        List<List<Point3D>> pair=new ArrayList<>();
        pair.add(read2(f1.getAbsolutePath()));
        pair.add(read2(f2.getAbsolutePath()));
        return pair;
    }
    public static List<Point3D> read2(String filename) throws Exception {

        List<Point3D> points= new ArrayList<Point3D>();
        double x,y,z;

        Scanner sc = new Scanner(new File(filename));
        // sets the delimiter pattern to be , or \n \r
        sc.useDelimiter(",|\n|\r");

        // skipping the first line x y z
        //sc.next(); sc.next(); sc.next();

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
    static boolean containsAll(List<Point3D> f1, List<Point3D> f2){
        return f1.stream().allMatch((p)-> f2.stream().anyMatch((p2)->p.getX()==p2.getX()&&p.getY()==p2.getY()&&p.getZ()==p2.getZ()));
    }
}
