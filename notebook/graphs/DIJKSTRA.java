//http://www.baeldung.com/java-dijkstra
//https://www.geeksforgeeks.org/greedy-algorithms-set-7-dijkstras-algorithm-for-adjacency-list-representation/

import java.util.*;

class Vertex{
   public String name;
   public List<Vertex> sp=new LinkedList<>();
   public Integer d = Integer.MAX_VALUE;
   public Map<Vertex,Integer> adj = new HashMap<>();
   
   public void add(Vertex v, int d){
      adj.put(v,d);
   }

   public Vertex(String name){
      this.name=name;
   } 
}


class Graph{
   public Set<Vertex> V=new HashSet<>();

   public void add(Vertex v){
      V.add(v);
   }

   public void dijkstra(Vertex source) {
      source.d=0;
 
      Set<Vertex> done = new HashSet<>();
      Set<Vertex> notDone = new HashSet<>(); //a priority queue may be better
 
      notDone.add(source);
 
      while (notDone.size() != 0) {
         Vertex u = getMinV(notDone);
         notDone.remove(u);
         for (Map.Entry <Vertex, Integer> pair:u.adj.entrySet()) {
            Vertex v = pair.getKey();
            Integer w = pair.getValue();
            if (!done.contains(v)) {
               calculateMinimumDistance(v, w, u);
               notDone.add(v);
            }
         }
         done.add(u);
      }
   }

   private Vertex getMinV(Set<Vertex> notDone) {
       Vertex min = null;
       int d = Integer.MAX_VALUE;
       for (Vertex v: notDone) {
           if (v.d < d) {
               d = v.d;
               min = v;
           }
       }
       return min;
   }

   private void calculateMinimumDistance(Vertex v,Integer w, Vertex u) {
      if (u.d + w < v.d) {
         v.d = u.d + w;
         LinkedList<Vertex> sp = new LinkedList<>(u.sp);
         sp.add(u);
         v.sp=sp;
      }
   }
}



public class DIJKSTRA{

   public static void main(String args[]){

      Vertex n0 = new Vertex("0");
      Vertex n1 = new Vertex("1");
      Vertex n2 = new Vertex("2");
      Vertex n3 = new Vertex("3"); 
      Vertex n4 = new Vertex("4");
      Vertex n5 = new Vertex("5");
      Vertex n6 = new Vertex("6");
      Vertex n7 = new Vertex("7");
      Vertex n8 = new Vertex("8");
   
      n0.add(n1,4);
      n0.add(n7,8);

      n1.add(n2,8);
      n1.add(n7,11);

      n2.add(n1,8);
      n2.add(n3,7);
      n2.add(n8,2);

      n3.add(n2,7);
      n3.add(n4,9);
      n3.add(n5,14);

      n4.add(n3,9);
      n4.add(n5,10);

      n5.add(n2,4);
      n5.add(n3,14);
      n5.add(n4,10);
      n5.add(n6,2);

      n6.add(n5,2);
      n6.add(n7,1);
      n6.add(n8,6);
      
      n7.add(n0,8);
      n7.add(n1,11);
      n7.add(n6,1);
      n7.add(n8,7);

      n8.add(n2,2);
      n8.add(n6,6);
      n8.add(n7,7);

      Graph g=new Graph();
      g.add(n0);
      g.add(n1);
      g.add(n2);
      g.add(n3);
      g.add(n4);
      g.add(n5);
      g.add(n6);
      g.add(n7);
      g.add(n8);

 
      g.dijkstra(n0);

      for (Vertex v:g.V){
         System.out.println(v.name+":"+v.d);
      } 
   }
}
