package assignment.a9;

public class Worker {
    public static void main(String[] args) {
        IAlgorithm runner=new BFS1();
        runner.run(new Graph(GraphConstructor.reverse(GraphConstructor.data)));
        ProbeRecorder.print();
    }
}
