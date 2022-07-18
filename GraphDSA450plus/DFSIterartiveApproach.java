package GraphDSA450plus;

import java.util.ArrayList;
import java.util.Stack;

public class DFSIterartiveApproach {
	public static class Edge{
		int src;
		int nbr;
		Edge(int src,int nbr){
			this.src = src;
			this.nbr = nbr;
		}
	}
	public static class Pair{
		int v;
	    String psf;
	    Pair(int v , String psf){
	    	this.v = v;
	    	this.psf = psf;
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
        
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));
        
        graph[6].add(new Edge(6,4));
        graph[6].add(new Edge(6,5));
        
        int src = 0 ; 
        boolean[] visited = new boolean[vecs];
        Stack<Pair> st = new Stack<Pair>();
        
        st.push(new Pair(src , src + ""));
        
        while(st.size()>0) {
        	Pair rem = st.pop();
        	
        	if(visited[rem.v] == true) continue;
        	
        	visited[rem.v] = true;
        	System.out.println(rem.v + "@" + rem.psf);
            for(Edge e : graph[rem.v]) {
            	if(visited[e.nbr] == false) {
            		st.push(new Pair(e.nbr , rem.psf + e.nbr));
            	}
            }
        }
	}
}
