package assignment.a9;

import java.util.ArrayList;
import java.util.List;

public class ProbeRecorder {
    private static class ProbeUnit
    {
        String name;
        enum ProbeType
        {
            Vertex,
            Edge
        }
        ProbeType type;
        Label label;

        public ProbeUnit(String name, ProbeType type, Label label) {
            this.name = name;
            this.type = type;
            this.label = label;
        }
    }
    private static final List<ProbeUnit> recorder=new ArrayList<>();
    public static void record(IGraph.ILabel obj)
    {
        recorder.add(new ProbeUnit(obj.getName(),obj instanceof IGraph.IVertices?ProbeUnit.ProbeType.Vertex:ProbeUnit.ProbeType.Edge,obj.getLabel()));
    }
    public static void print() {
        System.out.println("总共记录了%d条探测记录".formatted(recorder.size()));
        recorder.forEach((u)->{
            System.out.println("探测到%s %s的标签为%s".formatted(u.type,u.name,u.label));
        });
    }
}
