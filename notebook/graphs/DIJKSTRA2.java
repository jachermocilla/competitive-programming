//http://www.baeldung.com/java-dijkstra
import java.util.*;

class Vertex{
   public String name;
   public List<Vertex> sp=new LinkedList<>();
   public Integer d = Integer.MAX_VALUE;
   public Map<Vertex,Integer> adj = new HashMap<>();
   
   public void addAdj(Vertex v, int d){
      adj.put(v,d);
   }

   public Vertex(String name){
      this.name=name;
   } 
   
}


class Graph{
   public Set<Vertex> V=new HashSet<>();

   public void addVertex(Vertex v){
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



public class DIJKSTRA2{

   public static void main(String args[]){
      Vertex nodeA = new Vertex("A");
      Vertex nodeB = new Vertex("B");
      Vertex nodeC = new Vertex("C");
      Vertex nodeD = new Vertex("D"); 
      Vertex nodeE = new Vertex("E");
      Vertex nodeF = new Vertex("F");
      nodeA.addAdj(nodeB, 10);


      nodeA.addAdj(nodeC, 15);
    
      nodeB.addAdj(nodeD, 12);
      nodeB.addAdj(nodeF, 15);
    
      nodeC.addAdj(nodeE, 10);
    
      nodeD.addAdj(nodeE, 2);
      nodeD.addAdj(nodeF, 1);
    
      nodeF.addAdj(nodeE, 5);
    
      Graph graph = new Graph();
    
      graph.addVertex(nodeA);
      graph.addVertex(nodeB);
      graph.addVertex(nodeC);
      graph.addVertex(nodeD);
      graph.addVertex(nodeE);
      graph.addVertex(nodeF);
    
      graph.dijkstra(nodeA);

      for (Vertex v:graph.V){
         System.out.println(v.name+":"+v.d);
      } 
   }
}
