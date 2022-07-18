package GraphDSA450plus;

import java.util.ArrayList;

public class PerfectFriends {
	public static class Edge{
		int src;
		int nbr;
		Edge(int src,int nbr){
		this.src =src;
		this.nbr = nbr;
	}
}
	public static void main(String[] args) {
		int vecs =  7 ;
		ArrayList<Edge>[] graph = new ArrayList[vecs];
		for(int i=0;i<vecs;i++) {
			graph[i] = new ArrayList<Edge>();
		}
		graph[0].add(new Edge(0,1));
		graph[2].add(new Edge(2,3));
		graph[4].add(new Edge(4,5));
		graph[5].add(new Edge(5,6));
		graph[4].add(new Edge(4,6));
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
		boolean[] visited = new boolean[vecs];
		for(int v=0;v<vecs;v++) {
			if(visited[v]==false) {
				ArrayList<Integer> comp = new ArrayList<>();
				drawTree(graph,v,comp,visited);
				comps.add(comp);
			}
		}
		int pairs=0;
		for(int i=0;i<comps.size();i++) {
			for(int j=i+1;j<comps.size();j++) {
				int count = comps.get(i).size() * comps.get(j).size();
				pairs += count;
			}
		}
		System.out.println(comps);
		System.out.println(pairs);
	}
	public static void drawTree(ArrayList<Edge>[] graph,int src,ArrayList<Integer> comp,boolean[] visited) {
		visited[src] = true;
		comp.add(src);
		for(Edge e : graph[src]) {
			if(visited[e.nbr] ==false) {
				drawTree(graph,e.nbr,comp,visited);
			}
		}
	} 
}
