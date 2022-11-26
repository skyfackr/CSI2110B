package assignment.a9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BFS1 implements  IAlgorithm{
    @Override
    public void run(IGraph graph) {
        for (IGraph.IVertices vertices:graph.getVertices())
            vertices.setLabel(Label.UNEXPLORED);
        for (IGraph.IEdges e:graph.getEdges())
            e.setLabel(Label.UNEXPLORED);
        for (IGraph.IVertices v:graph.getVertices())
            if (v.getLabel()==Label.UNEXPLORED)
                bfs(graph,v);

    }
    private void bfs(IGraph graph, IGraph.IVertices vertex)
    {
        List<List<IGraph.IVertices>> l=new ArrayList<>();
        int index=0;
        l.add(new ArrayList<>());
        vertex.setLabel(Label.VISITED);
        l.get(index).add(vertex);
        while (!l.get(index).isEmpty()) {
            System.out.println("开始访问第%d层：[%s]".formatted(index, l.get(index).stream().map(IGraph.IVertices::getName).collect(Collectors.joining(","))));
            l.add(new ArrayList<>());
            for (IGraph.IVertices v : l.get(index))
            {
                for (IGraph.IEdges e : v.getConnectedEdges()) {
                    if (e.getLabel() == Label.UNEXPLORED) {
                        IGraph.IVertices w = e.getTo();
                        if (w.getLabel() == Label.UNEXPLORED) {
                            e.setLabel(Label.DISCOVERY);
                            w.setLabel(Label.VISITED);
                            l.get(index+1).add(w);
                        } else
                            e.setLabel(Label.CROSS);
                    }
                }
            }
            index++;
        }
    }
}
