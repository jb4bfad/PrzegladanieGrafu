import java.util.LinkedList;

public class Dfs extends PrzegladanieGrafu{
    public  Dfs(Wierzcholek rootNode, LinkedList nodes, int[][] adjMatrix, int size) {
        LinkedList s = new LinkedList();
        s.add(rootNode);
        rootNode.visited = true;
        printNode(rootNode);
        while (!s.isEmpty()) {

            Wierzcholek n = (Wierzcholek) s.peekLast();

            Wierzcholek child =  getUnvisitedChildNode(n, nodes, adjMatrix, size);

            if (child != null) {

                child.visited = true;
                printNode(child);
                s.add(child);
            } else {
                s.removeLast();
            }
        }
        //Clear visited property of nodes

    }
}