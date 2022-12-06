package assignment.pa2;

import java.util.List;

public class Exp2Launcher {
    static final double EPS=0.05;
    static final String file="./testdata/Point_Cloud_1.csv";
    public static void main(String[] args) throws Exception {

            String[] cmd1=new String[]{
                    "lin",
                    Double.toString(EPS),
                    file,
                    "10"
            };
            String[] cmd2=new String[]{
                    "kd",
                    Double.toString(EPS),
                    file,
                    "10"
            };
        System.out.println("java Exp2 %s".formatted(String.join(" ",cmd1)));
        Exp2.main(cmd1);
        System.out.println("java Exp2 %s".formatted(String.join(" ",cmd2)));
        Exp2.main(cmd2);
    }


}
