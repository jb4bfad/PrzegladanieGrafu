import java.util.*;

abstract class PrzegladanieGrafu {
    abstract void wstaw(Wierzcholek wierzcholek);
    abstract void pobierz(Wierzcholek wierzcholek);

    public Wierzcholek wstartowy;
    public LinkedList wlista=new LinkedList();
    public int[][] macierz;
    int size;
    public void setstartowy(Wierzcholek n)
    {
        this.wstartowy=n;
    }

    public Wierzcholek getRootNode()
    {
        return this.wstartowy;
    }

    public void dodajw(Wierzcholek n)
    {
        wlista.add(n);
    }

    //This method will be called to make connect two wlista
    public void connectNode(Wierzcholek start,Wierzcholek end)
    {
        if(macierz==null)
        {
            size=wlista.size();
            macierz=new int[size][size];
        }

        int startIndex=wlista.indexOf(start);
        int endIndex=wlista.indexOf(end);
        macierz[startIndex][endIndex]=1;
        macierz[endIndex][startIndex]=1;
    }

    public Wierzcholek getUnvisitedChildNode(Wierzcholek n, LinkedList wlista, int[][] macierz, int size)
    {

        int index=wlista.indexOf(n);
        int j=0;
        //System.out.println("\n["+size);
        while(j<size)
        {
            //if(((Wierzcholek)wlista.get(j)).visited==false) System.out.println("["+index+ "]");
            if(macierz[index][j]==1 && ((Wierzcholek)wlista.get(j)).visited==false)
            {
                return (Wierzcholek)wlista.get(j);
            }
            j++;
        }
        return null;
    }

    //BFS traversal of a tree is performed by the bfs() function
    public void bfs()
    {
        Bfs d= new Bfs(wstartowy, wlista, macierz,size);
        wyczysc();
    }

    //DFS traversal of a tree is performed by the dfs() function
    public void dfs()
    {
        Dfs d= new Dfs(wstartowy, wlista, macierz,size);
        wyczysc();
    }


    //Utility methods for clearing visited property of Wierzcholek
    public void wyczysc()
    {
        int i=0;
        while(i<size)
        {
            Wierzcholek n=(Wierzcholek)wlista.get(i);
            n.visited=false;
            i++;
        }
    }

    //Utility methods for printing the Wierzcholek's label
    public void drukuj(Wierzcholek n)
    {
        System.out.print(n.wartosc+" ");
    }
}