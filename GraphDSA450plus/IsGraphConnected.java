package GraphDSA450plus;

import java.util.ArrayList;

import GraphDSA450plus.GraphProblems.Edge;

public class IsGraphConnected {
	public static class Edge{
		int src;
		int nbr;
		int wt ; 
		Edge(int src,int nbr,int wt){
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	public static void main(String[] args) {
		int vecs = 7; 
		ArrayList<Edge>[] graph = new ArrayList[vecs];
		for(int i=0;i<vecs;i++) {
			graph[i] = new ArrayList<Edge>();
		}
		/*
		graph[0].add(new Edge(0,1,10));
		graph[2].add(new Edge(2,3,10));
		graph[4].add(new Edge(4,5,10));
		graph[5].add(new Edge(5,6,10));
		graph[4].add(new Edge(4,6,10));
		*/

		graph[0].add(new Edge(0,1,10));
		graph[0].add(new Edge(0,3,40));
		
		graph[1].add(new Edge(1 ,0,10));
		graph[1].add(new Edge(1,2,10));
		
		graph[2].add(new Edge(2,1,10));
		graph[2].add(new Edge(2,3,10));
		
		graph[3].add(new Edge(3 ,0,40));
		graph[3].add(new Edge(3,2,10));
		graph[3].add(new Edge(3,4,2));
		
		graph[4].add(new Edge(4,3,2));
		graph[4].add(new Edge(4,5,3));
		graph[4].add(new Edge(4,6,8));
		
		graph[5].add(new Edge(5,4,3));
		graph[5].add(new Edge(5,6,3));
		
		graph[6].add(new Edge(6,4,8));
		graph[6].add(new Edge(6,5,3));
		//component of components
		//high level code
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
		boolean[] visited =  new boolean[vecs];
		for(int v=0;v<vecs;v++) {
			if(visited[v]==false) {
				ArrayList<Integer> comp = new ArrayList<Integer>();
				drawTreeAndCheckConnected(graph,v,comp,visited);
			    comps.add(comp);
			}
		}
		System.out.println(comps.size()==1);
	}
	public static void drawTreeAndCheckConnected(ArrayList<Edge>[] graph,int src,ArrayList<Integer> comp,boolean[] visited) {
		visited[src] = true;
		comp.add(src);
		for(Edge edge : graph[src]) {
			if(visited[edge.nbr] ==false) {
				drawTreeAndCheckConnected(graph,edge.nbr,comp,visited);
			}
		}
	}
}
