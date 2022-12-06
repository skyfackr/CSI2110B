/*
 * Copyright (c) 2022.
 * Sky Jiang 300217544
 */

package assignment.pa2;

import assignment.pa2.Exp1;

public class Exp3 {
    public static void main(String[] args) {
        String[] cmd1=new String[]{
                Exp1Launcher.file,
                "1.2",
                "10",
                "lin"
        };
        String[] cmd2=new String[]{
                Exp1Launcher.file,
                "1.2",
                "10",
                "kd"
        };
        long timeLin,timeKd;
        timeLin=test(cmd1);
        timeKd=test(cmd2);
        System.out.println("timeLin = " + timeLin);
        System.out.println("timeKd = " + timeKd);
    }
    static long test(String[] cmd)
    {
        long start=System.currentTimeMillis();
        DBSCAN.main(cmd);
        return System.currentTimeMillis()-start;
    }
}
