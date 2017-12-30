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
}

class HOMDEL2{

   // Driver program to test above function
   public static void main (String[] args) throws IOException{
   final int INF = 99999; 
      int g[][];
   
      int N,M,SGD[]=new int[3];

      BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
      String line;

      N = Integer.parseInt(bi.readLine());
      g=new int[N][N];

      for (int i=0;i<N;i++){
         line=bi.readLine();
         int j=0;
         for (String numStr: line.split("\\s")){
            g[i][j]=Integer.parseInt(numStr);
            j++;
         } 
      }
      
      FLOYDWARSHALL a = new FLOYDWARSHALL(g);
      a.floydWarshall();
      
      M = Integer.parseInt(bi.readLine());
      for (int i=0;i<M;i++){
         line=bi.readLine();
         int j=0;
         for (String numStr: line.split("\\s")){
            SGD[j]=Integer.parseInt(numStr);
            j++;
         }
   
         int t=a.getSP(SGD[0],SGD[1])+a.getSP(SGD[1],SGD[2]);
         System.out.println(t+" "+(t-a.getSP(SGD[0],SGD[2]))); 
      } 
      //a.printSolution();
      //System.out.println(a.getSP(1,3)); 
   }
}
