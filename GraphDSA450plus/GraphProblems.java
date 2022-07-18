package GraphDSA450plus;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GraphProblems {
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
	
	static class Pair implements Comparable<Pair>{
		int wsf;
		String psf;
		Pair(int wsf,String psf){
			this.wsf = wsf;
			this.psf = psf;
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
		int dest = 6 ;
		int criteria = 40;
		int k =3;
		boolean[] visited = new boolean[vecs];
		multiSolver(graph,src,dest,visited,criteria,k,src + " ",0);
		System.out.println("Smallest Path = "+ spath + " = " + "@" + spathwt );
		System.out.println("Largest Path = " + lpath +" = "+ "@" + lpathwt);
		System.out.println("Just Largest Path than " + criteria +" = " + cpath +"@"+cpathwt);//ceilpath
		System.out.println("Just Smaller Path Than " + criteria + " = " + fpath +"@"+fpathwt);//floor path
		System.out.println(k + "th largest Path = "+pq.peek().psf+"@" + pq.peek().wsf);
	}
	
	static String spath;
	static Integer spathwt = Integer.MAX_VALUE;
	static String lpath;
	static Integer lpathwt = Integer.MIN_VALUE;
	static String cpath;
	static Integer cpathwt = Integer.MAX_VALUE;
	static String fpath;
	static Integer fpathwt = Integer.MIN_VALUE;
	static PriorityQueue<Pair> pq = new PriorityQueue();
	public static void multiSolver(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited,int criteria,int k,String psf,int wsf) {
		if(src==dest) {
			if(wsf<spathwt) {
				spathwt = wsf;
				spath = psf;
			}
			if(wsf>lpathwt) {
				lpathwt = wsf;
				lpath = psf;
			}
			if(wsf>criteria && wsf<cpathwt) {
				cpathwt = wsf;
				cpath = psf;
			}
			if(wsf<criteria && wsf>fpathwt) {
				 fpathwt =  wsf; //ceil => bado me sbse chota 
				 fpath =  psf;//floor => choto me sbse bada
			} 
			
			if(pq.size()<k) pq.add(new Pair(wsf,psf));
			else {
				if(wsf>pq.peek().wsf) {
					pq.remove();
					pq.add(new Pair(wsf,psf));
				}
			}
			return;
		}
		visited[src] = true;
		for(Edge edge : graph[src]) {
			if(visited[edge.nbr]==false) {
				multiSolver(graph,edge.nbr,dest,visited,criteria,k,psf + edge.nbr,wsf+edge.wt);
			}
		}
		visited[src] = false;
	}
}
