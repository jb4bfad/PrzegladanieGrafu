import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class GrafyUzytkownik  {
       public static void main(String[] args){
        Wierzcholek [] w;

    PrzegladanieGrafu g=new PrzegladanieGrafu() {
            public void wstaw(Wierzcholek wierzcholek) {};
            public void pobierz(Wierzcholek wierzcholek){};
    };

        int x = 0, y = 0, wierzcholki = 0, krawedzie = 0;
        Double d;
        FileReader fr= null;

        try {
            fr = new FileReader("plik.txt");
        } catch (FileNotFoundException e) {
            System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
            System.exit(1);
        }

        StreamTokenizer st = new StreamTokenizer(fr);
        try {
            wierzcholki = st.nextToken();
            d = st.nval;
            wierzcholki = d.intValue();
            krawedzie = st.nextToken();
            d = st.nval;
            krawedzie = d.intValue();

           w = new Wierzcholek[wierzcholki];
            for(int i=0; i<krawedzie; i++)
            {
                w[i]= new Wierzcholek(i+1);
                g.addNode(w[i]);
            }
            g.setRootNode(w[0]);

            for(int i=0; i<krawedzie; i++)
            {
                x = st.nextToken();
                d = st.nval;
                x = d.intValue();
                y = st.nextToken();
                d = st.nval;
                y = d.intValue();
                System.out.println("x "+x+" y "+y);
                g.connectNode(w[x-1], w[y-1]);
            }
        } catch (IOException e) {
            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
            System.exit(2);
        }

        //ZAMYKANIE PLIKU:
        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
            System.exit(3);
        }
        System.out.println("Przebieg algorytmu DFS");
        g.dfs();
        System.out.println("\nPrzebieg algorytmu BFS");
        g.bfs();

    }

}
