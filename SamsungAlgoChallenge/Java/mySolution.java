/////////////////////////////////////////////////////////////////////////////////////////////
//
//	Please, implement your algorithm from this section.
//	DO NOT CHANGE THE FUNCTION SIGNATURE
//	You may add additional methods and class variables
//
/////////////////////////////////////////////////////////////////////////////////////////////

//https://stackoverflow.com/questions/22642902/how-to-implement-bfs-on-a-matrix

import java.util.*;
 
public class mySolution {
    //https://www.java2blog.com/breadth-first-search-in-java/
    private Queue<Node> queue;
    static ArrayList<Node> nodes=new ArrayList<Node>();
    static class Node
    {
        int data;
        int row,col;
        boolean visited;
        List<Node> neighbours;
 
        Node(int data,int row, int col)
        {
            this.data=data;
            this.row=row;
            this.col=col;
            this.neighbours=new ArrayList<>();
 
        }
        public void addneighbours(Node neighbourNode)
        {
            this.neighbours.add(neighbourNode);
        }
        public List<Node> getNeighbours() {
            return neighbours;
        }
        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }
    } 

    public mySolution(){
        queue = new LinkedList<Node>();
    }

	
    public int bfs(Node node,int N, int H1row, int H1col, int H2row, int H2col, int T1row, int T1col, int T2row, int T2col, int obs[])	
    {
        int d=0;
        queue.add(node);
        node.visited=true;
        while (!queue.isEmpty())
        {
 
            Node element=queue.remove();
            System.out.print(element.data + "\t");
            
            if (node.row==T1row && node.col==T1col){
                d++;
                return d; 
            }

            //TODO: insert 
            //code to add the neighbors here
            //////

            List<Node> neighbours=element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                Node n=neighbours.get(i);
                if(n!=null && !n.visited)
                {
                    queue.add(n);
                    n.visited=true;
 
                }
            }
 
        }
        return -1;
    }

	
    public int mysolution(int N, int H1row, int H1col, int H2row, int H2col, int T1row, int T1col, int T2row, int T2col, int obs[])	{
/*
        System.out.println(N);
        System.out.println(H1row);
        System.out.println(H1col);
        System.out.println(H2row);
        System.out.println(H2col);
        System.out.println(T1row);
        System.out.println(T1col);
        System.out.println(T2row);
        System.out.println(T2col);
        Node node40 =new Node(40,1,1);
        Node node10 =new Node(10,1,1);
        Node node20 =new Node(20,1,1);
        Node node30 =new Node(30,1,1);
        Node node60 =new Node(60,1,1);
        Node node50 =new Node(50,1,1);
        Node node70 =new Node(70,1,1);
 
        node40.addneighbours(node10);
        node40.addneighbours(node20);
        node10.addneighbours(node30);
        node20.addneighbours(node10);
        node20.addneighbours(node30);
        node20.addneighbours(node60);
        node20.addneighbours(node50);
        node30.addneighbours(node60);
        node60.addneighbours(node70);
        node50.addneighbours(node70);
*/
        Node H1 = new Node(1,H1row,H1col);
        System.out.println("The BFS traversal of the graph is ");
        mySolution bfsExample = new mySolution();
        bfsExample.bfs(H1,N,H1row,H1col,H2row,H2col,T1row,T1col,T2row,T2col,obs);
		return -1;
	}
}
