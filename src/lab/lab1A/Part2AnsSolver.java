package lab.lab1A;


import java.util.Date;
import java.util.Timer;

import static lab.lab1A.AlgAnalysis.*;

public class Part2AnsSolver {
    static long ONE_MINUTE_NANOSEC = 60000000000L;
    static void solveEqualN()
    {
        int[] sample=new int[]{50,200, 10000, 20000, 50000, 100000, 200000};
        for (int i=0;i<sample.length;i++)
        {
            System.out.println("n=%d, unique1=%d, unique2=%d".formatted(sample[i],unique1Runtime(sample[i]),unique2Runtime(sample[i])));
        }
    }
    static void findLargestSize()
    {
        long max1=0,max2=0,maxtime1=0,maxtime2=0;
        while (true)
        {
            max1++;
            long time=unique1Runtime((int)max1);
            if (time> ONE_MINUTE_NANOSEC)
            {
                max1--;
                break;
            }
            maxtime1=Math.max(maxtime1,time);
        }
        while (true)
        {
            max2++;
            long time=unique2Runtime((int)max2);
            if (time> ONE_MINUTE_NANOSEC)
            {
                max2--;
                break;
            }
            maxtime2=Math.max(maxtime2,time);
        }
        System.out.println("unique1 max size=%d, unique2 max size=%d".formatted(max1,max2));
    }
}
