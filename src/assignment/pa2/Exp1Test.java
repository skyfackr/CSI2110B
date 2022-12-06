/*
 * Copyright (c) 2022.
 * Sky Jiang 300217544
 */

package assignment.pa2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Exp1Test {
    static final String DIR="./exp1";
    public static void main(String[] args) throws Exception {
        List<List<List<Point3D>>> data=loadAll(DIR);
        for (List<List<Point3D>> pair : data) {
            List<Point3D> f1,f2;
            f1=pair.get(0);
            f2=pair.get(1);
            if (f1.stream().allMatch((p)->f2.contains(p))){
                System.out.println("File %d OK".formatted(data.indexOf(pair)));
            }
            else {
                System.out.println("File %d Not Same".formatted(data.indexOf(pair)));
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
        pair.add(Exp1.read(f1.getAbsolutePath()));
        pair.add(Exp1.read(f2.getAbsolutePath()));
        return pair;
    }
}
