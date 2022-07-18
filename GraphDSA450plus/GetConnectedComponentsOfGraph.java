package GraphDSA450plus;

import java.util.ArrayList;

public class GetConnectedComponentsOfGraph {
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
		graph[0].add(new Edge(0,1,10));
		graph[2].add(new Edge(2,3,10));
		graph[4].add(new Edge(4,5,10));
		graph[5].add(new Edge(5,6,10));
		graph[4].add(new Edge(4,6,10));
		//component of components
		//high level code
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
		boolean[] visited =  new boolean[vecs];
		for(int v=0;v<vecs;v++) {
			if(visited[v]==false) {
				ArrayList<Integer> comp = new ArrayList<Integer>();
				drawTreeAndGenerateComponent(graph,v,comp,visited);
			    comps.add(comp);
			}
		}
		System.out.println(comps);
	}
	public static void drawTreeAndGenerateComponent(ArrayList<Edge>[] graph,int src,ArrayList<Integer> comp,boolean[] visited) {
		//low level code
		visited[src] =true;
		comp.add(src);
		for(Edge edge : graph[src]) {
			if(visited[edge.nbr] ==false) {
				drawTreeAndGenerateComponent(graph,edge.nbr,comp,visited);
			}
		}
	}
}
