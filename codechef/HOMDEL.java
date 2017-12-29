//TODO:https://www.codechef.com/problems/HOMDEL
//Status: TLE
//https://www.codechef.com/status/HOMDEL,jachermocilla


import java.util.*;
import java.io.*;

class Vertex{
   public String name;
   public List<Vertex> sp=new LinkedList<>();
   public Integer d = Integer.MAX_VALUE;
   public Map<Vertex,Integer> adj = new HashMap<>();

   public Vertex(Vertex v){
      this.name=v.name;
      this.sp=v.sp;
      this.d=v.d;
      this.adj.putAll(v.adj);
   }
   
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

   public Graph(Graph g){
      this.V.addAll(g.V);
   }

   public Graph(){}


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

   public void printSP(){
      for (Vertex v:V){
         System.out.println(v.name+":"+v.d);
         for (Vertex a: v.sp){
            System.out.print(a.name+"->");
         }
         System.out.println(v.name);
      } 
   }

}


class HOMDEL{

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

      List<String> lines=new ArrayList<String>();
      for (int i=0;i<N;i++){
         line=bi.readLine();
         lines.add(line);
         int j=0;
         for (String numStr: line.split("\\s")){
            V[i].add(V[j],Integer.parseInt(numStr));
            j++;
         } 
      }
     
      M = Integer.parseInt(bi.readLine());
      for (int i=0;i<M;i++){
         line=bi.readLine();
         int j=0;
         for (String numStr: line.split("\\s")){
            SGD[j]=Integer.parseInt(numStr);
            j++;
         }

         int t=0;

         String arr[]=lines.toArray(new String[lines.size()]);

//--------------------------
         Graph g2=new Graph();
         Vertex V2[]=new Vertex[N];       
         for (int i2=0;i2<N;i2++){
            V2[i2]=new Vertex(i2+"");
            g2.add(V2[i2]);
         }
         for (int i2=0;i2<N;i2++){
            int j2=0;
            for (String numStr: arr[i2].split("\\s")){
               V2[i2].add(V2[j2],Integer.parseInt(numStr));
               j2++;
            } 
         }

         g2.dijkstra(V2[SGD[0]]);
         for (Vertex v:g2.V){
            if (v.equals(V2[SGD[1]])){
               t+=v.d;
            }
         }
//--------------------------
         Graph g3=new Graph();
         Vertex V3[]=new Vertex[N];       
         for (int i3=0;i3<N;i3++){
            V3[i3]=new Vertex(i3+"");
            g3.add(V3[i3]);
         }
         for (int i3=0;i3<N;i3++){
            int j3=0;
            for (String numStr: arr[i3].split("\\s")){
               V3[i3].add(V3[j3],Integer.parseInt(numStr));
               j3++;
            } 
         }
         g3.dijkstra(V3[SGD[1]]);
         for (Vertex v:g3.V){
            if (v.equals(V3[SGD[2]])){
               t+=v.d;
            }
         }
//--------------------------
         int x=0;
         Graph g4=new Graph();
         Vertex V4[]=new Vertex[N];       
         for (int i4=0;i4<N;i4++){
            V4[i4]=new Vertex(i4+"");
            g4.add(V4[i4]);
         }
         for (int i4=0;i4<N;i4++){
            int j4=0;
            for (String numStr: arr[i4].split("\\s")){
               V4[i4].add(V4[j4],Integer.parseInt(numStr));
               j4++;
            } 
         }
         g4.dijkstra(V4[SGD[0]]);
         for (Vertex v:g4.V){
            if (v.equals(V4[SGD[2]])){
               x=v.d;
            }
         }
         System.out.println(t+" "+(t-x));
      }

      final long endTime = System.currentTimeMillis();
//      System.out.println("Total execution time: " + (endTime - startTime)+" ms" );
   }
}
