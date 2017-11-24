/////////////////////////////////////////////////////////////////////////////////////////////
//
//	Please, implement your algorithm from this section.
//	DO NOT CHANGE THE FUNCTION SIGNATURE
//	You may add additional methods and class variables
//
/////////////////////////////////////////////////////////////////////////////////////////////

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
 
        Node(int data)
        {
            this.data=data;
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

	
    public void bfs(Node node)
    {
        queue.add(node);
        node.visited=true;
        while (!queue.isEmpty())
        {
 
            Node element=queue.remove();
            System.out.print(element.data + "\t");
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
*/
        Node node40 =new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);
 
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
        System.out.println("The BFS traversal of the graph is ");
        mySolution bfsExample = new mySolution();
        bfsExample.bfs(node40);

		return -1;
	}
}
