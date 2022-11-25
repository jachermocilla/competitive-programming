import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFS{
   private int n;
   private LinkedList<Integer> adj[];

   public DFS(int n){
      this.n = n;
      adj = new LinkedList[n];
      for (int i=0;i<n;i++){
         adj[i] = new LinkedList<Integer>();
      } 
   }
   
   public void addEdge(int u, int v){
      adj[u].add(v);
   }

   public void _dfs(int s){
      boolean visited[]=new boolean[n];
      
      Stack<Integer> stk = new Stack<Integer>();

      visited[s]=true;
      stk.push(s);
   
      while (stk.size() != 0){
         s = stk.pop();
         System.out.println(s + " ");

         Iterator<Integer> ite = adj[s].listIterator();
         while (ite.hasNext()){
           int n=ite.next();

            if (!visited[n]){
               visited[n]=true;
               stk.push(n);
            }  
         }  
      } 
   }

   public static void main(String args[]){
      DFS g = new DFS(4);

      g.addEdge(0, 1);
      g.addEdge(0, 2);
      g.addEdge(1, 2);
      g.addEdge(2, 0);
      g.addEdge(2, 3);
      g.addEdge(3, 3);

      System.out.println("Following is Breadth First Traversal (starting from vertex 0): ");
      g._dfs(2);
   }


}
