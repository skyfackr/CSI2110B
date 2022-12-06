
/*
 * Copyright (c) 2022.
 * Sky Jiang 300217544
 */

package assignment.pa2;

import javax.swing.*;
import java.util.List;

public class Exp1Launcher {
    static final double EPS=0.05;
    static final String file="./testdata/Point_Cloud_1.csv";
    static final String OUT="./exp1/";
    public static void main(String[] args) throws Exception {

        for (List<String> now:cmd)
        {
            printCmd(now);
            Exp1.main(new String[]{
                    now.get(0),
                    Double.toString(EPS),
                    file,
                    now.get(1),
                    now.get(2),
                    now.get(3),
                    getOutFile(now)


            });
        }
    }
    static void printCmd(List<String> c)
    {
        System.out.println("java Exp1 %s %f %s %s %s %s %s".formatted(c.get(0),EPS,file, c.get(1), c.get(2), c.get(3),getOutFile(c)));
    }
    static String getOutFile(List<String> c)
    {
        return OUT+"pt%s_%s.txt".formatted(c.get(4),c.get(0));
    }

    /**
     * 1. (-5.429850155, 0.807567048, -0.398216823)
     * 2. (-12.97637373, 5.09061138, 0.762238889)
     * 3. (-36.10818686, 14.2416184, 4.293473762)
     * 4. (3.107437007, 0.032869335, 0.428397562)
     * 5. (11.58047393, 2.990601868, 1.865463342)
     * 6. (14.15982089, 4.680702457, -0.133791584)
     */
    static final List<List<String>> cmd= List.of(List.of("lin","-5.429850155", "0.807567048", "-0.398216823","1"),
            List.of("kd","-5.429850155", "0.807567048", "-0.398216823","1"),
    List.of("lin","-12.97637373", "5.09061138", "0.762238889","2"),
            List.of("kd","-12.97637373", "5.09061138", "0.762238889","2"),
            List.of("lin","-36.10818686", "14.2416184", "4.293473762","3"),
            List.of("kd","-36.10818686", "14.2416184", "4.293473762","3"),
            List.of("lin","3.107437007", "0.032869335", "0.428397562","4"),
            List.of("kd","3.107437007", "0.032869335", "0.428397562","4"),
            List.of("lin","11.58047393", "2.990601868", "1.865463342","5"),
            List.of("kd","11.58047393", "2.990601868", "1.865463342","5"),
            List.of("lin","14.15982089", "4.680702457", "-0.133791584","6"),
                List.of("kd","14.15982089", "4.680702457", "-0.133791584","6")
    );
}
