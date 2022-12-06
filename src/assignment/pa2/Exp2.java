/*
 * Copyright (c) 2022.
 * Sky Jiang 300217544
 */

package assignment.pa2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Exp2 {
    /**
     * java Exp2 [lin/kd] [eps] [filename] [step]
     */
    public static void main(String[] args) throws Exception {

        String method= args[0];
        double eps= Double.parseDouble(args[1]);
        List<Point3D> points= Exp1.read(args[2]);
        int step= Integer.parseInt(args[3]);
        INearestNeighbors nn= createNearestNeighbors(method, points);
        List<Long> times=new ArrayList<>();
        for (int index=step-1; index<points.size(); index+=step) {
            Point3D query= points.get(index);
            long start= System.nanoTime();
            List<Point3D> neighbors= nn.rangeQuery(query,eps);
            long end= System.nanoTime();
            long time= (end-start)/1000000;
            times.add(time);
        }
        System.out.println("aver. time=%f".formatted(times.stream().mapToLong(Long::longValue).average().orElse(0)));



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
