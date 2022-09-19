package lab.lab1A;


import static lab.lab1A.AlgAnalysis.*;

public class Part2AnsSolver {
    static void solveEqualN()
    {
        int[] sample=new int[]{50,200, 10000, 20000, 50000, 100000, 200000};
        for (int i=0;i<sample.length;i++)
        {
            System.out.println("n=%d, unique1=%d, unique2=%d".formatted(sample[i],unique1Runtime(sample[i]),unique2Runtime(sample[i])));
        }
    }
}
