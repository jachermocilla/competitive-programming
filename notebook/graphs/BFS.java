import java.util.Iterator;
import java.util.LinkedList;

public class BFS{
   private int n;
   private LinkedList<Integer> adj[];

   public BFS(int n){
      this.n = n;
      adj = new LinkedList[n];
      for (int i=0;i<n;i++){
         adj[i] = new LinkedList<Integer>();
      } 
   }
   
   public void addEdge(int u, int v){
      adj[u].add(v);
   }

   public void _bfs(int s){
      boolean visited[]=new boolean[n];
      
      LinkedList<Integer> q = new LinkedList<Integer>();

      visited[s]=true;
      q.add(s);
   
      while (q.size() != 0){
         s = q.poll();
         System.out.println(s + " ");

         Iterator<Integer> ite = adj[s].listIterator();
         while (ite.hasNext()){
           int n=ite.next();

            if (!visited[n]){
               visited[n]=true;
               q.add(n);
            }  
         }  
      } 
   }

   public static void main(String args[]){
      BFS g = new BFS(9);

      g.addEdge(0, 1);
      g.addEdge(0, 2);
      g.addEdge(1, 2);
      g.addEdge(2, 0);
      g.addEdge(2, 3);
      g.addEdge(3, 3);

      System.out.println("Following is Breadth First Traversal (starting from vertex 0): ");
      g._bfs(2);
   }


}
