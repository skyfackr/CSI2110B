package assignment.a9;


import java.util.List;
import java.util.stream.Collectors;

public class Vertices implements IGraph.IVertices {
    @Override
    public String getName() {
        return String.valueOf(this.getID());
    }
    private final int id;
    private final IGraph graph;

    public Vertices(int id, IGraph graph) {
        this.id = id;
        this.graph = graph;
        this.label=Label.NONE;
    }

    @Override
    public int getID() {
        return id;
    }



    @Override
    public List<IGraph.IEdges> getConnectedEdges() {
        return List.copyOf(graph.getEdges().stream().filter((e)-> e.getFrom()==this).toList());
    }
    private Label label;

    @Override
    public Label getLabel() {
        return label;
    }

    @Override
    public void setLabel(Label label) {
        this.label=label;
        probe();
    }

    @Override
    public void probe() {
        ProbeRecorder.record(this);
    }
}
