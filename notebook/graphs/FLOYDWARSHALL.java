// A Java program for Floyd Warshall All Pairs Shortest
// Path algorithm.
//https://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-algorithm/

import java.util.*;
import java.lang.*;
import java.io.*;
 
 
class FLOYDWARSHALL
{
   final static int INF = 99999; 
   int n;
   int g[][];
   int d[][];

   public FLOYDWARSHALL(int n){
      this.n=n;
      g = new int[n][n];
      d = new int[n][n];
      for (int i = 0; i < n; i++){
         for (int j = 0; j < n; j++){
            g[i][j]=INF;
            d[i][j]=INF;
         }
      }
   }

   public FLOYDWARSHALL(int g[][]){
      this(g[0].length);
      for (int u=0;u<4;u++){
         for (int v=0;v<4;v++){
            this.add(u,v,g[u][v]);
         }
      }
   }

   public void add(int u,int v, int w){
      g[u][v]=w;
      d[u][v]=w; 
   }


   public void floydWarshall(){
      for (int k = 0; k < n; k++){
         for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
               if (d[i][k] + d[k][j] < d[i][j]){
                  d[i][j] = d[i][k] + d[k][j];
               }
            }
         }
      }
   }
 
   
   public int getSP(int u,int v){
      return d[u][v];
   }

   public void printSolution(){
      for (int i=0; i<n; ++i){
         for (int j=0; j<n; ++j){
                if (d[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(d[i][j]+"   ");
         }
         System.out.println();
      }
   }
   // Driver program to test above function
   public static void main (String[] args){
      int graph[][] =   { {0,   5,  INF, 10},
                        {INF, 0,   3, INF},
                        {INF, INF, 0,   1},
                        {INF, INF, INF, 0}
                        };
      
      FLOYDWARSHALL a = new FLOYDWARSHALL(graph);
      a.floydWarshall();
      a.printSolution();
      System.out.println(a.getSP(1,3)); 
   }
}
