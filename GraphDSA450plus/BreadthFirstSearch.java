package GraphDSA450plus;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BreadthFirstSearch {
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
		
		int src = 2 ;
		ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
		queue.add(new Pair(src,src+""));
		boolean[] visited = new boolean[vecs];
		while(queue.size()>0) {
			//r m* w a* //remove mark work add
			Pair rem = queue.removeFirst();
			
			if(visited[rem.v] ==true) continue;
			visited[rem.v] =true;
			System.out.println(rem.v + "@" + rem.psf);
			for(Edge e : graph[rem.v]) {
				if(visited[e.nbr] ==false){
					queue.add(new Pair(e.nbr,rem.psf + e.nbr));
				}
			}
		}
		
	}
}
