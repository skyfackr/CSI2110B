package assignment.a9;

import java.util.Stack;

public class DFS2 implements IAlgorithm{
    private final Stack<IGraph.IVertices> stack=new Stack<>();
    @Override
    public void run(IGraph graph) {
        for (IGraph.IVertices vertices:graph.getVertices())
            vertices.setLabel(Label.UNEXPLORED);
        for (IGraph.IEdges e:graph.getEdges())
            e.setLabel(Label.UNEXPLORED);
        for (IGraph.IVertices v:graph.getVertices())
            if (v.getLabel()==Label.UNEXPLORED)
                stack.push(v);
        while (!stack.isEmpty())
            dfs(graph,stack.pop());
    }
    private void dfs(IGraph graph, IGraph.IVertices vertex)
    {
        vertex.setLabel(Label.VISITED);
        for (IGraph.IEdges e:vertex.getConnectedEdges())
        {
            if (e.getLabel()==Label.UNEXPLORED)
            {
                IGraph.IVertices w=e.getTo();
                if (w.getLabel()==Label.UNEXPLORED)
                {
                    e.setLabel(Label.DISCOVERY);
                    stack.push(w);
                }
                else
                    e.setLabel(Label.BACK);
            }
        }
    }
}
