package assignment.a9;

import java.util.*;

public class GraphConstructor {
    /*
    0: (0,1), (0,3), (0,4)
1: (1,0), (1,2), (1,3), (1,6), (1,7)
2: (2,1), (2,6), (2,7)
3: (3,0), (3,1), (3,5)
4: (4,0), (4,5)
5: (5,3), (5,4), (5,6), (5,8)
6: (6,1), (6,2), (6,5), (6,7), (6,9)
7: (7,1), (7,2), (7,6), (7,9)
8: (8,5), (8,9)
9: (9,6), (9,7), (9,8)

     */
    public static List<List<Integer>> data=List.of(
            List.of(0,1), List.of(0,3), List.of(0,4),
            List.of(1,0),List.of(1,2),List.of(1,3),List.of(1,6),List.of(1,7),
            List.of(2,1),List.of(2,6),List.of(2,7),
            List.of(3,0),List.of(3,1),List.of(3,5),
            List.of(4,0),List.of(4,5),
            List.of(5,3),List.of(5,4),List.of(5,6),List.of(5,8),
            List.of(6,1),List.of(6,2),List.of(6,5),List.of(6,7),List.of(6,9),
            List.of(7,1),List.of(7,2),List.of(7,6),List.of(7,9),
            List.of(8,5),List.of(8,9),
            List.of(9,6),List.of(9,7),List.of(9,8)
    );
    public static List<List<Integer>> reverse(List<List<Integer>> data)
    {
        List<List<Integer>> result=new ArrayList<>();
        Map<Integer, Stack<List<Integer>>> stackMap = new HashMap<>();
        for (List<Integer> unit:data)
        {
            int from=unit.get(0);
            int to=unit.get(1);
            if (!stackMap.containsKey(from))
                stackMap.put(from,new Stack<>());
            stackMap.get(from).push(unit);
        }
        while(!stackMap.isEmpty()) {
            int index= stackMap.keySet().stream().min(Integer::compareTo).get();
            Stack<List<Integer>> stack=stackMap.get(index);
            stackMap.remove(index);
            while (!stack.isEmpty())
            {
                result.add(stack.pop());
            }

        }
        return result;

    }
}
