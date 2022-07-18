package GraphDSA450plus;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkshtraAlgorithm {
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
	public static class Pair implements Comparable<Pair>{
		int v;
		String psf;
		int wsf;//weight so far
		Pair(int v,String psf,int wsf){
			this.v = v;
			this.psf = psf;
			this.wsf = wsf;
		}
		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}
	}
	public static void main(String[] args) {
		int vecs = 7 ;
		ArrayList<Edge>[] graph = new ArrayList[vecs];
	    for(int i=0;i<vecs;i++) {
	    	graph[i] = new ArrayList<Edge>();
	    }
	    graph[0].add(new Edge(0,1,10));
	    graph[0].add(new Edge(0,3,40));
	    
	    graph[1].add(new Edge(1,0,10));
	    graph[1].add(new Edge(1,2,10));
	    
	    graph[2].add(new Edge(2,1,10));
	    graph[2].add(new Edge(2,3,10));
	    
	    graph[3].add(new Edge(3,0,40));
	    graph[3].add(new Edge(3,2,10));
	    graph[3].add(new Edge(3,4,2));
	    graph[4].add(new Edge(4,3,2));
	    graph[4].add(new Edge(4,5,3));
	    graph[4].add(new Edge(4,6,8));
	    
	    graph[5].add(new Edge(5,4,3));
	    graph[5].add(new Edge(5,6,3));
	    
	    graph[6].add(new Edge(6,4,6));
	    graph[6].add(new Edge(6,5,3));
	    
	    int src = 0 ;
	    PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
	    pq.add(new Pair(src , src + "",0));
	    boolean[] visited = new boolean[vecs];
	    while(pq.size()>0) {
	    	//remove
	    	Pair rem = pq.remove();
	    	//mark*
	        if(visited[rem.v]==true) continue;
	        
	        visited[rem.v] = true;
	        //add*
	        System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);
	        
	        for(Edge e : graph[rem.v]) {
	        	if(visited[e.nbr]==false) {
	        		pq.add(new Pair(e.nbr , rem.psf + e.nbr,rem.wsf + e.wt));
	        		
	        	}
	        }
	        
	    }
	    
	}
}
