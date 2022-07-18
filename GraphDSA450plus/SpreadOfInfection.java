package GraphDSA450plus;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class SpreadOfInfection {
	
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
		    int time;
			Pair(int v,int time){
				this.v = v;
				this.time = time;
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
			
			int src = 6 ; 
			int t=3;
			ArrayDeque<Pair> q = new ArrayDeque<>();
			q.add(new Pair(src,1));
			//visited ko hum integer me krenge kyu ki hm dikhayenge ki ye iss timne bimar hua
			int[] visited = new int[vecs];
			int count=0;
			while(q.size()>0) {
				Pair rem = q.removeFirst();
				if(visited[rem.v]>0) continue;
			
				visited[rem.v] = rem.time;
				if(rem.time>t) break;
				count++;
				for(Edge e : graph[rem.v]) {
					if(visited[e.nbr]==0) {
						q.add(new Pair(e.nbr,rem.time + 1));
					}
				}
			}
			System.out.println(count);
}
		
}
