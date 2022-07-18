package GraphDSA450plus;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class IsAGraphBipartite {
	public static class Edge{
		int src;
		int nbr;
		Edge(int src,int nbr){
			this.src = src;
			this.nbr = nbr;
		}
	}
	public static class Pair {
		int v;
		String psf;
		int level;
		Pair(int v,String psf,int level){
			this.v= v;
			this.psf = psf;
			this.level = level;
		}
	}
	public static void main(String[] args) {
		int vecs = 7 ;
		ArrayList<Edge>[] graph = new ArrayList[vecs];
		for(int i=0;i<vecs;i++) {
			graph[i] = new ArrayList<Edge>();
		}
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,3));
		
		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,2));
		
		graph[2].add(new Edge(2,1));
		graph[2].add(new Edge(2,3));
		
		
		graph[3].add(new Edge(3,0));
		graph[3].add(new Edge(3,2));
		graph[3].add(new Edge(3,4));
		
		graph[4].add(new Edge(4,3));
		graph[4].add(new Edge(4,5));
		graph[4].add(new Edge(4,6));
		
		
		graph[5].add(new Edge(5,4));
		graph[5].add(new Edge(5,6));
		
		graph[6].add(new Edge(6,4));
		graph[6].add(new Edge(6,5));
		
//		int src = 2 ;
		int[] visited = new int[vecs];
		Arrays.fill(visited, -1);
		for(int v=0;v<vecs;v++) {
			if(visited[v]==-1) {
				boolean isComponentBipartite = checkComponentForBipartiteness(graph,v,visited);
				if(isComponentBipartite==false) {
					System.out.println(false);
					return;
				}
				
			}
		}
		System.out.println(true);
	}

	// r m* w a* 
	
	public static boolean checkComponentForBipartiteness(ArrayList<Edge>[] graph,int src,int[] visited) {
		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(src,src+"",0));
		
		while(q.size()>0) {
			Pair rem = q.removeFirst();
			if(visited[rem.v]!=-1) {
				if(rem.level != visited[rem.v]) {
					return false;
				}
			}
			else {
				visited[rem.v] = rem.level;
			}
			for(Edge e : graph[rem.v]) {
				if(visited[e.nbr]==-1) {
					q.add(new Pair(e.nbr,rem.psf + e.nbr , rem.level+1));
				}
			}
		}
		return true;
	}
}
