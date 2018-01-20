
import java.util.*;

abstract class PrzegladanieGrafu {
  //  abstract void wstaw();
//    abstract void pobierz();

    public Wierzcholek rootNode;
    public LinkedList nodes=new LinkedList();
    public int[][] adjMatrix;//Edges will be represented as adjacency Matrix
    int size;
    public void setRootNode(Wierzcholek n)
    {
        this.rootNode=n;
    }

    public Wierzcholek getRootNode()
    {
        return this.rootNode;
    }

    public void addNode(Wierzcholek n)
    {
        nodes.add(n);
    }

    //This method will be called to make connect two nodes
    public void connectNode(Wierzcholek start,Wierzcholek end)
    {
        if(adjMatrix==null)
        {
            size=nodes.size();
            adjMatrix=new int[size][size];
        }

        int startIndex=nodes.indexOf(start);
        int endIndex=nodes.indexOf(end);
        adjMatrix[startIndex][endIndex]=1;
        adjMatrix[endIndex][startIndex]=1;
    }

    public Wierzcholek getUnvisitedChildNode(Wierzcholek n, LinkedList nodes, int[][] adjMatrix, int size)
    {

        int index=nodes.indexOf(n);
        int j=0;
        //System.out.println("\n["+size);
        while(j<size)
        {
            //if(((Wierzcholek)nodes.get(j)).visited==false) System.out.println("["+index+ "]");
            if(adjMatrix[index][j]==1 && ((Wierzcholek)nodes.get(j)).visited==false)
            {
                return (Wierzcholek)nodes.get(j);
            }
            j++;
        }
        return null;
    }

    //BFS traversal of a tree is performed by the bfs() function
    public void bfs()
    {
        Bfs d= new Bfs(rootNode, nodes, adjMatrix,size);
        clearNodes();
    }

    //DFS traversal of a tree is performed by the dfs() function
    public void dfs()
    {
        Dfs d= new Dfs(rootNode, nodes, adjMatrix,size);
        clearNodes();
    }


    //Utility methods for clearing visited property of Wierzcholek
    public void clearNodes()
    {
        int i=0;
        while(i<size)
        {
            Wierzcholek n=(Wierzcholek)nodes.get(i);
            n.visited=false;
            i++;
        }
    }

    //Utility methods for printing the Wierzcholek's label
    public void printNode(Wierzcholek n)
    {
        System.out.print(n.label+" ");
    }
}