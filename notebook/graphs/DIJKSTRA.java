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
 
      Set<Vertex> settledNodes = new HashSet<>();
      Set<Vertex> unsettledNodes = new HashSet<>();
 
      unsettledNodes.add(source);
 
      while (unsettledNodes.size() != 0) {
         Vertex currentNode = getLowestDistanceNode(unsettledNodes);
         unsettledNodes.remove(currentNode);
         for (Map.Entry < Vertex, Integer> adjacencyPair: 
            currentNode.adj.entrySet()) {
               Vertex adjacentNode = adjacencyPair.getKey();
               Integer edgeWeight = adjacencyPair.getValue();
               if (!settledNodes.contains(adjacentNode)) {
                  calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                  unsettledNodes.add(adjacentNode);
               }
         }
         settledNodes.add(currentNode);
      }
   }

   private Vertex getLowestDistanceNode(Set < Vertex > unsettledNodes) {
       Vertex lowestDistanceNode = null;
       int lowestDistance = Integer.MAX_VALUE;
       for (Vertex v: unsettledNodes) {
           int nodeDistance = v.d;
           if (nodeDistance < lowestDistance) {
               lowestDistance = nodeDistance;
               lowestDistanceNode = v;
           }
       }
       return lowestDistanceNode;
   }

   private static void calculateMinimumDistance(Vertex evaluationNode,Integer edgeWeigh, Vertex sourceNode) {
      Integer sourceDistance = sourceNode.d;
      if (sourceDistance + edgeWeigh < evaluationNode.d) {
         evaluationNode.d=sourceDistance + edgeWeigh;
         LinkedList<Vertex> shortestPath = new LinkedList<>(sourceNode.sp);
         shortestPath.add(sourceNode);
         evaluationNode.sp=shortestPath;
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
