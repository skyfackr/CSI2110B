package assignment.a9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph implements IGraph{
    private final Map<Integer,IVertices> vertices;
    private final List<IEdges> edges;
    @Override
    public List<IVertices> getVertices() {
        return List.copyOf(vertices.values());
    }

    @Override
    public List<IEdges> getEdges() {
        return edges;
    }
    public Graph(List<List<Integer>> data)
    {
        this.vertices=new HashMap<>();
        this.edges=new ArrayList<>();
        for (List<Integer> unit:data)
        {
            int from=unit.get(0);
            int to=unit.get(1);
            IVertices fromV=getOrCreateVertex(from);
            IVertices toV=getOrCreateVertex(to);
            createEdge(fromV,toV);
            createEdge(toV,fromV);
        }
    }

    private void createEdge(IVertices from, IVertices to)
    {
        if (this.getEdges().stream().noneMatch((e)-> e.getFrom()==from&&e.getTo()==to))
            this.edges.add(new Edges(from,to,this));
    }

    private IVertices getOrCreateVertex(int id)
    {
        if (!vertices.containsKey(id))
            vertices.put(id,new Vertices(id,this));
        return this.getVertex(id);
    }

    @Override
    public IVertices getVertex(int id) {
        return vertices.get(id);
    }
}
