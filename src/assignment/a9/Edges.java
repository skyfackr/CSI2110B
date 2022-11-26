package assignment.a9;

public class Edges implements IGraph.IEdges {
    private final IGraph.IVertices from,to;
    @Override
    public IGraph.IVertices getFrom() {
        return from;
    }

    @Override
    public IGraph.IVertices getTo() {
        return to;
    }

    @Override
    public IGraph.IEdges opposite() {
        return graph.getEdges().stream().filter((e)-> e.getFrom()==this.getTo()&&e.getTo()==this.getFrom()).findFirst().orElseThrow();
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

    private final IGraph graph;

    public Edges(IGraph.IVertices from, IGraph.IVertices to, IGraph graph) {
        this.from = from;
        this.label=Label.NONE;
        this.to = to;
        this.graph = graph;
    }

    @Override
    public String getName() {
        return String.format("(%s , %s)",from.getName(),to.getName());
    }
}
