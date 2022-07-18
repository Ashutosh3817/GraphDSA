package GraphDSA450plus;

import java.util.ArrayList;

import GraphDSA450plus.CreateAGraphAndPrintIt.Edge;

public class FindAllThePathUsingDFS {
	public static class Edge{
		int src;
		int nbr;
		int wt;
		Edge(int src,int nbr,int wt){
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	public static void main(String[] args) {
		int vecs = 7 ;
		ArrayList<Edge>[] graph = new ArrayList[vecs];
		for(int i=0;i<vecs;i++) {
			graph[i] = new ArrayList<Edge>();
		}

		graph[0].add(new Edge(0,1,40));
		graph[0].add(new Edge(0,3,10));
		
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
		
		int src = 0 ;
		int dest = 6;
		boolean[] visited = new boolean[vecs];
		printAllPaths(graph,src,dest,visited,src + " ");
	}
	//path so far
	public static void printAllPaths(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited,String psf) {
		if(src==dest) {
			System.out.println(psf);
			return ;
		}
		visited[src] = true;
		for(Edge edge : graph[src]) {
			if(visited[edge.nbr] == false) {
				printAllPaths(graph,edge.nbr,dest,visited,psf + edge.nbr);
			}
		}
		visited[src] = false;
	}
}
