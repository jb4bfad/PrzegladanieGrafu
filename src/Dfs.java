import java.util.LinkedList;

public class Dfs extends PrzegladanieGrafu{
    LinkedList s = new LinkedList();
    void pobierz(Wierzcholek wierzcholek)
    {
        drukuj(wierzcholek);
    }
    void wstaw(Wierzcholek wierzcholek)
    {
        s.add(wierzcholek);
    }
    public  Dfs(Wierzcholek wstartowy, LinkedList wlista, int[][] macierz, int size) {

        wstaw(wstartowy);
        wstartowy.visited = true;
        pobierz(wstartowy);
        while (!s.isEmpty()) {
            Wierzcholek n = (Wierzcholek) s.peekLast();
            Wierzcholek nast =  getUnvisitedChildNode(n, wlista, macierz, size);

            if (nast != null) {
                nast.visited = true;
                pobierz(nast);
                wstaw(nast);
            } else {
                s.removeLast();
            }
        }
    }
}
