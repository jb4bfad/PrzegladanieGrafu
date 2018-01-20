import java.util.LinkedList;

public class Bfs extends PrzegladanieGrafu{
    public  Bfs(Wierzcholek rootNode, LinkedList nodes, int[][] adjMatrix, int size)
    {
        LinkedList q=new LinkedList();
        q.add(rootNode);
        printNode(rootNode);
        rootNode.visited=true;
        while(!q.isEmpty())
        {
            Wierzcholek n=(Wierzcholek)q.remove();
            Wierzcholek child=null;

            while((child=getUnvisitedChildNode(n, nodes,adjMatrix,size))!=null)
            {
                child.visited=true;
                printNode(child);
                q.add(child);
            }
        }
    }
}
