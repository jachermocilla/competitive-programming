//TODO:https://www.codechef.com/problems/HOMDEL
//Status: UNSOLVED

import java.util.*;
import java.io.*;

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
   
   public String toString(){
      return name;
   } 
}


class Graph{
   public Set<Vertex> V=new HashSet<>();

   public void add(Vertex v){
      V.add(v);
   }


   public void print(){
      for (Vertex u: V){
         System.out.print(u+":");
         for (Map.Entry<Vertex, Integer> pair: u.adj.entrySet()) {
            Vertex v = pair.getKey();
            Integer d = pair.getValue();
            System.out.print("("+v+","+d+")");
         }
         System.out.println();
      }
   }

   public void dijkstra(Vertex source) {
      source.d=0;
      
      Set<Vertex> done = new HashSet<>();
      Queue<Vertex> notDone = new PriorityQueue<>(
                              100000,
                              new Comparator<Vertex>(){
                                 public int compare(Vertex v1, Vertex v2){
                                    return (v1.d-v2.d);
                                 }
                              }
                           ); 
 
      notDone.add(source);
      while (notDone.size() != 0) {
         Vertex u = notDone.poll();
         for (Map.Entry<Vertex, Integer> pair: u.adj.entrySet()) {
            Vertex v = pair.getKey();
            Integer d = pair.getValue();
            if (!done.contains(v)) {
               if (u.d + d < v.d) {
                  v.d = u.d + d;
                  LinkedList<Vertex> sp = new LinkedList<>(u.sp);
                  sp.add(u);
                  v.sp=sp;
               }
               notDone.add(v);
            }
         }
         done.add(u);
      }
   }

}


public class HOMDEL{
   public static void main(String args[]) throws IOException{
      
      final long startTime = System.currentTimeMillis();
      Graph g=new Graph();

      int N,M,SGD[]=new int[3];

      BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
      String line;

      N = Integer.parseInt(bi.readLine());
      Vertex V[]=new Vertex[N];       
      for (int i=0;i<N;i++){
         V[i]=new Vertex(i+"");
         g.add(V[i]);
      }

      System.out.println(N);
      for (int i=0;i<N;i++){
         line=bi.readLine();
         int j=0;
         for (String numStr: line.split("\\s")){
            V[i].add(V[j],Integer.parseInt(numStr));
            j++;
         } 
      }
  
      g.print(); 
      
      M = Integer.parseInt(bi.readLine());
      System.out.println(M);
      for (int i=0;i<M;i++){
         line=bi.readLine();
         int j=0;
         for (String numStr: line.split("\\s")){
            SGD[j++]=Integer.parseInt(numStr);
         }
         g.dijkstra(V[SGD[0]]);
         for (Vertex v:g.V){
            if (v.equals(V[SGD[1]]))
               System.out.println(v.d);
         }
      }


      final long endTime = System.currentTimeMillis();
      System.out.println("Total execution time: " + (endTime - startTime)+" ms" );

      for (Vertex v:g.V){
         System.out.println(v.name+":"+v.d);
         for (Vertex a: v.sp){
            System.out.print(a.name+"->");
         }
         System.out.println(v.name);
      } 
   }
}
