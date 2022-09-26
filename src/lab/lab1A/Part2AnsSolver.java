package lab.lab1A;
/*
* n=50, unique1=592200, unique2=728200
n=200, unique1=233400, unique2=45700
n=10000, unique1=10039300, unique2=1943200
n=20000, unique1=35528600, unique2=1877200
n=50000, unique1=210946400, unique2=3844600
n=100000, unique1=851631000, unique2=4450000
n=200000, unique1=3519915500, unique2=9920100
* */

import static lab.lab1A.AlgAnalysis.unique1Runtime;
import static lab.lab1A.AlgAnalysis.unique2Runtime;

public class Part2AnsSolver {
    static long ONE_MINUTE_NANOSEC = 60000000000L;
    static int STEP1 = 2000;
    static int STEP2=1000000;

    static void solveEqualN() {
        int[] sample = new int[]{50, 200, 10000, 20000, 50000, 100000, 200000};
        for (int i = 0; i < sample.length; i++) {
            System.out.printf("n=%d, unique1=%d, unique2=%d%n", sample[i], unique1Runtime(sample[i]), unique2Runtime(sample[i]));
        }
    }

    static void findLargestSize() {
        long max1 = 820000, max2 = 650000000, maxtime1 = 0, maxtime2 = 0;
        System.out.println("testing unique1");
        while (true) {
            max1 += STEP1;
            System.out.println("max1 = " + max1);
            long time = unique1Runtime((int) max1);
            if (time > ONE_MINUTE_NANOSEC) {
                max1 -= STEP1;
                break;
            }
            maxtime1 = Math.max(maxtime1, time);
            System.out.println("time = " + time);
        }
        System.out.println("testing unique2");
        while (true) {
            max2 += STEP2;
            System.out.println("max2 = " + max2);
            long time = unique2Runtime((int) max2);
            if (time > ONE_MINUTE_NANOSEC) {
                max2 -= STEP2;
                break;
            }
            maxtime2 = Math.max(maxtime2, time);
            System.out.println("time = " + time);
        }
        System.out.printf("unique1 max size=%d, unique2 max size=%d%n", max1, max2);
    }

    public static void main(String[] args) {
        //solveEqualN();
        findLargestSize();
    }
}
