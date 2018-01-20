public class GrafyUzytkownik extends PrzegladanieGrafu  {


    public static void main(String[] args){
        Wierzcholek nA=new Wierzcholek(1);
        Wierzcholek nB=new Wierzcholek(2);
        Wierzcholek nC=new Wierzcholek(3);
        Wierzcholek nD=new Wierzcholek(4);
        Wierzcholek nE=new Wierzcholek(5);
        Wierzcholek nF=new Wierzcholek(6);



        //Create the graph, add nodes, create edges between nodes
        PrzegladanieGrafu g=new PrzegladanieGrafu() {
            public void wstaw(){};
            public void pobierz(){};
        };
        g.addNode(nA);
        g.addNode(nB);
        g.addNode(nC);
        g.addNode(nD);
        g.addNode(nE);
        g.addNode(nF);
        g.setRootNode(nA);

        g.connectNode(nA,nB);
        g.connectNode(nA,nC);
        g.connectNode(nA,nD);

        g.connectNode(nB,nE);
        g.connectNode(nB,nF);
        g.connectNode(nC,nF);


        //Perform the traversal of the graph
        System.out.println("DFS Traversal of a tree is ------------->");
        g.dfs();
        System.out.println("\nBFS Traversal of a tree is ------------->");
        g.bfs();

    }
}
