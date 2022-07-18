package GraphDSA450plus;

import java.util.ArrayList;
import java.util.Stack;

//order compilation
public class TopologicalSort {
	public static class Edge{
		int src;
		int nbr;
		Edge(int src,int nbr){
			this.src = src;
			this.nbr = nbr;
		}
	}
	public static void main(String[] args) {
		int vecs = 7 ;
		ArrayList<Edge>[] graph = new ArrayList[vecs];
		for(int i=0;i<vecs;i++) {
			graph[i]= new ArrayList<>();
		}
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,3));
		
		graph[1].add(new Edge(1,2));
		
		graph[2].add(new Edge(2,3));
		graph[4].add(new Edge(4,3));
		graph[4].add(new Edge(4,5));
		graph[4].add(new Edge(4,6));
		graph[5].add(new Edge(5,6));
		
		boolean[] visited = new boolean[vecs];
		Stack<Integer> st = new Stack<>();
		for(int v=0;v<vecs;v++) {
			if(visited[v]==false) {
				topologicalSort(graph,v,visited,st);
			}
		}
		while(st.size()>0) {
			System.out.println(st.pop() );
		}
	}
	public static void topologicalSort(ArrayList<Edge>[] graph,int src,boolean[] visited,Stack<Integer> st) {
		visited[src] = true;
		for(Edge e : graph[src]) {
			if(!visited[e.nbr]) {
				topologicalSort(graph,e.nbr,visited,st);
			}
		}
		st.push(src);
		
	}
}
