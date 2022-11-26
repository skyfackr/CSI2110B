package assignment.a9;

import java.util.List;

/**
 * a graph
 */
public interface IGraph {
    public interface IVertices extends ILabel {

        public int getID();
        public List<IEdges> getConnectedEdges();
    }
    public interface IEdges extends ILabel{
        public IVertices getFrom();
        public IVertices getTo();
        public IEdges opposite();

    }
    public interface ILabel{
        Label getLabel();
        void setLabel(Label label);
        void probe();
        String getName();
    }
    public List<IVertices> getVertices();
    public List<IEdges> getEdges();
    IVertices getVertex(int id);
}
