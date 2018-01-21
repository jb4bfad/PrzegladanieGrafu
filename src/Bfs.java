import java.util.LinkedList;

public class Bfs extends PrzegladanieGrafu{
    LinkedList q=new LinkedList();
    void pobierz(Wierzcholek wierzcholek)
    {
        drukuj(wierzcholek);
    }
    void wstaw(Wierzcholek wierzcholek)
    {
        q.add(wierzcholek);
    }
    public  Bfs(Wierzcholek wstartowy, LinkedList nodes, int[][] macierz, int size)
    {

        wstaw(wstartowy);
        pobierz(wstartowy);
        wstartowy.visited=true;
        while(!q.isEmpty())
        {
            Wierzcholek n=(Wierzcholek)q.remove();
            Wierzcholek nast=null;

            while((nast=getUnvisitedChildNode(n, nodes,macierz,size))!=null)
            {
                nast.visited=true;
                pobierz(nast);
                wstaw(nast);
            }
        }
    }
}
