import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;





public class DIJKSTRA{
   private int n;
   private LinkedList<V> adj[];
   
   //adj node
   class V{
      int v; //node id
      int w; //weight
         
      public V(int v, int w){
         this.v=v;
         this.w=w;
      }
   }

   public DIJKSTRA(int n){
      this.n = n;
      adj = new LinkedList[n];
      for (int i=0;i<n;i++){
         adj[i] = new LinkedList<V>();
      } 
   }
   
   public void addEdge(int u, int v, int w){
      V x = new V(v,w);
      V y = new V(u,w);
      adj[u].add(x);
      adj[v].add(y);
   }

   public void _dijkstra(int s){
   }

   public void print(){
      for (int i=0;i<n;i++){
         Iterator ite = adj[i].listIterator();
         System.out.print(i+":");
         while(ite.hasNext()){
            V v = (V)ite.next();
            System.out.print("("+v.v+","+v.w+") ");
         }
         System.out.println();
      }
   }


   public static void main(String args[]){
      DIJKSTRA g = new DIJKSTRA(9);

      g.addEdge(0, 1, 4);
      g.addEdge(0, 7, 8);
      g.addEdge(1, 7, 11);
      g.addEdge(1, 2, 8);
      g.addEdge(7, 8, 7);
      g.addEdge(7, 6, 1);
      g.addEdge(8, 2, 2);
      g.addEdge(8, 6, 6);
      g.addEdge(6, 5, 2);
      g.addEdge(2, 5, 4);
      g.addEdge(2, 3, 7);
      g.addEdge(3, 5, 14);
      g.addEdge(3, 4, 9);
      g.addEdge(5, 4, 10);

      g.print();
      g._dijkstra(2);
   }


}
