package GraphDSA450plus;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class IsGraphIsCyclicUsingBFS {
	public static class Edge{
		int src;
		int nbr;
		Edge(int src,int nbr){

			this.src = src ; 
			this.nbr = nbr;
		}
	}
	
	public static class Pair{
		int  v;
		String psf;
		Pair(int v,String psf){
			this.v = v;
			this.psf = psf;
		}
	}
	public static void main(String[] args) {
	    int vecs = 7;	
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
		
	    boolean[] visited = new boolean[vecs];
	    for(int v=0;v<vecs;v++) {
	    	if(visited[v]==false) {
	    		 boolean cycle = isCyclic(graph,v,visited);
	    	
	    	if(cycle) {
	    		System.out.println(true);
	    	    return;
	    	}
	    }
	    }
	    System.out.println(false);
		
	}
	public static boolean isCyclic(ArrayList<Edge>[] graph,int src,boolean[] visited) {
			ArrayDeque<Pair> queue = new ArrayDeque<>();
			queue.add(new Pair(src , src + ""));
			while(queue.size()>0) {
				Pair rem = queue.removeFirst();
				if(visited[rem.v]==true) return true;
				
				visited[rem.v] =true;
				for(Edge e : graph[rem.v]) {	
					if(visited[e.nbr]==false) {
						queue.add(new Pair(e.nbr,rem.psf + e.nbr));
					}
					}
				}
			return false;
				
	}
}
