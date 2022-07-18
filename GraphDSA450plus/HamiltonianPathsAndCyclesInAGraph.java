 package GraphDSA450plus;

import java.util.ArrayList;
import java.util.HashSet;

//if path then with '.' and if it is cycle then with '*'
public class HamiltonianPathsAndCyclesInAGraph {
	public static class Edge{
		int src ; 
		int nbr;
		Edge(int src,int nbr){
			this.src = src;
			this.nbr = nbr;
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
		graph[2].add(new Edge(2,5));
		
	    graph[3].add(new Edge(3,0));
	    graph[3].add(new Edge(3,2));
	    graph[3].add(new Edge(3,4));
	    
	    graph[4].add(new Edge(4,3));
	    graph[4].add(new Edge(4,5));
	    graph[4].add(new Edge(4,6));
	    
	    graph[5].add(new Edge(5,2));
	    graph[5].add(new Edge(5,4));
	    graph[5].add(new Edge(5,6));
	    
	    graph[6].add(new Edge(6,4));
	    graph[6].add(new Edge(6,5));
	    
	    int src=0;
	    HashSet<Integer> visited = new HashSet();
	    hamiltonian(graph,src,visited, src + " ",src);
	}
	public static void hamiltonian(ArrayList<Edge>[] graph,int src,HashSet<Integer> visited,String psf,int osrc) {//original source
		if(visited.size()==graph.length-1) {
			System.out.print(psf);
			//hamiltonian cycle
			boolean closingEdgeFound = false;
			
			for(Edge e : graph[src]) {
				if(e.nbr==osrc) {
					closingEdgeFound = true;
					break;
				}
			}
			if(closingEdgeFound==true) {
				System.out.println("*");
			}
			else {
				System.out.println(".");
			}
			return;
		}
		visited.add(src);
		for(Edge e : graph[src]) {
			if(visited.contains(e.nbr)==false) {
				hamiltonian(graph,e.nbr,visited,psf + e.nbr,osrc);
			}
		}
		visited.remove(src); 
	}
}
