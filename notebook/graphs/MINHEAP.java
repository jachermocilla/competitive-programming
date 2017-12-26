//Adapted from: https://www.unf.edu/~wkloster/3540/heap.java
import java.io.*; //for I/O

class HEAPNODE{
   public int i;
   public int k;
   public HEAPNODE(int i, int k){
      this.i = i;
      this.k = k;
   }
}

public class MINHEAP{

   public HEAPNODE [] A;            
   public int n;              
   
   public MINHEAP(HEAPNODE B[]) throws IOException {
      A = new String[B.length];        
      System.arraycopy(B,0,A,0,B.length); 
      n = A.length;           
      for(int i=n/2-1; i>=0; i--){
         heapify(i);          
      }
   }

   public void heapify(int i){  
      int left, r, min, tmp;    

      left = 2 * i + 1;         
      r = 2 * i + 2;            

      if(left < n && A[left].k < A[i].k) 
         min = left;               
      else
         min = i;

      if(r < n && A[r].k < A[min].k)
         min = r;               

      if(min != i){           
         tmp = A[i].k;          
         A[i].k = A[min].k;
         A[min].k = tmp;
         heapify(min); 
      }
   }

   public void insert(int key){         
      int i;            
      n++;              
      i = n-1;                                

      while(i > 0 && A[(i-1)/2].k > key){
         A[i] = A[(i-1)/2];
         i = (i-1)/2;
      }
      A[i].k = key; 
   }

   public int extractMin(){
      int min;          
      if(n < 1){            
         System.out.println("error");
         return -1; 
      }
      else{
         min = A[0].k;
         A[0].k = A[n-1].k;         
         n--;                 
         heapify(0);          
         return min;          
      }
   }

   public int isEmpty()            
   {
      if(n == 0)           
         return 1;
      else
         return 0;         
   }

   public static void main(String args[]) throws IOException{
      int data[]={5,4,3,2}; 
      MINHEAP pq; 
      pq=new MINHEAP(data);
      System.out.println(pq.extractMin());
      pq.insert(1);
      System.out.println(pq.extractMin());
   }

}
