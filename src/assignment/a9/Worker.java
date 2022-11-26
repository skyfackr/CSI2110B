package assignment.a9;

public class Worker {
    public static void main(String[] args) {
        IAlgorithm runner=new DFS1();
        runner.run(new Graph(GraphConstructor.data));
        ProbeRecorder.print();
    }
}
